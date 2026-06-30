/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:36.005954642+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.record

import java.time.LocalDate
import java.time.LocalDateTime

data class BookWithRental(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate,
    val userId: Long? = null,
    val rentalDatetime: LocalDateTime? = null,
    val returnDeadline: LocalDateTime? = null
)