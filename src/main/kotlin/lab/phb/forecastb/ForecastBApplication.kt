package lab.phb.forecastb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForecastBApplication

fun main(args: Array<String>) {
	runApplication<ForecastBApplication>(*args)
}
