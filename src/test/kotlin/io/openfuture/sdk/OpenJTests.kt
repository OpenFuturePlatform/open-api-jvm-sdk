package io.openfuture.sdk

import io.openfuture.sdk.sender.EthereumScaffoldSender
import io.openfuture.sdk.sender.EthereumShareHolderSender
import io.openfuture.sdk.sender.EthereumTransactionSender
import io.openfuture.sdk.sender.OpenScaffoldSender
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
    fun ethereumScaffoldShouldReturnScaffoldSender() {
        val scaffoldSender = openJ.ethereumScaffold()

        assertThat(scaffoldSender::class).hasSameClassAs(EthereumScaffoldSender::class)
        assertThat(scaffoldSender).isEqualToComparingOnlyGivenFields(EthereumScaffoldSender(token), "token")
    }

    @Test
    fun ethereumTransactionShouldReturnTransactionSender() {
        val scaffoldAddress = "address"
        val transactionSender = openJ.ethereumTransaction(scaffoldAddress)

        assertThat(transactionSender::class).hasSameClassAs(EthereumTransactionSender::class)
        assertThat(transactionSender)
                .isEqualToComparingOnlyGivenFields(EthereumTransactionSender(token, scaffoldAddress), "token", "openRoute")
    }

    @Test
    fun ethereumShareHolderShouldReturnShareHolderSender() {
        val scaffoldAddress = "address"
        val shareHolderSender = openJ.ethereumShareHolder(scaffoldAddress)

        assertThat(shareHolderSender::class).hasSameClassAs(EthereumShareHolderSender::class)
        assertThat(shareHolderSender)
                .isEqualToComparingOnlyGivenFields(EthereumShareHolderSender(token, scaffoldAddress), "token", "openRoute")
    }

    @Test
    fun openScaffoldShouldReturnOpenScaffoldSender() {
        val sender = openJ.openScaffold()

        assertThat(sender::class).hasSameClassAs(OpenScaffoldSender::class)
        assertThat(sender).isEqualToComparingOnlyGivenFields(OpenScaffoldSender(token), "token")
    }

}