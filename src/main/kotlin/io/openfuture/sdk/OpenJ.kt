package io.openfuture.sdk

import io.openfuture.sdk.sender.ScaffoldSender
import io.openfuture.sdk.sender.ShareHolderSender
import io.openfuture.sdk.sender.TransactionSender

class OpenJ(
        private val token: String
) {

    fun scaffold() = ScaffoldSender(token)

    fun transaction(address: String) = TransactionSender(token, address)

    fun shareHolder(address: String) = ShareHolderSender(token, address)

}