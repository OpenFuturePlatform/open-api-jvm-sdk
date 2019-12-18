package io.openfuture.sdk.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigInteger

@JsonIgnoreProperties(ignoreUnknown = true)
data class EthereumScaffoldSummary(
        val ethereumScaffold: EthereumScaffold,
        val transactionIndex: BigInteger,
        val tokenBalance: BigInteger,
        val enabled: Boolean,
        val shareHolders: List<EthereumShareHolder>
)