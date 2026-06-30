/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:35.991839878+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper

import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.type.RoleType
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.email
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.id
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.name
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.password
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.roleType
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.user
import jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.record.User
import org.apache.ibatis.annotations.Arg
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.EnumTypeHandler
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
interface UserMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<User>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="UserResult")
    @Arg(column="id", jdbcType=JdbcType.BIGINT, javaType=Long::class, id=true)
    @Arg(column="email", jdbcType=JdbcType.VARCHAR, javaType=String::class)
    @Arg(column="password", jdbcType=JdbcType.VARCHAR, javaType=String::class)
    @Arg(column="name", jdbcType=JdbcType.VARCHAR, javaType=String::class)
    @Arg(column="role_type", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.VARCHAR, javaType=RoleType::class)
    fun selectMany(selectStatement: SelectStatementProvider): List<User>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("UserResult")
    fun selectOne(selectStatement: SelectStatementProvider): User?
}

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, user, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, user, completer)

fun UserMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun UserMapper.insert(row: User) =
    insert(this::insert, row, user) {
        withMappedColumn(id)
        withMappedColumn(email)
        withMappedColumn(password)
        withMappedColumn(name)
        withMappedColumn(roleType)
    }

fun UserMapper.insertMultiple(records: Collection<User>) =
    insertMultiple(this::insertMultiple, records, user) {
        withMappedColumn(id)
        withMappedColumn(email)
        withMappedColumn(password)
        withMappedColumn(name)
        withMappedColumn(roleType)
    }

fun UserMapper.insertMultiple(vararg records: User) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(row: User) =
    insert(this::insert, row, user) {
        withMappedColumn(id)
        withMappedColumn(email)
        withMappedColumn(password)
        withMappedColumn(name)
        withMappedColumnWhenPresent(roleType, row::roleType)
    }

private val columnList = listOf(id, email, password, name, roleType)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, user, completer)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, user, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, user, completer)

fun UserMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, user, completer)

fun UserMapper.updateByPrimaryKey(row: User) =
    update {
        set(email) equalTo row::email
        set(password) equalTo row::password
        set(name) equalTo row::name
        set(roleType) equalToOrNull row::roleType
        where { id isEqualTo row.id }
    }