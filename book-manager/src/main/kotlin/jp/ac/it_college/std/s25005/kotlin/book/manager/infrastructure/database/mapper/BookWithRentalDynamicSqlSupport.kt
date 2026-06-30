/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:35.990164685+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDate
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object BookWithRentalDynamicSqlSupport {
    val bookWithRental = BookWithRental()

    val id = bookWithRental.id

    val title = bookWithRental.title

    val author = bookWithRental.author

    val releaseDate = bookWithRental.releaseDate

    val userId = bookWithRental.userId

    val rentalDatetime = bookWithRental.rentalDatetime

    val returnDeadline = bookWithRental.returnDeadline

    class BookWithRental : AliasableSqlTable<BookWithRental>("book_with_rental", ::BookWithRental) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT, javaProperty = "id")

        val title = column<String>(name = "title", jdbcType = JDBCType.VARCHAR, javaProperty = "title")

        val author = column<String>(name = "author", jdbcType = JDBCType.VARCHAR, javaProperty = "author")

        val releaseDate = column<LocalDate>(name = "release_date", jdbcType = JDBCType.DATE, javaProperty = "releaseDate")

        val userId = column<Long>(name = "user_id", jdbcType = JDBCType.BIGINT, javaProperty = "userId")

        val rentalDatetime = column<LocalDateTime>(name = "rental_datetime", jdbcType = JDBCType.TIMESTAMP, javaProperty = "rentalDatetime")

        val returnDeadline = column<LocalDateTime>(name = "return_deadline", jdbcType = JDBCType.TIMESTAMP, javaProperty = "returnDeadline")
    }
}