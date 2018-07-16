package io.openfuture.sdk

import io.openfuture.sdk.sender.ScaffoldSender
import io.openfuture.sdk.sender.ShareHolderSender
import io.openfuture.sdk.sender.TransactionSender
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class OpenJTests {

    private lateinit var openJ: OpenJ

    private val token = "ok_token"


    @Before
    fun setUp() {
        openJ = OpenJ(token)
    }


    @Test
    fun scaffoldShouldReturnScaffoldSender() {
        val scaffoldSender = openJ.scaffold()

        assertThat(scaffoldSender::class).hasSameClassAs(ScaffoldSender::class)
        assertThat(scaffoldSender).isEqualToComparingOnlyGivenFields(ScaffoldSender(token), "token")
    }

    @Test
    fun transactionShouldReturnTransactionSender() {
        val scaffoldAddress = "address"
        val transactionSender = openJ.transaction(scaffoldAddress)

        assertThat(transactionSender::class).hasSameClassAs(TransactionSender::class)
        assertThat(transactionSender)
                .isEqualToComparingOnlyGivenFields(TransactionSender(token, scaffoldAddress), "token", "openRoute")
    }

    @Test
    fun shareHolderShouldReturnShareHolderSender() {
        val scaffoldAddress = "address"
        val shareHolderSender = openJ.shareHolder(scaffoldAddress)

        assertThat(shareHolderSender::class).hasSameClassAs(ShareHolderSender::class)
        assertThat(shareHolderSender)
                .isEqualToComparingOnlyGivenFields(ShareHolderSender(token, scaffoldAddress), "token", "openRoute")
    }

}