package io.openfuture.sdk.sender

import io.openfuture.sdk.config.SenderTests
import io.openfuture.sdk.domain.scaffold.Currency.USD
import io.openfuture.sdk.domain.scaffold.DeployEthereumScaffoldRequest
import io.openfuture.sdk.domain.scaffold.SetWebHookRequest
import io.openfuture.sdk.exception.ClientException
import io.openfuture.sdk.exception.ServerException
import org.apache.http.HttpStatus.*
import org.apache.http.util.EntityUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.`when`

class EthereumScaffoldSenderTests : SenderTests() {

    private val sender: EthereumScaffoldSender = EthereumScaffoldSender(token)


    @Test
    fun getAllShouldReturnPageResponseOfScaffolds() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createEthereumScaffoldPageResponseJson())

        val actual = sender.getAll()

        assertThat(actual.totalCount).isEqualTo(1)
        assertThat(actual.list).hasSize(1)
    }

    @Test
    fun getShouldReturnScaffold() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createEthereumScaffoldJson())

        sender.get("address")
    }

    @Test
    fun deployShouldReturnScaffold() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createEthereumScaffoldJson())

        sender.deploy(createDeployRequest())
    }

    @Test
    fun setWebHookShouldReturnScaffold() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createEthereumScaffoldJson())

        sender.setWebHook(createSetWebHookRequest())
    }

    @Test
    fun summaryShouldReturnScaffoldSummary() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createEthereumScaffoldSummaryJson())

        sender.summary("address")
    }

    @Test
    fun deactivateShouldReturnScaffoldSummary() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createEthereumScaffoldSummaryJson())

        sender.deactivate("address")
    }

    @Test
    fun quotaShouldReturnQuota() {
        given(statusLine.statusCode).willReturn(SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createEthereumScaffoldQuotaJson())

        sender.quota()
    }

    @Test(expected = ServerException::class)
    fun onServerErrorShouldThrowServerException() {
        given(statusLine.statusCode).willReturn(SC_INTERNAL_SERVER_ERROR)

        sender.quota()
    }

    @Test(expected = ClientException::class)
    fun onClientErrorShouldThrowClientException() {
        given(statusLine.statusCode).willReturn(SC_BAD_REQUEST)
        `when`(EntityUtils.toString(entity)).thenReturn(createClientExceptionJson())

        sender.quota()
    }


    private fun createEthereumScaffoldPageResponseJson() = """{
            "totalCount": 1,
            "list": [
                ${createEthereumScaffoldJson()}
            ]}"""

    private fun createEthereumScaffoldJson() = """{
                    "address": "0x1c297f40beb075936d6dbe4b245b92736667ecb1",
                    "user": {
                        "id": 1,
                        "credits": 0,
                        "openKeys": [
                            {
                                "value": "op_pk_029bbb64-a31d-4ec6-b881-8d8db19c70ee",
                                "enabled": true,
                                "expiredDate": null
                            }
                        ]
                    },
                    "abi": "[]",
                    "developerAddress": "0xDc29484cc9C02Ee01015f33BcA8bBb5C7293Fb54",
                    "description": "any_description",
                    "fiatAmount": "123",
                    "currency": "USD",
                    "conversionAmount": "0.2139521163",
                    "properties": [
                        {
                            "name": "property_name",
                            "type": "STRING",
                            "defaultValue": "property_value"
                        }
                    ],
                    "enabled": false
                }"""

    private fun createEthereumScaffoldSummaryJson() = """{
                    "ethereumScaffold": ${createEthereumScaffoldJson()},
                    "transactionIndex": 0,
                    "vendorAddress": "0xdc29484cc9c02ee01015f33bca8bbb5c7293fb54",
                    "tokenBalance": 0,
                    "enabled": false,
                    "shareHolders":[]
                }"""

    private fun createEthereumScaffoldQuotaJson() = """{
                    "currentCount": 1,
                    "limitCount": 10
                }"""

    private fun createClientExceptionJson() = """{
                    "status": 400,
                    "message": "Method Argument Not Valid"
                }"""

    private fun createDeployRequest() = DeployEthereumScaffoldRequest("ok", "devAdd", "desc", "1.9", USD, "0.2")

    private fun createSetWebHookRequest() = SetWebHookRequest("add", "hook")

}