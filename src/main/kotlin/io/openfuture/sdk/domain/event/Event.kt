package io.openfuture.sdk.domain.event

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME
import io.openfuture.sdk.domain.event.EventType.ACTIVATED_SCAFFOLD
import io.openfuture.sdk.domain.event.EventType.ADDED_SHARE_HOLDER
import io.openfuture.sdk.domain.event.EventType.DELETED_SHARE_HOLDER
import io.openfuture.sdk.domain.event.EventType.EDITED_SHARE_HOLDER
import io.openfuture.sdk.domain.event.EventType.FUNDS_DEPOSITED
import io.openfuture.sdk.domain.event.EventType.PAID_FOR_SHARE_HOLDER
import io.openfuture.sdk.domain.event.EventType.PAYMENT_COMPLETED
import java.math.BigDecimal
import java.math.BigInteger

@JsonTypeInfo(use = NAME, include = EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes(
        Type(value = ActivatedScaffoldEvent::class, name = ACTIVATED_SCAFFOLD),
        Type(value = AddedShareHolderEvent::class, name = ADDED_SHARE_HOLDER),
        Type(value = DeletedShareHolderEvent::class, name = DELETED_SHARE_HOLDER),
        Type(value = EditedShareHolderEvent::class, name = EDITED_SHARE_HOLDER),
        Type(value = FundsDepositedEvent::class, name = FUNDS_DEPOSITED),
        Type(value = PaidForShareHolderEvent::class, name = PAID_FOR_SHARE_HOLDER),
        Type(value = PaymentCompletedEvent::class, name = PAYMENT_COMPLETED)
)
@JsonIgnoreProperties(ignoreUnknown = true)
sealed class Event(
        val type: String
)

data class ActivatedScaffoldEvent(
        val activated: Boolean
) : Event(ACTIVATED_SCAFFOLD)

data class AddedShareHolderEvent(
        val userAddress: String,
        val partnerShare: BigInteger
) : Event(ADDED_SHARE_HOLDER)

data class DeletedShareHolderEvent(
        val userAddress: String
) : Event(DELETED_SHARE_HOLDER)

data class EditedShareHolderEvent(
        val userAddress: String,
        val partnerShare: BigInteger
) : Event(EDITED_SHARE_HOLDER)

data class FundsDepositedEvent(
        val amount: BigDecimal,
        val toAddress: String
) : Event(FUNDS_DEPOSITED)

data class PaidForShareHolderEvent(
        val userAddress: String,
        val amount: BigDecimal
) : Event(PAID_FOR_SHARE_HOLDER)

data class PaymentCompletedEvent(
        val customerAddress: String,
        val transactionAmount: BigDecimal,
        val scaffoldTransactionIndex: BigInteger,
        val properties: Map<String, Any>
) : Event(PAYMENT_COMPLETED)

