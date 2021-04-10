package co.ukwksk.spring_kotlin.repository.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessageId

data class MessageSpec private constructor(
    val id: SandboxMessageId?
) {
    companion object {
        fun byId(id: SandboxMessageId) = MessageSpec(id = id)
    }
}
