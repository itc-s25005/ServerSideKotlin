/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.mapper

import java.sql.JDBCType
import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.type.RoleType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UserDynamicSqlSupport {
    val user = User()

    val id = user.id

    val email = user.email

    val password = user.password

    val name = user.name

    val roleType = user.roleType

    class User : AliasableSqlTable<User>("user", ::User) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT, javaProperty = "id")

        val email = column<String>(name = "email", jdbcType = JDBCType.VARCHAR, javaProperty = "email")

        val password = column<String>(name = "password", jdbcType = JDBCType.VARCHAR, javaProperty = "password")

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR, javaProperty = "name")

        val roleType = column<RoleType>(name = "role_type", jdbcType = JDBCType.VARCHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler", javaProperty = "roleType")
    }
}