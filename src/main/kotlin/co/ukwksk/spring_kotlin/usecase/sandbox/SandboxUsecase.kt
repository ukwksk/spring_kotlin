package co.ukwksk.spring_kotlin.usecase.sandbox

import co.ukwksk.spring_kotlin.service.SandboxService
import co.ukwksk.spring_kotlin.usecase.dto.MessageDTO
import org.springframework.stereotype.Service

@Service
class SandboxUsecase(
    private val service: SandboxService
) {
    fun getMessage() = MessageDTO(
        service.createMessage().message
    )
}
