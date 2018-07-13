package io.openfuture.sdk.sender

import io.openfuture.sdk.config.SenderTests
import org.apache.http.HttpStatus
import org.apache.http.util.EntityUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.`when`

class TransactionSenderTests: SenderTests() {

    private val sender: TransactionSender = TransactionSender(token, "address")

    @Test
    fun getAllShouldReturnPageResponseOfTransactions() {
        given(statusLine.statusCode).willReturn(HttpStatus.SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createTransactionPageResponseJson())

        val actual = sender.getAll()

        assertThat(actual.totalCount).isEqualTo(1)
        assertThat(actual.list).hasSize(1)
    }

    private fun createTransactionPageResponseJson() = """{
            "totalCount": 1,
            "list": [
                ${createTransactionJson()}
            ]}"""

    private fun createTransactionJson() = """{
                    "scaffold": ${createScaffoldJson()},
                    "event": {
                      "activated": false,
                      "type": "ACTIVATED_SCAFFOLD"
                    },
                    "date":"2018-06-13"
                }"""

    private fun createScaffoldJson() = """{
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

}