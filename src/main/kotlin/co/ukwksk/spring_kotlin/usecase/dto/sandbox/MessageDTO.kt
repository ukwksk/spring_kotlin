package co.ukwksk.spring_kotlin.usecase.dto.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessageId

data class MessageDTO(
    val id: SandboxMessageId,
    val message: String,
)
