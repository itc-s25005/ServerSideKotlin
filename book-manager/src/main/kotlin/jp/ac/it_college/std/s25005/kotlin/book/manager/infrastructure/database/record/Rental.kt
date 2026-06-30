/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:36.00457457+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.record

import java.time.LocalDateTime

data class Rental(
    val bookId: Long,
    val userId: Long,
    val rentalDatetime: LocalDateTime,
    val returnDeadline: LocalDateTime
)