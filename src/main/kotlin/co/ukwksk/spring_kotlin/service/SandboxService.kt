package co.ukwksk.spring_kotlin.service

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessageId
import co.ukwksk.spring_kotlin.repository.sandbox.MessageRepository
import co.ukwksk.spring_kotlin.repository.sandbox.MessageSpec
import org.springframework.stereotype.Service

@Service
class SandboxService(
    private val repository: MessageRepository
) {

    fun listAll() = repository.listAll()

    fun createMessage(
        message: String
    ): SandboxMessage {
        val entity = SandboxMessage.new(message = message)
        return repository.saveMessage(entity)
    }

    fun findMessageById(
        id: SandboxMessageId
    ): SandboxMessage? {
        val spec = MessageSpec.byId(id)
        return repository.findBy(spec)
    }
}
