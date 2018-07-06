package io.openfuture.api.sender

import io.openfuture.api.domain.PageRequest
import io.openfuture.api.domain.PageResponse
import io.openfuture.api.domain.response.TransactionPageResponse
import io.openfuture.api.domain.transaction.Transaction

class TransactionSender(
        token: String,
        address: String
) : BaseSender("/api/scaffolds/$address/transactions", token) {

    fun getAll(request: PageRequest = PageRequest()): PageResponse<Transaction> =
            get("?limit=${request.limit}&offset=${request.offset}", TransactionPageResponse())

}