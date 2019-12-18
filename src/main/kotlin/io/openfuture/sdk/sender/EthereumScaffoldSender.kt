package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.PageRequest
import io.openfuture.sdk.domain.PageResponse
import io.openfuture.sdk.domain.response.EthereumScaffoldPageResponse
import io.openfuture.sdk.domain.response.EthereumScaffoldQuotaResponse
import io.openfuture.sdk.domain.response.EthereumScaffoldResponse
import io.openfuture.sdk.domain.response.EthereumScaffoldSummaryResponse
import io.openfuture.sdk.domain.scaffold.*

class EthereumScaffoldSender(
        token: String
) : BaseSender("/api/ethereum-scaffolds", token) {

    fun getAll(request: PageRequest = PageRequest()): PageResponse<EthereumScaffold> =
            get("?limit=${request.limit}&offset=${request.offset}", EthereumScaffoldPageResponse())

    fun get(address: String): EthereumScaffold = get("/$address", EthereumScaffoldResponse())

    fun deploy(request: DeployEthereumScaffoldRequest): EthereumScaffold = post("/doDeploy", EthereumScaffoldResponse(), request)

    fun setWebHook(request: SetWebHookRequest): EthereumScaffold =
            patch("/${request.address}", EthereumScaffoldResponse(), request)

    fun summary(address: String): EthereumScaffoldSummary = get("/$address/summary", EthereumScaffoldSummaryResponse())

    fun deactivate(address: String): EthereumScaffoldSummary = delete("/$address", EthereumScaffoldSummaryResponse())

    fun quota(): EthereumScaffoldQuota = get("/quota", EthereumScaffoldQuotaResponse())

}