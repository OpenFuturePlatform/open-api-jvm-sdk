package io.openfuture.sdk.sender

import io.openfuture.sdk.config.SenderTests
import io.openfuture.sdk.domain.scaffold.SaveOpenScaffoldRequest
import org.apache.http.HttpStatus.SC_OK
import org.apache.http.util.EntityUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.`when`

class OpenScaffoldSenderTests : SenderTests() {

    private val sender: OpenScaffoldSender = OpenScaffoldSender(token)


    @Test
    fun getAllShouldReturnPageResponseOfOpenScaffolds() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createOpenScaffoldPageResponseJson())

        val actual = sender.getAll()

        assertThat(actual.totalCount).isEqualTo(1)
        assertThat(actual.list).hasSize(1)
    }

    @Test
    fun saveShouldReturnResponseOfOpenScaffold() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createOpenScaffoldJson())

        sender.create(createSaveOpenScaffoldRequest())
    }

    private fun createSaveOpenScaffoldRequest() = SaveOpenScaffoldRequest("op_pk_029bbb64-a31d-4ec6-b881-8d8db19c70ee",
            "0xDc29484cc9C02Ee01015f33BcA8bBb5C7293Fb54", "any_description", null)

    private fun createOpenScaffoldPageResponseJson() = """{
            "totalCount": 1,
            "list": [
                ${createOpenScaffoldJson()}
            ]}"""

    private fun createOpenScaffoldJson() = """{ 
                    "developerAddress": "0xDc29484cc9C02Ee01015f33BcA8bBb5C7293Fb54",
                    "description": "any_description",
                    "webHook": null
                }"""

}