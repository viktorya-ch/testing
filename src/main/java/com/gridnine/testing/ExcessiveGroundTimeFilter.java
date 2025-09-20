package com.gridnine.testing;

import java.time.Duration;
import java.util.List;

/**
 * Фильтр для рейсов с избыточным временем ожидания на земле
 */
public class ExcessiveGroundTimeFilter extends AbstractFlightFilter {
    private static final long MAX_GROUND_TIME_HOURS = 2;

    @Override
    public boolean test(Flight flight) {
        List<Segment> segments = flight.getSegments();

        /**
         * На односегментных рейсах нет наземного времени.
         */
        if (segments.size() <= 1) {
            return true;
        }

        /**
         * Рассчитываем общее время работы на земле
         */
        long totalGroundTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            Segment current = segments.get(i);
            Segment next = segments.get(i + 1);

            Duration groundTime = Duration.between(
                    current.getArrivalDate(),
                    next.getDepartureDate()
            );

            totalGroundTime += groundTime.toHours();

            /**
             * Досрочный выход, если время ожидания на земле превысит установленный лимит
             */
            if (totalGroundTime > MAX_GROUND_TIME_HOURS) {
                return false;
            }
        }

        return totalGroundTime <= MAX_GROUND_TIME_HOURS;
    }
}
