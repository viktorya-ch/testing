package com.gridnine.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingApplication.class, args);

		/**
		 * Тестовые полеты
 		 */
		List<Flight> flights = FlightBuilder.createFlights();

		/**
		 * Оригинальные рейсы
 		 */
		FlightDisplay.displayFlights("ОРИГИНАЛЬНЫЕ РЕЙСЫ", flights);

		/**
		 * Тестируем каждый фильтр
 		 */
		testFilter(flights, FlightFilterFactory.FilterType.DEPARTURE_IN_PAST,
				"Рейсы, вылетавшие в прошлом");

		testFilter(flights, FlightFilterFactory.FilterType.ARRIVAL_BEFORE_DEPARTURE,
				"Сегменты с прибытием до вылета");

		testFilter(flights, FlightFilterFactory.FilterType.EXCESSIVE_GROUND_TIME,
						"Рейсы с превышением наземного времени (>2 часов)");
	}

	private static void testFilter(List<Flight> flights,
								   FlightFilterFactory.FilterType filterType,
								   String description) {
		FlightFilter filter = FlightFilterFactory.getFilter(filterType);
		List<Flight> filteredFlights = filter.filter(flights);
		FlightDisplay.displayFlights(description, filteredFlights);
	}
}