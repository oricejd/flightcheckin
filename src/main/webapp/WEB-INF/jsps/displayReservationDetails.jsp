<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation details</title>
</head>
<body>
	<h2>Flight Details:</h2>
	Reservation : #${reservation.id}<br/>
	Airlines: ${reservation.flight.operatingAirlines}<br/>
	Flight Number: ${reservation.flight.operatingAirlines}<br/>
	Departure City: ${reservation.flight.departureCity}<br/>
	Arrival City: ${reservation.flight.arrivalCity}<br/>
	Date of Departure: ${reservation.flight.dateOfDeparture}<br/>
	Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}<br/>
	Checked In: ${reservation.checkedIn}<br/>

	<h2>Passenger Details</h2>
	First Name: ${reservation.passenger.firstName}<br/>
	Last Name: ${reservation.passenger.lastName}<br/> 
	Email: ${reservation.passenger.email}<br/>
	Phone: ${reservation.passenger.phone}<br/>

	<form action="completeCheckIn" method="post">
		Enter number of checked-in bags: <input type="text" name="numberOfBags" /> 
		<input type="hidden" name="reservationId" value="${reservation.id}" />
		<input type="submit" value="Check In" />
	</form>

</body>
</html>