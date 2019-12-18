package io.openfuture.sdk.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class EthereumScaffoldQuota(
        val currentCount: Int,
        val limitCount: Int
)