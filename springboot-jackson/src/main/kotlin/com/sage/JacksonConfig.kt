package com.sage

import com.fasterxml.jackson.annotation.JsonFormat.Feature
import com.fasterxml.jackson.core.json.JsonWriteFeature
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {

    @Bean
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer =
        Jackson2ObjectMapperBuilderCustomizer { builder ->
            builder.serializerByType(Long::class.java, ToStringSerializer.instance)
            //  https://github.com/FasterXML/jackson-core/issues/586#issuecomment-783187195
//            builder.featuresToEnable(JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS.mappedFeature())
        }

}
