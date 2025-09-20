package com.gridnine.testing;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory для создания летных фильтров
 */
public class FlightFilterFactory {

    public enum FilterType {
        DEPARTURE_IN_PAST,
        ARRIVAL_BEFORE_DEPARTURE,
        EXCESSIVE_GROUND_TIME
    }

    private static final Map<FilterType, FlightFilter> filters = new HashMap<>();

    static {
        filters.put(FilterType.DEPARTURE_IN_PAST, new DepartureInPastFilter());
        filters.put(FilterType.ARRIVAL_BEFORE_DEPARTURE, new ArrivalBeforeDepartureFilter());
        filters.put(FilterType.EXCESSIVE_GROUND_TIME, new ExcessiveGroundTimeFilter());
    }

    public static FlightFilter getFilter(FilterType type) {
        return filters.get(type);
    }
}