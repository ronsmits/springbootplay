package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class DemoApplication {
    @Bean
    fun commandLineRunner(ctx: ApplicationContext)=CommandLineRunner {


        println("Let's inspect the beans provided by Spring Boot:")

//        ctx.beanDefinitionNames.sorted().forEach(::println)


    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}


