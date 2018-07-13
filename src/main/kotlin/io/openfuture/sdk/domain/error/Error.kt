package io.openfuture.sdk.domain.error

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Error(
        val status: Int,
        val message: String
)