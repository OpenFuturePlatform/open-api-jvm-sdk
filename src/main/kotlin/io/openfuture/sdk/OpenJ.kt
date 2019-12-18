package io.openfuture.sdk

import io.openfuture.sdk.sender.EthereumScaffoldSender
import io.openfuture.sdk.sender.EthereumShareHolderSender
import io.openfuture.sdk.sender.EthereumTransactionSender
import io.openfuture.sdk.sender.OpenScaffoldSender

class OpenJ(
        private val token: String
) {

    fun ethereumScaffold() = EthereumScaffoldSender(token)

    fun ethereumTransaction(address: String) = EthereumTransactionSender(token, address)

    fun ethereumShareHolder(address: String) = EthereumShareHolderSender(token, address)

    fun openScaffold() = OpenScaffoldSender(token)

}