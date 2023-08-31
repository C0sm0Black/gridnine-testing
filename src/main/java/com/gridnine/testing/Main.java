package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println("Начальный список всех полётов без фильтрации:");
        printFlightList(flightList);

        System.out.println("Список полётов, где исключены полёты:" +
                " у котрых имеются сегменты с датой прилёта раньше даты вылета");
        printFlightList(FlightFilter
                .exclusionFlightsByParameter(flightList, LocalDateTime.now(), FlightParameter.LATE));

        System.out.println("Список полётов, где исключены полёты:" +
                " у которых имеются сегменты с датой прилёта раньше даты вылета");
        printFlightList(FlightFilter
                .exclusionFlightsByParameter(flightList, LocalDateTime.now(), FlightParameter.LESS_THAN));

        System.out.println("Список полётов, где исключены полёты:" +
                " у которых имеются сегменты где общее время, проведённое на земле превышает два часа");
        printFlightList(FlightFilter
                .exclusionFlightsByParameter(flightList, LocalDateTime.now(), FlightParameter.MORE_THAN));

        FlightFilter
                .exclusionFlightsByParameter(flightList, LocalDateTime.now(), FlightParameter.MORE_THAN);

    }

    private static void printFlightList(List<Flight> flightList) {

        int i = 1;

        for (Flight flight : flightList) {

            System.out.println(i + ". " + flight);
            i++;

        }

        System.out.println();

    }

}
