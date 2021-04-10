package co.ukwksk.spring_kotlin.repository.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage

interface MessageRepository {

    fun listAll(): List<SandboxMessage>

    fun saveMessage(message: SandboxMessage): SandboxMessage

    fun findBy(spec: MessageSpec): SandboxMessage?
}
