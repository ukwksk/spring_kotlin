package co.ukwksk.spring_kotlin.repository.sandbox

import co.ukwksk.spring_kotlin.elasticsearch.sandbox.MessageIndex
import co.ukwksk.spring_kotlin.elasticsearch.sandbox.MessageSchema
import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import org.springframework.stereotype.Repository

@Repository
class MessageRepositoryImpl(
    val index: MessageIndex
) : MessageRepository {

    override fun listAll(): List<SandboxMessage> =
        index.findAll().map {
            SandboxMessage.fromSchema(it)
        }

    override fun saveMessage(message: SandboxMessage): SandboxMessage =
        index.save(
            MessageSchema.fromEntity(message)
        ).let {
            println("save SandboxMessage: ${it}")
            SandboxMessage.fromSchema(it)
        }

    override fun findBy(spec: MessageSpec): SandboxMessage? =
        spec.id?.let {
            index.findById(it.stringValue()).orElse(null)
        }?.let {
            SandboxMessage.fromSchema(it)
        }
}
