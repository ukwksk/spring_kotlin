package co.ukwksk.spring_kotlin.presentation.model.sandbox

import co.ukwksk.spring_kotlin.usecase.dto.sandbox.MessageCreateDTO

data class MessageCreateForm(
    val message: String
) {
    fun toDto() = MessageCreateDTO(message = message)
}
