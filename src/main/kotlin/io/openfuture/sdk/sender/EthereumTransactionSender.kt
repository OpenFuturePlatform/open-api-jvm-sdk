package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.PageRequest
import io.openfuture.sdk.domain.PageResponse
import io.openfuture.sdk.domain.response.EthereumTransactionPageResponse
import io.openfuture.sdk.domain.transaction.EhereumTransaction

class EthereumTransactionSender(
        token: String,
        address: String
) : BaseSender("/api/ethereum-scaffolds/$address/transactions", token) {

    fun getAll(request: PageRequest = PageRequest()): PageResponse<EhereumTransaction> =
            get("?limit=${request.limit}&offset=${request.offset}", EthereumTransactionPageResponse())

}