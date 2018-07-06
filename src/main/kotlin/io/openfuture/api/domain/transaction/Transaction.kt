package io.openfuture.api.domain.transaction

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.openfuture.api.domain.event.Event
import io.openfuture.api.domain.scaffold.Scaffold

@JsonIgnoreProperties(ignoreUnknown = true)
data class Transaction(
        val scaffold: Scaffold,
        val event: Event
)