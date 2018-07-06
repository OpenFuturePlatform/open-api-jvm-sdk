package io.openfuture.api.domain.event

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME
import io.openfuture.api.domain.event.EventType.ACTIVATED_SCAFFOLD
import io.openfuture.api.domain.event.EventType.ADDED_SHARE_HOLDER
import io.openfuture.api.domain.event.EventType.DELETED_SHARE_HOLDER
import io.openfuture.api.domain.event.EventType.EDITED_SHARE_HOLDER
import io.openfuture.api.domain.event.EventType.FUNDS_DEPOSITED
import io.openfuture.api.domain.event.EventType.PAYED_FOR_SHARE_HOLDER
import io.openfuture.api.domain.event.EventType.PAYMENT_COMPLETED
import java.math.BigInteger

@JsonTypeInfo(use = NAME, include = EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes(
        Type(value = ActivatedScaffoldEvent::class, name = ACTIVATED_SCAFFOLD),
        Type(value = AddedShareHolderEvent::class, name = ADDED_SHARE_HOLDER),
        Type(value = DeletedShareHolderEvent::class, name = DELETED_SHARE_HOLDER),
        Type(value = EditedShareHolderEvent::class, name = EDITED_SHARE_HOLDER),
        Type(value = FundsDepositedEvent::class, name = FUNDS_DEPOSITED),
        Type(value = PayedForShareHolderEvent::class, name = PAYED_FOR_SHARE_HOLDER),
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
        val amount: BigInteger,
        val toAddress: String
) : Event(FUNDS_DEPOSITED)

data class PayedForShareHolderEvent(
        val userAddress: String,
        val amount: BigInteger
) : Event(PAYED_FOR_SHARE_HOLDER)

data class PaymentCompletedEvent(
        val customerAddress: String,
        val transactionAmount: BigInteger,
        val scaffoldTransactionIndex: BigInteger,
        val properties: Map<String, Any>
) : Event(PAYMENT_COMPLETED)

