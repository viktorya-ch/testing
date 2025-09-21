package com.gridnine.testing;

import java.util.List;

/**
 * Utility класс для отображения информации о рейсе
 */
public class FlightDisplay {

    public static void displayFlights(String title, List<Flight> flights) {
        System.out.println("=== " + title + " ===");
        System.out.println("Total flights: " + flights.size());

        if (flights.isEmpty()) {
            System.out.println("No flights found.");
        } else {
            for (int i = 0; i < flights.size(); i++) {
                System.out.println((i + 1) + ". " + flights.get(i));
            }
        }
        System.out.println();
    }
}

