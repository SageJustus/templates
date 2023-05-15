package com.sage

import com.sage.mapper.CategoryMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringbootMybatisApplicationTests() {

    @Autowired
    private lateinit var categoryMapper: CategoryMapper

    @Test
    fun hello() {
        categoryMapper.getOne()
    }

}
