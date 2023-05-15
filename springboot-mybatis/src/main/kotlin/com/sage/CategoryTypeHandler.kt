package com.sage

import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedJdbcTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

class CategoryTypeHandler: BaseTypeHandler<List<Int>>() {

    override fun setNonNullParameter(ps: PreparedStatement?, i: Int, parameter: List<Int>?, jdbcType: JdbcType?) {
        TODO("Not yet implemented")
    }

    override fun getNullableResult(rs: ResultSet?, columnName: String?): List<Int> {
        try {
            println(1)
            return convert(rs?.getString(columnName))
        }catch (e: Exception){
            e.printStackTrace()
            println(5)
        }
        return listOf()
    }


    override fun getNullableResult(rs: ResultSet?, columnIndex: Int): List<Int> {
        println(2)
        return convert(rs?.getString(columnIndex))
    }

    override fun getNullableResult(cs: CallableStatement?, columnIndex: Int): List<Int> {
        println(3)
        return convert(cs?.getString(columnIndex))
    }

    private fun convert(path: String?): List<Int> {
        val result = path?.split(",")?.map { it.toInt() } ?: listOf()
        println("-----------")
        println(result)
        result.forEach { println(it.javaClass) }
        return path?.split(",")?.map { it.toInt() } ?: listOf()
    }

}
