package io.openfuture.sdk.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class EthereumShareHolder(
        val address: String,
        val percent: Int
)