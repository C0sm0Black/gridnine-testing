package com.gridnine.testing;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFilterTest {

    @Test
    void exclusionFlightsByParameterBy_LATE_success() {

        //Input data preparation

        LocalDateTime nowTime = LocalDateTime.now();

        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> expectedListFlights;
        List<Flight> actualListFlights;

        //Preparing the expected result

        expectedListFlights = Arrays.asList(flightList.get(0),
                flightList.get(1),
                flightList.get(3),
                flightList.get(4),
                flightList.get(5));

        //Test start

        actualListFlights = FlightFilter.exclusionFlightsByParameter(flightList, nowTime, FlightParameter.LATE);
        assertEquals( expectedListFlights, actualListFlights);

    }

    @Test
    void exclusionFlightsByParameterBy_LESS_THAN_success() {

        //Input data preparation

        LocalDateTime nowTime = LocalDateTime.now();

        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> expectedListFlights;
        List<Flight> actualListFlights;

        //Preparing the expected result

        expectedListFlights = Arrays.asList(flightList.get(0),
                flightList.get(1),
                flightList.get(2),
                flightList.get(4),
                flightList.get(5));

        //Test start

        actualListFlights = FlightFilter.exclusionFlightsByParameter(flightList, nowTime, FlightParameter.LESS_THAN);
        assertEquals(expectedListFlights, actualListFlights);

    }

    @Test
    void exclusionFlightsByParameterBy_MORE_THAN_success() {

        //Input data preparation

        LocalDateTime nowTime = LocalDateTime.now();

        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> expectedListFlights;
        List<Flight> actualListFlights;

        //Preparing the expected result

        expectedListFlights = Arrays.asList(flightList.get(0),
                flightList.get(1),
                flightList.get(2),
                flightList.get(3));

        //Test start

        actualListFlights = FlightFilter.exclusionFlightsByParameter(flightList, nowTime, FlightParameter.MORE_THAN);
        assertEquals(expectedListFlights, actualListFlights);

    }

}