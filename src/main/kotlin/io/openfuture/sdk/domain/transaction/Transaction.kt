package io.openfuture.sdk.domain.transaction

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.openfuture.sdk.domain.event.Event
import io.openfuture.sdk.domain.scaffold.Scaffold
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Transaction(
        val scaffold: Scaffold,
        val event: Event,
        val date: Date
)