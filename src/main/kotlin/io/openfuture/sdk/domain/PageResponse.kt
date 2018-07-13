package io.openfuture.sdk.domain

data class PageResponse<T>(
        val totalCount: Long,
        val list: List<T>
)