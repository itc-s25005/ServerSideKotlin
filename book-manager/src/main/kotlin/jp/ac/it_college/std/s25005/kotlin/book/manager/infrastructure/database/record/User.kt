/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2026-06-11T16:58:35.991535461+09:00
 */
package jp.ac.it_college.std.s25005.kotlin.book.manager.infrastructure.database.record

import jp.ac.it_college.std.s25005.kotlin.book.manager.domain.type.RoleType

data class User(
    val id: Long,
    val email: String,
    val password: String,
    val name: String,
    val roleType: RoleType? = null
)