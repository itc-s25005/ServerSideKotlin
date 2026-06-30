/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:36.004674466+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper

import java.time.LocalDateTime
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.bookId
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rental
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rentalDatetime
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.returnDeadline
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.userId
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.record.Rental
import org.apache.ibatis.annotations.Arg
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface RentalMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Rental>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="RentalResult")
    @Arg(column="book_id", jdbcType=JdbcType.BIGINT, javaType=Long::class)
    @Arg(column="user_id", jdbcType=JdbcType.BIGINT, javaType=Long::class)
    @Arg(column="rental_datetime", jdbcType=JdbcType.TIMESTAMP, javaType=LocalDateTime::class)
    @Arg(column="return_deadline", jdbcType=JdbcType.TIMESTAMP, javaType=LocalDateTime::class)
    fun selectMany(selectStatement: SelectStatementProvider): List<Rental>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("RentalResult")
    fun selectOne(selectStatement: SelectStatementProvider): Rental?
}

fun RentalMapper.count(completer: CountCompleter) =
    countFrom(this::count, rental, completer)

fun RentalMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, rental, completer)

fun RentalMapper.insert(row: Rental) =
    insert(this::insert, row, rental) {
        withMappedColumn(bookId)
        withMappedColumn(userId)
        withMappedColumn(rentalDatetime)
        withMappedColumn(returnDeadline)
    }

fun RentalMapper.insertMultiple(records: Collection<Rental>) =
    insertMultiple(this::insertMultiple, records, rental) {
        withMappedColumn(bookId)
        withMappedColumn(userId)
        withMappedColumn(rentalDatetime)
        withMappedColumn(returnDeadline)
    }

fun RentalMapper.insertMultiple(vararg records: Rental) =
    insertMultiple(records.toList())

fun RentalMapper.insertSelective(row: Rental) =
    insert(this::insert, row, rental) {
        withMappedColumn(bookId)
        withMappedColumn(userId)
        withMappedColumn(rentalDatetime)
        withMappedColumn(returnDeadline)
    }

private val columnList = listOf(bookId, userId, rentalDatetime, returnDeadline)

fun RentalMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, rental, completer)

fun RentalMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, rental, completer)

fun RentalMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, rental, completer)

fun RentalMapper.update(completer: UpdateCompleter) =
    update(this::update, rental, completer)