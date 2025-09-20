package com.gridnine.testing;

import java.util.List;

/**
 * Interface для определения правил фильтрации рейсов
 */
public interface FlightFilter {
    boolean test(Flight flight);
    List<Flight> filter(List<Flight> flights);
}
