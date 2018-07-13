package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.holder.AddShareHolderRequest
import io.openfuture.sdk.domain.holder.RemoveShareHolderRequest
import io.openfuture.sdk.domain.holder.UpdateShareHolderRequest
import io.openfuture.sdk.domain.response.ScaffoldSummaryResponse
import io.openfuture.sdk.domain.scaffold.ScaffoldSummary

class ShareHolderSender(
        token: String, address: String
) : BaseSender("/api/scaffolds/$address/holders", token) {

    fun add(request: AddShareHolderRequest): ScaffoldSummary = post("", ScaffoldSummaryResponse(), request)

    fun update(request: UpdateShareHolderRequest): ScaffoldSummary =
            put("/${request.address}", ScaffoldSummaryResponse(), request)

    fun remove(request: RemoveShareHolderRequest): ScaffoldSummary =
            delete("/${request.address}", ScaffoldSummaryResponse())

}