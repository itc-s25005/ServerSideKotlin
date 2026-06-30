package jp.ac.it_college.std.s25005.kotlin.book.manager.presentation.form

import kotlinx.serialization.Serializable

@Serializable
data class RentalStartRequest(
    val bookId: Long
)