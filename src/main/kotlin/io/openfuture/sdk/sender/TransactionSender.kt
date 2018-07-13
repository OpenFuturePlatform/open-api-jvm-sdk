package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.PageRequest
import io.openfuture.sdk.domain.PageResponse
import io.openfuture.sdk.domain.response.TransactionPageResponse
import io.openfuture.sdk.domain.transaction.Transaction

class TransactionSender(
        token: String,
        address: String
) : BaseSender("/api/scaffolds/$address/transactions", token) {

    fun getAll(request: PageRequest = PageRequest()): PageResponse<Transaction> =
            get("?limit=${request.limit}&offset=${request.offset}", TransactionPageResponse())

}