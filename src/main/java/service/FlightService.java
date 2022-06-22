package service;

import model.Flight;
import model.User;
import repository.impl.FlightRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.util.Date;
import java.util.List;

public class FlightService {
    public static void fs() {

        FlightRepositoryImpl flightRepository = new FlightRepositoryImpl();

        Flight f = new Flight() ;
        f.setAirline("LH");
        f.setOrigin("AL");
        f.setDestination("NY");
        f.setfNumber(200);
        f.setdDate(new Date(2022,06,22));
        f.setaDate(new Date(2022,06,24));
        f.setStatus("not specified");
        flightRepository.save(f);
        List<Flight> flights = flightRepository.findAll();
        flights.stream().forEach(flight->System.out.println(flight));
        System.out.println(flightRepository.findById(1));
        flightRepository.delete(15);


    }
}
