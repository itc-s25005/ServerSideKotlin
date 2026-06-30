/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-04T16:09:58.175621226+09:00
 */
package database

import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UserDynamicSqlSupport {
    val user = User()

    val id = user.id

    val name = user.name

    val age = user.age

    val profile = user.profile

    class User : AliasableSqlTable<User>("user", ::User) {
        val id = column<Int>(name = "id", jdbcType = JDBCType.INTEGER, javaProperty = "id")

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR, javaProperty = "name")

        val age = column<Int>(name = "age", jdbcType = JDBCType.INTEGER, javaProperty = "age")

        val profile = column<String>(name = "profile", jdbcType = JDBCType.VARCHAR, javaProperty = "profile")
    }
}