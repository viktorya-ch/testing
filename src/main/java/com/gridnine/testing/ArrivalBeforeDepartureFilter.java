package com.gridnine.testing;

/**
 * Фильтр для сегментов с прибытием до вылета
 */
public class ArrivalBeforeDepartureFilter extends AbstractFlightFilter {

    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(segment ->
                        segment.getArrivalDate().isAfter(segment.getDepartureDate()));
    }
}
