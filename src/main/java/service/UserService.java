package service;

import model.User;
import model.UserDetail;
import repository.impl.UserDetailRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.util.List;

public class UserService {
    public static void us() {

        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        UserDetailRepositoryImpl userDetailRepository = new UserDetailRepositoryImpl();
        UserDetail ud = new UserDetail();
        ud.setfName("Flavio");
        ud.setlName("Pernoj");
        ud.setEmail("flaviopernoj2024@gmail.com");
        ud.setPhNumber("0685035045");
        User u = new User() ;
        u.setUsername("BlackHatAL");
        u.setPassword("1234");
        u.setRole("Admin");
        u.setUserDetail(ud);


        userRepository.save(u);
        List<User> users = userRepository.findAll();
        users.stream().forEach(user->System.out.println(user));
        System.out.println(userRepository.findById(1));
        userRepository.delete(2);


    }


}
