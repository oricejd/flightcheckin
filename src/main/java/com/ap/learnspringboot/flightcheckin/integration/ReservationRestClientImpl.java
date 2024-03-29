package com.ap.learnspringboot.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ap.learnspringboot.flightcheckin.integration.dto.Reservation;
import com.ap.learnspringboot.flightcheckin.integration.dto.ReservationUpadteRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
	}

	@Override
	public Reservation updateReservation(ReservationUpadteRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
	}

}
