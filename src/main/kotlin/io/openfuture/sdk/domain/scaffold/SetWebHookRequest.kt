package io.openfuture.sdk.domain.scaffold

data class SetWebHookRequest(
        val address: String,
        val webHook: String
)