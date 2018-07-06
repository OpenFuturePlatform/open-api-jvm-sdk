package io.openfuture.api.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ShareHolder(
        val address: String,
        val percent: Int
)