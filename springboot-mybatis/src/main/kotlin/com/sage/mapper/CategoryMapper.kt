package com.sage.mapper

import com.sage.CategoryDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CategoryMapper {

    fun getOne(): CategoryDto

}
