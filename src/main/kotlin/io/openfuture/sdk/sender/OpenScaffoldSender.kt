package io.openfuture.sdk.sender

import io.openfuture.sdk.domain.PageRequest
import io.openfuture.sdk.domain.PageResponse
import io.openfuture.sdk.domain.response.OpenScaffoldPageResponse
import io.openfuture.sdk.domain.response.OpenScaffoldResponse
import io.openfuture.sdk.domain.scaffold.OpenScaffold
import io.openfuture.sdk.domain.scaffold.SaveOpenScaffoldRequest

class OpenScaffoldSender(
        token: String
) : BaseSender("/api/open-scaffolds", token) {

    fun getAll(request: PageRequest = PageRequest()): PageResponse<OpenScaffold> =
            get("?limit=${request.limit}&offset=${request.offset}", OpenScaffoldPageResponse())

    fun create(request: SaveOpenScaffoldRequest): OpenScaffold = post("", OpenScaffoldResponse(), request)

}