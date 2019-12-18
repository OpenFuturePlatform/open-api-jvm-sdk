package io.openfuture.sdk.domain.scaffold

data class SaveOpenScaffoldRequest(
        val openKey: String,
        val developerAddress: String,
        val description: String,
        val webHook: String? = null
)