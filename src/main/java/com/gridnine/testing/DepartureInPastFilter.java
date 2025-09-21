package com.gridnine.testing;

import java.time.LocalDateTime;

/**
 * Фильтр для рейсов, вылетевших раньше
 */
public class DepartureInPastFilter extends AbstractFlightFilter {

    @Override
    public boolean test(Flight flight) {
        LocalDateTime now = LocalDateTime.now();
        return flight.getSegments().stream()
                .allMatch(segment -> segment.getDepartureDate().isAfter(now));
    }
}