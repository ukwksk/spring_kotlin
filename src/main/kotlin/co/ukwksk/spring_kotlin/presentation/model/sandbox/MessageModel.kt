package co.ukwksk.spring_kotlin.presentation.model.sandbox

import co.ukwksk.spring_kotlin.usecase.dto.sandbox.MessageDTO

data class MessageModel(
    val id: String,
    val message: String,
) {
    constructor(dto: MessageDTO) : this(
        id = dto.id.value.toString(),
        message = dto.message,
    )
}
