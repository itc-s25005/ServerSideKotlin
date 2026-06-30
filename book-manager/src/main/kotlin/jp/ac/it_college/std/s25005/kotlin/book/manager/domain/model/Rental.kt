package jp.ac.it_college.std.s25005.kotlin.book.manager.domain.model

import kotlinx.datetime.LocalDateTime

data class Rental(
    val bookId: Long,
    val userId: Long,
    val rentalDateTime: LocalDateTime,
    val returnDeadline: LocalDateTime,
)