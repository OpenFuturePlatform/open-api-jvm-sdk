package io.openfuture.api.domain.response

import com.fasterxml.jackson.core.type.TypeReference
import io.openfuture.api.domain.PageResponse
import io.openfuture.api.domain.scaffold.Scaffold
import io.openfuture.api.domain.scaffold.ScaffoldQuota
import io.openfuture.api.domain.scaffold.ScaffoldSummary
import io.openfuture.api.domain.transaction.Transaction

class ScaffoldResponse : TypeReference<Scaffold>()

class ScaffoldPageResponse : TypeReference<PageResponse<Scaffold>>()

class ScaffoldSummaryResponse : TypeReference<ScaffoldSummary>()

class ScaffoldQuotaResponse : TypeReference<ScaffoldQuota>()

class TransactionPageResponse : TypeReference<PageResponse<Transaction>>()