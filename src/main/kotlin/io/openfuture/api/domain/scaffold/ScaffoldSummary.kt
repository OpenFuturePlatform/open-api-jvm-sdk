package io.openfuture.api.domain.scaffold

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigInteger

@JsonIgnoreProperties(ignoreUnknown = true)
data class ScaffoldSummary(
        val scaffold: Scaffold,
        val transactionIndex: BigInteger,
        val tokenBalance: BigInteger,
        val enabled: Boolean,
        val shareHolders: List<ShareHolder>
)