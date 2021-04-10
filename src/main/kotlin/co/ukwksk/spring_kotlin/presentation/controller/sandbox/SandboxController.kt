package co.ukwksk.spring_kotlin.presentation.controller.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessageId
import co.ukwksk.spring_kotlin.presentation.model.sandbox.MessageCreateForm
import co.ukwksk.spring_kotlin.presentation.model.sandbox.MessageListModel
import co.ukwksk.spring_kotlin.presentation.model.sandbox.MessageModel
import co.ukwksk.spring_kotlin.usecase.dto.sandbox.MessageFindDTO
import co.ukwksk.spring_kotlin.usecase.sandbox.SandboxUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SandboxController(
    private val usecase: SandboxUsecase
) {

    @GetMapping("/")
    fun list() = usecase.listAll()
        .map { MessageModel(it) }
        .let { MessageListModel(it) }

    @PostMapping("/")
    fun create(@RequestBody form: MessageCreateForm) = usecase.createMessage(form.toDto())
        .let { MessageModel(it) }

    @GetMapping("/{id}")
    fun find(@PathVariable("id") id: String) = usecase.findMessageById(
        MessageFindDTO(SandboxMessageId(id))
    )?.let { MessageModel(it) }
}
