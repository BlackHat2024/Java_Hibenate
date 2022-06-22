package repository.impl;

import model.UserDetail;
import util.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDetailRepositoryImpl {
    EntityFactory entityFactory = new EntityFactory();


    public UserDetail save(UserDetail userDetail) {
        EntityManager em = entityFactory.getEntityManager();
        if (userDetail != null){
            em.getTransaction().begin();
            em.merge(userDetail);
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().begin();
            em.persist(userDetail);
            em.getTransaction().commit();
        }
        em.clear();
        return userDetail;
    }

    public List<UserDetail> findAll() {
        EntityManager em = entityFactory.getEntityManager();
        Query query = em.createQuery("SELECT u FROM UserDetail u");
        List<UserDetail> userDetailsList = query.getResultList();
        em.clear();
        return userDetailsList;
    }


    public UserDetail findById(int id) {
        EntityManager em = entityFactory.getEntityManager();
        UserDetail userDetail = em.find(UserDetail.class, id);
        return userDetail;
    }

    public void delete(int id) {
        UserDetail ud = findById(id);
        EntityManager em = entityFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(ud);
        em.getTransaction().commit();
        em.clear();
        System.out.println("Deleted user details with id: " + id);
    }
}
