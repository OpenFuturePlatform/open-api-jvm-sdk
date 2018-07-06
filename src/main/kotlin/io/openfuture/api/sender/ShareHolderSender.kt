package io.openfuture.api.sender

import io.openfuture.api.domain.holder.AddShareHolderRequest
import io.openfuture.api.domain.holder.RemoveShareHolderRequest
import io.openfuture.api.domain.holder.UpdateShareHolderRequest
import io.openfuture.api.domain.response.ScaffoldSummaryResponse
import io.openfuture.api.domain.scaffold.ScaffoldSummary

class ShareHolderSender(
        token: String, address: String
) : BaseSender("/api/scaffolds/$address/holders", token) {

    fun add(request: AddShareHolderRequest): ScaffoldSummary = post("", ScaffoldSummaryResponse(), request)

    fun update(request: UpdateShareHolderRequest): ScaffoldSummary =
            put("/${request.address}", ScaffoldSummaryResponse(), request)

    fun remove(request: RemoveShareHolderRequest): ScaffoldSummary =
            delete("/${request.address}", ScaffoldSummaryResponse())

}