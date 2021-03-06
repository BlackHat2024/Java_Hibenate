package repository.impl;

import model.Booking;
import util.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookingRepositoryImpl {
    EntityFactory entityFactory = new EntityFactory();

    public Booking save(Booking booking) {
        EntityManager em = entityFactory.getEntityManager();
        if (booking != null){
            em.getTransaction().begin();
            em.merge(booking);
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
        }
        em.clear();
        return booking;
    }

    public List<Booking> findAll() {
        EntityManager em = entityFactory.getEntityManager();
        Query query = em.createQuery("SELECT b FROM Booking  b");
        List<Booking> bookings = query.getResultList();
        em.clear();
        return bookings;
    }

    public Booking findById(int id) {
        EntityManager em = entityFactory.getEntityManager();
        Booking booking = em.find(Booking.class, id);
        return booking;
    }

    public void delete(int id) {
        Booking bookingToDelete= findById(id);
        EntityManager em = entityFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(bookingToDelete);
        em.getTransaction().commit();
        em.close();
        System.out.println("Deleted booking with id: " + id);
    }
}
