package io.openfuture.sdk.util

import org.junit.Test

class HttpStatusGroupTests {

    @Test(expected = IllegalArgumentException::class)
    fun onInvalidStatusShouldThrowIllegalArgumentException() {
        HttpStatusGroup.valueOf(600)
    }

}