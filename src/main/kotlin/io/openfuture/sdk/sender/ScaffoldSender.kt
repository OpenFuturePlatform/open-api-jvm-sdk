package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.PageRequest
import io.openfuture.sdk.domain.PageResponse
import io.openfuture.sdk.domain.response.ScaffoldPageResponse
import io.openfuture.sdk.domain.response.ScaffoldQuotaResponse
import io.openfuture.sdk.domain.response.ScaffoldResponse
import io.openfuture.sdk.domain.response.ScaffoldSummaryResponse
import io.openfuture.sdk.domain.scaffold.*

class ScaffoldSender(
        token: String
) : BaseSender("/api/scaffolds", token) {

    fun getAll(request: PageRequest = PageRequest()): PageResponse<Scaffold> =
            get("?limit=${request.limit}&offset=${request.offset}", ScaffoldPageResponse())

    fun get(address: String): Scaffold = get("/$address", ScaffoldResponse())

    fun deploy(request: DeployScaffoldRequest): Scaffold = post("/doDeploy", ScaffoldResponse(), request)

    fun setWebHook(request: SetWebHookRequest): Scaffold =
            patch("/${request.address}", ScaffoldResponse(), request)

    fun summary(address: String): ScaffoldSummary = get("/$address/summary", ScaffoldSummaryResponse())

    fun deactivate(address: String): ScaffoldSummary = delete("/$address", ScaffoldSummaryResponse())

    fun quota(): ScaffoldQuota = get("/quota", ScaffoldQuotaResponse())

}