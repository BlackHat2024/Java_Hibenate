package service;

import model.Booking;
import model.User;
import repository.impl.BookingRepositoryImpl;
import repository.impl.UserRepositoryImpl;


import java.util.Date;
import java.util.List;

public class BookingService {
    public static void bs() {

        BookingRepositoryImpl bookingRepository = new BookingRepositoryImpl();

        Booking b = new Booking() ;
        b.setBooking_date(new Date(2022,06,22));
        b.setStatus("Approved");

        List<Booking> bookings = bookingRepository.findAll();
        bookings.stream().forEach(book->System.out.println(book));
        System.out.println(bookingRepository.findById(1));
        bookingRepository.delete(1);


    }
}
