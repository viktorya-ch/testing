package com.gridnine.testing;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterTest {

    @Test
    void testDepartureInPastFilter() {
        FlightFilter filter = new DepartureInPastFilter();

        /**
         * Рейс с прошлым вылетом
          */
        LocalDateTime past = LocalDateTime.now().minusDays(1);
        LocalDateTime future = LocalDateTime.now().plusDays(1);
        Flight pastFlight = createFlight(past, future);

        /**
         * Рейс с будущим вылетом
          */
        Flight futureFlight = createFlight(future, future.plusHours(2));

        assertFalse(filter.test(pastFlight));
        assertTrue(filter.test(futureFlight));
    }

    @Test
    void testArrivalBeforeDepartureFilter() {
        FlightFilter filter = new ArrivalBeforeDepartureFilter();

        /**
         * Недопустимый сегмент
          */
        LocalDateTime now = LocalDateTime.now();
        Flight invalidFlight = createFlight(now.plusHours(2), now);

        /**
         * Допустимый сегмент
          */
        Flight validFlight = createFlight(now, now.plusHours(2));

        assertFalse(filter.test(invalidFlight));
        assertTrue(filter.test(validFlight));
    }

    @Test
    void testExcessiveGroundTimeFilter() {
        FlightFilter filter = new ExcessiveGroundTimeFilter();

        /**
         * Полет с приемлемым временем на земле (1 час)
          */
        LocalDateTime base = LocalDateTime.now();
        Flight acceptableFlight = createFlight(
                base, base.plusHours(1),
                base.plusHours(2), base.plusHours(3) // 1 hour ground time
        );

        /**
         * Полет с превышением наземного времени (3 часа)
          */
        Flight excessiveFlight = createFlight(
                base, base.plusHours(1),
                base.plusHours(4), base.plusHours(5) // 3 hours ground time
        );

        assertTrue(filter.test(acceptableFlight));
        assertFalse(filter.test(excessiveFlight));

        /**
         * Односегментный полет всегда должен проходить
         */
        Flight singleSegment = createFlight(base, base.plusHours(2));
        assertTrue(filter.test(singleSegment));
    }

    private Flight createFlight(LocalDateTime... dates) {
        List<Segment> segments = Arrays.asList(
                new Segment(dates[0], dates[1])
        );
        return new Flight(segments);
    }

    private Flight createFlight(LocalDateTime dep1, LocalDateTime arr1,
                                LocalDateTime dep2, LocalDateTime arr2) {
        List<Segment> segments = Arrays.asList(
                new Segment(dep1, arr1),
                new Segment(dep2, arr2)
        );
        return new Flight(segments);
    }
}