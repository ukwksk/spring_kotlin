package co.ukwksk.spring_kotlin.entity.sandbox

import java.util.*

data class SandboxMessage private constructor(
    val id: SandboxMessageId,
    val message: String,
) {
    companion object SandboxMessage {
        fun new(message: String) = SandboxMessage(
            SandboxMessageId(UUID.randomUUID()),
            message,
        )
    }
}
