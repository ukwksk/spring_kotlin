package co.ukwksk.spring_kotlin.elasticsearch.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessageId
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "sandbox-message-index")
data class MessageSchema(
    @Id val id: String,
    val message: String,
) {
    companion object {
        fun fromEntity(message: SandboxMessage) = MessageSchema(
            id = (message.id ?: SandboxMessageId.new()).stringValue(),
            message = message.message,
        )
    }
}
