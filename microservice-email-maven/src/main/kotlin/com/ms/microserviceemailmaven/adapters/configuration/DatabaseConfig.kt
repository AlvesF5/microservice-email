package com.ms.microserviceemailmaven.adapters.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfig {

    @Value("\${spring.datasource.url}")
    lateinit var url : String

    @Value("\${spring.datasource.username}")
    lateinit var username : String

    @Value("\${spring.datasource.password}")
    lateinit var password : String

    @Bean
    fun getDataSource() : DataSource{

        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.url(url)
        dataSourceBuilder.username(username)
        dataSourceBuilder.password(password)

        return dataSourceBuilder.build()
    }
}