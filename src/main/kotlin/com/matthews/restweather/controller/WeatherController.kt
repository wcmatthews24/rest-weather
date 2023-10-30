package com.matthews.restweather.controller

import com.matthews.restweather.model.DailyWeather
import com.matthews.restweather.service.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class WeatherController(private val weatherService: WeatherService) {

    @GetMapping("/daily-forecast")
    fun currentWeather(): Mono<DailyWeather> {
        return weatherService.getCurrentWeather();
    }
}