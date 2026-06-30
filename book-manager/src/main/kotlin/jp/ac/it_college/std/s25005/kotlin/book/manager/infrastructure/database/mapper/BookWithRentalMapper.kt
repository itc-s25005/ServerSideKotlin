/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:36.006120929+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper

import java.time.LocalDate
import java.time.LocalDateTime
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.author
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.bookWithRental
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.id
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.releaseDate
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.rentalDatetime
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.returnDeadline
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.title
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookWithRentalDynamicSqlSupport.userId
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.record.BookWithRental
import org.apache.ibatis.annotations.Arg
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper

@Mapper
interface BookWithRentalMapper : CommonCountMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="BookWithRentalResult")
    @Arg(column="id", jdbcType=JdbcType.BIGINT, javaType=Long::class)
    @Arg(column="title", jdbcType=JdbcType.VARCHAR, javaType=String::class)
    @Arg(column="author", jdbcType=JdbcType.VARCHAR, javaType=String::class)
    @Arg(column="release_date", jdbcType=JdbcType.DATE, javaType=LocalDate::class)
    @Arg(column="user_id", jdbcType=JdbcType.BIGINT, javaType=java.lang.Long::class)
    @Arg(column="rental_datetime", jdbcType=JdbcType.TIMESTAMP, javaType=LocalDateTime::class)
    @Arg(column="return_deadline", jdbcType=JdbcType.TIMESTAMP, javaType=LocalDateTime::class)
    fun selectMany(selectStatement: SelectStatementProvider): List<BookWithRental>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("BookWithRentalResult")
    fun selectOne(selectStatement: SelectStatementProvider): BookWithRental?
}

fun BookWithRentalMapper.count(completer: CountCompleter) =
    countFrom(this::count, bookWithRental, completer)

private val columnList = listOf(id, title, author, releaseDate, userId, rentalDatetime, returnDeadline)

fun BookWithRentalMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, bookWithRental, completer)

fun BookWithRentalMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, bookWithRental, completer)

fun BookWithRentalMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, bookWithRental, completer)