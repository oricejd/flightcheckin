package com.ap.learnspringboot.flightcheckin.integration;

import com.ap.learnspringboot.flightcheckin.integration.dto.Reservation;
import com.ap.learnspringboot.flightcheckin.integration.dto.ReservationUpadteRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpadteRequest request);

}
