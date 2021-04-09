package co.ukwksk.spring_kotlin.service

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import org.springframework.stereotype.Service

@Service
class SandboxService {
    fun createMessage() = SandboxMessage.new("hoge")
}
