package com.matthews.restweather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestWeatherApplication

fun main(args: Array<String>) {
	runApplication<RestWeatherApplication>(*args)
}
