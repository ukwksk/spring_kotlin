package co.ukwksk.spring_kotlin.entity.sandbox

import co.ukwksk.spring_kotlin.elasticsearch.sandbox.MessageSchema

data class SandboxMessage private constructor(
    val id: SandboxMessageId? = null,
    val message: String,
) {
    companion object {
        fun new(message: String) = SandboxMessage(
            message = message,
        )

        fun fromSchema(schema: MessageSchema) = SandboxMessage(
            id = SandboxMessageId(schema.id),
            message = schema.message
        )
    }
}
