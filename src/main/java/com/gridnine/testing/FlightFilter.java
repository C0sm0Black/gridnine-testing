package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter {

    public static List<Flight> exclusionFlightsByParameter(List<Flight> flightList,
                                                           LocalDateTime requiredDate,
                                                           FlightParameter flightParameter) {

        List<Flight> filteredFlights = new ArrayList<>();

        flightList.forEach(flight -> {

            List<Segment> flightSegments = flight.getSegments();

            switch (flightParameter) {

                case LATE -> {

                    if (flightSegments
                            .stream()
                            .noneMatch(segment -> segment.getDepartureDate().isBefore(requiredDate))) {
                        filteredFlights.add(flight);
                    }
                }
                case LESS_THAN -> {

                    if (flightSegments
                            .stream()
                            .noneMatch(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate()))) {
                        filteredFlights.add(flight);
                    }
                }
                case MORE_THAN -> {

                    if (flightSegments.size() == 1) {

                        filteredFlights.add(flight);
                        break;

                    }

                    LocalDateTime firstArrivalDate;

                    for (int i = 1; i < flightSegments.size(); i++) {

                        firstArrivalDate = flightSegments.get(i - 1).getArrivalDate();

                        if (flightSegments.get(i).getDepartureDate().isAfter(firstArrivalDate.plusHours(2))
                                || flightSegments.get(i).getDepartureDate().equals(firstArrivalDate.plusHours(2))) {
                            return;
                        }

                    }

                    filteredFlights.add(flight);
                }

            }

        });

        return filteredFlights;

    }

}



