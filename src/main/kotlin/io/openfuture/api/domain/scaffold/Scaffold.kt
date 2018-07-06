package io.openfuture.api.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Scaffold(
        val address: String,
        val abi: String,
        val description: String,
        val fiatAmount: String,
        val currency: Currency,
        val conversionAmount: String,
        val developerAddress: String,
        val webHook: String?,
        val properties: List<ScaffoldProperty>
)