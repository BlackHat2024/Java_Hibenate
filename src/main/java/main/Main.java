package main;


import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.BookingService;
import service.FlightService;
import service.UserDetailService;
import service.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService.us();
        //BookingService.bs();
        //UserDetailService.uds();
        //FlightService.fs();


    }

}
