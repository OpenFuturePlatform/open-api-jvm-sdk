package io.openfuture.sdk.sender

import io.openfuture.sdk.config.SenderTests
import io.openfuture.sdk.domain.holder.AddShareHolderRequest
import io.openfuture.sdk.domain.holder.RemoveShareHolderRequest
import io.openfuture.sdk.domain.holder.UpdateShareHolderRequest
import org.apache.http.HttpStatus
import org.apache.http.util.EntityUtils
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.`when`

class ShareHolderSenderTests: SenderTests() {

    private val sender: ShareHolderSender = ShareHolderSender(token, "address")


    @Test
    fun addShouldReturnSummary() {
        given(statusLine.statusCode).willReturn(HttpStatus.SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createScaffoldSummaryJson())

        sender.add(createAddHolderRequest())
    }

    @Test
    fun updateShouldReturnSummary() {
        given(statusLine.statusCode).willReturn(HttpStatus.SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createScaffoldSummaryJson())

        sender.update(createUpdateHolderRequest())
    }

    @Test
    fun removeShouldReturnSummary() {
        given(statusLine.statusCode).willReturn(HttpStatus.SC_OK)
        `when`(EntityUtils.toString(entity)).thenReturn(createScaffoldSummaryJson())

        sender.remove(createRemoveHolderRequest())
    }

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

    private fun createScaffoldSummaryJson() = """{
                    "scaffold": ${createScaffoldJson()},
                    "transactionIndex": 0,
                    "vendorAddress": "0xdc29484cc9c02ee01015f33bca8bbb5c7293fb54",
                    "tokenBalance": 0,
                    "enabled": false,
                    "shareHolders":[{
                        "address": "0x1c297f40beb075936d6dbe4b245b92738867ecb1",
                        "percent": 30
                    }]
                }"""

    private fun createAddHolderRequest() = AddShareHolderRequest("address", 1)

    private fun createUpdateHolderRequest() = UpdateShareHolderRequest("address", 1)

    private fun createRemoveHolderRequest() = RemoveShareHolderRequest("address")

}