package io.openfuture.api

import io.openfuture.api.sender.ScaffoldSender
import io.openfuture.api.sender.ShareHolderSender
import io.openfuture.api.sender.TransactionSender

class OpenJ(
        private val token: String
) {

    fun scaffold() = ScaffoldSender(token)

    fun transaction(address: String) = TransactionSender(token, address)

    fun shareHolder(address: String) = ShareHolderSender(token, address)

}