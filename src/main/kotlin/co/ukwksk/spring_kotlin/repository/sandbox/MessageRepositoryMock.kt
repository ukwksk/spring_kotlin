package co.ukwksk.spring_kotlin.repository.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import co.ukwksk.spring_kotlin.elasticsearch.sandbox.MessageSchema
import org.springframework.stereotype.Repository

@Repository
class MessageRepositoryMock : MessageRepository {

    companion object {
        val SCHEMAS = listOf("hoge", "fuga", "piyo").map {
            SandboxMessage.new(it)
        }.map {
            MessageSchema.fromEntity(it)
        }
        val SCHEMAS_MAP = SCHEMAS.map {
            it.id to it
        }.toMap()
    }

    override fun listAll(): List<SandboxMessage> = SCHEMAS.map {
        SandboxMessage.fromSchema(it)
    }

    override fun saveMessage(message: SandboxMessage): SandboxMessage =
        SandboxMessage.new(message = message.message).let {
            MessageSchema.fromEntity(it)
        }.let {
            SandboxMessage.fromSchema(it)
        }

    override fun findBy(spec: MessageSpec): SandboxMessage? =
        spec.id?.let {
            SCHEMAS_MAP.get(it.stringValue())
        }?.let {
            SandboxMessage.fromSchema(it)
        }
}
