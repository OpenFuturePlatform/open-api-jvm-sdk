package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.holder.AddEthereumShareHolderRequest
import io.openfuture.sdk.domain.holder.RemoveEthereumShareHolderRequest
import io.openfuture.sdk.domain.holder.UpdateEthereumShareHolderRequest
import io.openfuture.sdk.domain.response.EthereumScaffoldSummaryResponse
import io.openfuture.sdk.domain.scaffold.EthereumScaffoldSummary

class EthereumShareHolderSender(
        token: String, address: String
) : BaseSender("/api/ethereum-scaffolds/$address/holders", token) {

    fun add(request: AddEthereumShareHolderRequest): EthereumScaffoldSummary = post("", EthereumScaffoldSummaryResponse(), request)

    fun update(request: UpdateEthereumShareHolderRequest): EthereumScaffoldSummary =
            put("/${request.address}", EthereumScaffoldSummaryResponse(), request)

    fun remove(request: RemoveEthereumShareHolderRequest): EthereumScaffoldSummary =
            delete("/${request.address}", EthereumScaffoldSummaryResponse())

}