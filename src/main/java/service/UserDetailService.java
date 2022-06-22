package service;

import model.User;
import model.UserDetail;
import repository.impl.UserDetailRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.util.List;

public class UserDetailService {
    public static void uds() {
        UserDetailRepositoryImpl userDetailRepositoryRepository = new UserDetailRepositoryImpl();

        List<UserDetail> userDetails = userDetailRepositoryRepository.findAll();
        userDetails.stream().forEach(detail -> System.out.println(detail));
        System.out.println(userDetailRepositoryRepository.findById(1));
        userDetailRepositoryRepository.delete(15);
    }
}
