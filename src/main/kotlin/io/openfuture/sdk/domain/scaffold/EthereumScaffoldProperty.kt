package io.openfuture.sdk.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class EthereumScaffoldProperty(
        val name: String,
        val type: PropertyType,
        val defaultValue: String? = null
)