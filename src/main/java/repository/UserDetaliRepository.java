package repository;

import model.UserDetail;

import java.util.List;

public interface UserDetaliRepository {
    public UserDetail save(UserDetail userDetail);

    public List<UserDetail> findAll();

    public UserDetail findById(int id);

    public void delete(int id);
}
