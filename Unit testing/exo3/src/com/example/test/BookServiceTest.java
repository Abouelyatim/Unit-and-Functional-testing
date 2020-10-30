package com.example.test;

import com.example.dao.IReservationDao;
import com.example.dao.IRoomDao;
import com.example.model.Guest;
import com.example.model.Reservation;
import com.example.model.Room;
import com.example.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class BookServiceTest {

    IRoomDao roomDao;
    IReservationDao reservationDao;
    Reservation reservation;
    BookService bookser;
    Guest guest;
    @Before
    public void setUp() throws Exception {
        roomDao= Mockito.mock(IRoomDao.class);
        reservationDao=Mockito.mock(IReservationDao.class);
    }
    @Test
    public void bookRoom() throws Exception {

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        Date date_in=sdf.parse("22-01-2019");
        Date date_out=sdf.parse("29-01-2019");
        Room room=new Room(1,"room1",2);
        guest=new Guest("ibrahim","berkane");

        reservation=new Reservation(date_in,date_out,room,guest);

        Mockito.when(roomDao.isAvailable(room,date_in,date_out)).thenReturn(true);

        Mockito.when(reservationDao.createReservation(reservation)).thenReturn(true);

        bookser=new BookService(roomDao,reservationDao);

        Assert.assertEquals(bookser.bookRoom(room,date_in,date_out,guest),true);





    }



    @Test
    public void cancelReservation() throws Exception {

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        Date date_in=sdf.parse("22-01-2019");
        Date date_out=sdf.parse("29-01-2019");
        Room room=new Room(1,"room1",2);
        guest=new Guest("ibrahim","berkane");

        reservation=new Reservation(date_in,date_out,room,guest);

        Mockito.when(reservationDao.findReservation(1)).thenReturn(reservation);
        Mockito.when(reservationDao.cancelReservation(reservation)).thenReturn(true);

        bookser=new BookService(roomDao,reservationDao);

        Assert.assertEquals(bookser.cancelReservation(1),true);




    }

}