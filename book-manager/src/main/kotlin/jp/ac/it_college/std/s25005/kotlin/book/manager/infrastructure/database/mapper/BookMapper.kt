/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:36.00412687+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper

import java.time.LocalDate
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.author
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.book
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.id
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.releaseDate
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.title
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.record.Book
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
interface BookMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Book>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="BookResult")
    @Arg(column="id", jdbcType=JdbcType.BIGINT, javaType=Long::class, id=true)
    @Arg(column="title", jdbcType=JdbcType.VARCHAR, javaType=String::class)
    @Arg(column="author", jdbcType=JdbcType.VARCHAR, javaType=String::class)
    @Arg(column="release_date", jdbcType=JdbcType.DATE, javaType=LocalDate::class)
    fun selectMany(selectStatement: SelectStatementProvider): List<Book>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("BookResult")
    fun selectOne(selectStatement: SelectStatementProvider): Book?
}

fun BookMapper.count(completer: CountCompleter) =
    countFrom(this::count, book, completer)

fun BookMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, book, completer)

fun BookMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun BookMapper.insert(row: Book) =
    insert(this::insert, row, book) {
        withMappedColumn(id)
        withMappedColumn(title)
        withMappedColumn(author)
        withMappedColumn(releaseDate)
    }

fun BookMapper.insertMultiple(records: Collection<Book>) =
    insertMultiple(this::insertMultiple, records, book) {
        withMappedColumn(id)
        withMappedColumn(title)
        withMappedColumn(author)
        withMappedColumn(releaseDate)
    }

fun BookMapper.insertMultiple(vararg records: Book) =
    insertMultiple(records.toList())

fun BookMapper.insertSelective(row: Book) =
    insert(this::insert, row, book) {
        withMappedColumn(id)
        withMappedColumn(title)
        withMappedColumn(author)
        withMappedColumn(releaseDate)
    }

private val columnList = listOf(id, title, author, releaseDate)

fun BookMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, book, completer)

fun BookMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, book, completer)

fun BookMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, book, completer)

fun BookMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun BookMapper.update(completer: UpdateCompleter) =
    update(this::update, book, completer)

fun BookMapper.updateByPrimaryKey(row: Book) =
    update {
        set(title) equalTo row::title
        set(author) equalTo row::author
        set(releaseDate) equalTo row::releaseDate
        where { id isEqualTo row.id }
    }