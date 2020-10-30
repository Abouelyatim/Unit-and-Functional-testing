package com.example.dao;

import com.example.model.Reservation;

public interface IReservationDao {
	
	boolean createReservation(Reservation reservation);

	Reservation findReservation(int id);

	boolean cancelReservation(Reservation reservation);

}
