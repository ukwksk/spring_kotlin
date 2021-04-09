package co.ukwksk.spring_kotlin.presentation.model.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import co.ukwksk.spring_kotlin.usecase.dto.MessageDTO

data class MessageModel(
    val message: String
) {
    constructor(message: MessageDTO) : this(message.message)
}
