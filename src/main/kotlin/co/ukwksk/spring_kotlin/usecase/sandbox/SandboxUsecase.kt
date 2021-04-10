package co.ukwksk.spring_kotlin.usecase.sandbox

import co.ukwksk.spring_kotlin.service.SandboxService
import co.ukwksk.spring_kotlin.usecase.dto.sandbox.MessageCreateDTO
import co.ukwksk.spring_kotlin.usecase.dto.sandbox.MessageDTO
import co.ukwksk.spring_kotlin.usecase.dto.sandbox.MessageFindDTO
import org.springframework.stereotype.Service

@Service
class SandboxUsecase(
    private val service: SandboxService
) {

    fun listAll() =
        service.listAll()
            .map { MessageDTO(it.id!!, it.message) }

    fun createMessage(dto: MessageCreateDTO) =
        service.createMessage(dto.message)
            .let { MessageDTO(it.id!!, it.message) }

    fun findMessageById(dto: MessageFindDTO) =
        service.findMessageById(dto.id)
            ?.let { MessageDTO(it.id!!, it.message) }
}
