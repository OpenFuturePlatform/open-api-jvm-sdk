package io.openfuture.api.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ScaffoldQuota(
        val currentCount: Int,
        val limitCount: Int
)