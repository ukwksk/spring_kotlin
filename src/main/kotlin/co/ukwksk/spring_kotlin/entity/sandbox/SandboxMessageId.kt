package co.ukwksk.spring_kotlin.entity.sandbox

import co.ukwksk.spring_kotlin.entity.IdObject
import java.util.*

data class SandboxMessageId(override val value: UUID) : IdObject
