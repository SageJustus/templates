package com.sage

import com.sage.mapper.CategoryMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootMybatisApplication()

fun main(args: Array<String>) {
    runApplication<SpringbootMybatisApplication>(*args)
}
