package io.openfuture.sdk.util

enum class HttpStatusGroup(
        private val value: Int
) {

    INFORMATIONAL(1),
    SUCCESSFUL(2),
    REDIRECTION(3),
    CLIENT_ERROR(4),
    SERVER_ERROR(5)
    ;

    companion object {
        fun valueOf(status: Int): HttpStatusGroup {
            val seriesCode = status / 100
            return values().firstOrNull { it.value == seriesCode }
                    ?: throw IllegalArgumentException("No matching constant for $status")
        }
    }

}