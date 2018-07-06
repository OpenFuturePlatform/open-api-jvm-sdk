package io.openfuture.api.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class ScaffoldProperty(
        val name: String,
        val type: PropertyType,
        val defaultValue: String? = null
)