package io.openfuture.sdk.domain.response

import com.fasterxml.jackson.core.type.TypeReference
import io.openfuture.sdk.domain.PageResponse
import io.openfuture.sdk.domain.scaffold.Scaffold
import io.openfuture.sdk.domain.scaffold.ScaffoldQuota
import io.openfuture.sdk.domain.scaffold.ScaffoldSummary
import io.openfuture.sdk.domain.transaction.Transaction

class ScaffoldResponse : TypeReference<Scaffold>()

class ScaffoldPageResponse : TypeReference<PageResponse<Scaffold>>()

class ScaffoldSummaryResponse : TypeReference<ScaffoldSummary>()

class ScaffoldQuotaResponse : TypeReference<ScaffoldQuota>()

class TransactionPageResponse : TypeReference<PageResponse<Transaction>>()