package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.holder.AddShareHolderRequest
import io.openfuture.sdk.domain.holder.RemoveShareHolderRequest
import io.openfuture.sdk.domain.holder.UpdateShareHolderRequest
import io.openfuture.sdk.domain.response.EthereumScaffoldSummaryResponse
import io.openfuture.sdk.domain.scaffold.EthereumScaffoldSummary

class EthereumShareHolderSender(
        token: String, address: String
) : BaseSender("/api/ethereum-scaffolds/$address/holders", token) {

    fun add(request: AddShareHolderRequest): EthereumScaffoldSummary = post("", EthereumScaffoldSummaryResponse(), request)

    fun update(request: UpdateShareHolderRequest): EthereumScaffoldSummary =
            put("/${request.address}", EthereumScaffoldSummaryResponse(), request)

    fun remove(request: RemoveShareHolderRequest): EthereumScaffoldSummary =
            delete("/${request.address}", EthereumScaffoldSummaryResponse())

}