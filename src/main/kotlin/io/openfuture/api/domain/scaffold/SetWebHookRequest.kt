package io.openfuture.api.domain.scaffold

data class SetWebHookRequest(
        val address: String,
        val webHook: String
)