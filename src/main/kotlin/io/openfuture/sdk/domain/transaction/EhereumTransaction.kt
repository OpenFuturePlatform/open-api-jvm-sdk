package io.openfuture.sdk.domain.transaction

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.openfuture.sdk.domain.event.Event
import io.openfuture.sdk.domain.scaffold.EthereumScaffold
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class EhereumTransaction(
        val ethereumScaffold: EthereumScaffold,
        val event: Event,
        val date: Date
)