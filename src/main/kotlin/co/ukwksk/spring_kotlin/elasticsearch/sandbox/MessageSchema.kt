package co.ukwksk.spring_kotlin.elasticsearch.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessageId

data class MessageSchema(
    val id: String,
    val message: String,
) {
    companion object {
        fun fromEntity(message: SandboxMessage) = MessageSchema(
            id = (message.id ?: SandboxMessageId.new()).stringValue(),
            message = message.message,
        )
    }

    fun asMap(): Map<String, Any?> = mapOf(
        "id" to id,
        "message" to message,
    )
}
