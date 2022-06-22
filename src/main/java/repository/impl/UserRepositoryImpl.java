package repository.impl;

import model.User;
import repository.UserRepository;
import util.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    EntityFactory entityFactory = new EntityFactory();


    @Override
    public User save(User user) {
        EntityManager em = entityFactory.getEntityManager();
        if (user != null){
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        em.clear();
        return user;
    }

    @Override
    public List<User> findAll() {

        EntityManager em = entityFactory.getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u ");
        List<User> users = query.getResultList();
        em.clear();
        return users;
    }

    @Override
    public User findById(int id) {
        EntityManager em = entityFactory.getEntityManager();
        User user = em.find(User.class, id);

        return user;
    }

    @Override
    public void delete(int id) {
        User ud = findById(id);
        EntityManager em = entityFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(ud);
        em.getTransaction().commit();
        em.clear();
        System.out.println("Deleted user with id: " + id);
    }
}