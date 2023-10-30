package com.matthews.restweather.service

import com.matthews.restweather.model.DailyWeather
import com.matthews.restweather.model.WeatherResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class WeatherService {

    private val webClient = WebClient.create()

    fun getCurrentWeather(): Mono<DailyWeather> {
        return webClient.get()
                .uri("https://api.weather.gov/gridpoints/MLB/33,70/forecast")
                .retrieve()
                .bodyToMono(WeatherResponse::class.java)
                .map {
                    val currentWeatherResponse = it.properties.periods[0]
                    DailyWeather(dayName = currentWeatherResponse.name,
                            tempHighCelsius = convertTempToCelsius(currentWeatherResponse.temperature),
                            forecastBlurp = currentWeatherResponse.shortForecast)
                }

    }

    fun convertTempToCelsius(tempInFahrenheit: Double): Double {
        return (tempInFahrenheit - 32) * 5.0 / 9.0
    }
}