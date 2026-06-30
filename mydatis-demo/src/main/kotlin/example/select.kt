package example

import database.UserDynamicSqlSupport
import database.UserDynamicSqlSupport.age
import database.UserDynamicSqlSupport.name
import database.UserMapper
import database.count
import database.select
import database.selectByPrimaryKey

fun main() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)

        println("-----主キー検索")
        val user = mapper.selectByPrimaryKey(100)
        println(user)

        println("-----Where 句での検索")
        val userList1 = mapper.select {
            where {
                name isEqualTo "Jiro"
            }
        }
        println(userList1)

        println("-----Where 句での検索で複数帰ってくるパターン")
        // SELECT * FROM user WHERE age >= 25
        val userList2 = mapper.select {
            where {
                age isGreaterThanOrEqualTo 25 // is Greater Than == 〜より大きい
            }
        }
        println(userList2)

        println("-----データ件数")
        val count1 = mapper.count {
            where {
                age isGreaterThanOrEqualTo 25
            }
        }
        println("age >= 25 のデータ件数: $count1")

        println("-----データ全件数える")
        val count2 = mapper.count {
            allRows()
        }
        println("データ全件数: $count2")
    }
}