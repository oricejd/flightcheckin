package com.ap.learnspringboot.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ap.learnspringboot.flightcheckin.integration.ReservationRestClient;
import com.ap.learnspringboot.flightcheckin.integration.dto.Reservation;
import com.ap.learnspringboot.flightcheckin.integration.dto.ReservationUpadteRequest;

@Controller
public class CheckinController {
	

	@Autowired
	ReservationRestClient restClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation",reservation);
		return "displayReservationDetails";
	}
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(
			@RequestParam("reservationId") Long reservationId, 
			@RequestParam("numberOfBags") int numberOfBags,
			ModelMap modelMap)
	{
		ReservationUpadteRequest reservationUpadteRequest = new ReservationUpadteRequest();
		reservationUpadteRequest.setId(reservationId);
		reservationUpadteRequest.setCheckedIn(true);
		reservationUpadteRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpadteRequest);
		modelMap.addAttribute("msg","With reservation id: " + reservationId);
		return "checkInConfirmation";
	}

}
