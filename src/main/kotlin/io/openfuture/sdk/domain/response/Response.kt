package io.openfuture.sdk.domain.response

import com.fasterxml.jackson.core.type.TypeReference
import io.openfuture.sdk.domain.PageResponse
import io.openfuture.sdk.domain.scaffold.EthereumScaffold
import io.openfuture.sdk.domain.scaffold.EthereumScaffoldQuota
import io.openfuture.sdk.domain.scaffold.EthereumScaffoldSummary
import io.openfuture.sdk.domain.scaffold.OpenScaffold
import io.openfuture.sdk.domain.transaction.EhereumTransaction

class EthereumScaffoldResponse : TypeReference<EthereumScaffold>()

class EthereumScaffoldPageResponse : TypeReference<PageResponse<EthereumScaffold>>()

class EthereumScaffoldSummaryResponse : TypeReference<EthereumScaffoldSummary>()

class EthereumScaffoldQuotaResponse : TypeReference<EthereumScaffoldQuota>()

class EthereumTransactionPageResponse : TypeReference<PageResponse<EhereumTransaction>>()

class OpenScaffoldPageResponse : TypeReference<PageResponse<OpenScaffold>>()

class OpenScaffoldResponse : TypeReference<OpenScaffold>()
