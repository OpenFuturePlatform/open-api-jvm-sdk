package io.openfuture.api.domain

data class PageResponse<T>(
        val totalCount: Long,
        val list: List<T>
)