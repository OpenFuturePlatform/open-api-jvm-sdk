package io.openfuture.sdk.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OpenScaffold(
        val developerAddress: String,
        val description: String,
        val webHook: String?
)