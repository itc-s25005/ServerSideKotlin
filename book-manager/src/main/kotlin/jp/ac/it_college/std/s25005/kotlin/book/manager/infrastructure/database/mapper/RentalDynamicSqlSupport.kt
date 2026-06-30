/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:35.989950153+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object RentalDynamicSqlSupport {
    val rental = Rental()

    val bookId = rental.bookId

    val userId = rental.userId

    val rentalDatetime = rental.rentalDatetime

    val returnDeadline = rental.returnDeadline

    class Rental : AliasableSqlTable<Rental>("rental", ::Rental) {
        val bookId = column<Long>(name = "book_id", jdbcType = JDBCType.BIGINT, javaProperty = "bookId")

        val userId = column<Long>(name = "user_id", jdbcType = JDBCType.BIGINT, javaProperty = "userId")

        val rentalDatetime = column<LocalDateTime>(name = "rental_datetime", jdbcType = JDBCType.TIMESTAMP, javaProperty = "rentalDatetime")

        val returnDeadline = column<LocalDateTime>(name = "return_deadline", jdbcType = JDBCType.TIMESTAMP, javaProperty = "returnDeadline")
    }
}