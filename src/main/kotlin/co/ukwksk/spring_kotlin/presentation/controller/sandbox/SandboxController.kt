package co.ukwksk.spring_kotlin.presentation.controller.sandbox

import co.ukwksk.spring_kotlin.presentation.model.sandbox.MessageModel
import co.ukwksk.spring_kotlin.usecase.sandbox.SandboxUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SandboxController(
    private val usecase: SandboxUsecase
) {

    @GetMapping("")
    fun getUserList(): MessageModel {
        return MessageModel(usecase.getMessage())
    }
}
