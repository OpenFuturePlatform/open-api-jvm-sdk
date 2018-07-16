package io.openfuture.sdk.domain.scaffold

data class DeployScaffoldRequest(
        val openKey: String,
        val developerAddress: String,
        val description: String,
        val fiatAmount: String,
        val currency: Currency,
        val conversionAmount: String,
        val properties: List<ScaffoldProperty> = listOf(),
        val webHook: String? = null
)