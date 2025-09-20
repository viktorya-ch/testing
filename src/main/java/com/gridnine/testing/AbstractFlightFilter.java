package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Абстрактный базовый класс для FlightFilters
 */
public abstract class AbstractFlightFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(this::test)
                .collect(Collectors.toList());
    }

}