package co.ukwksk.spring_kotlin.entity

import java.util.*

interface IdObject {
    val value: UUID

    fun stringValue() = value.toString()
}
