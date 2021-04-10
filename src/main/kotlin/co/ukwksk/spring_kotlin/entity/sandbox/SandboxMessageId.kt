package co.ukwksk.spring_kotlin.entity.sandbox

import co.ukwksk.spring_kotlin.entity.IdObject
import java.util.*

data class SandboxMessageId(override val value: UUID) : IdObject {

    constructor(value: String) : this(UUID.fromString(value))

    companion object {
        fun new() = SandboxMessageId(UUID.randomUUID())
    }
}
