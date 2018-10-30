package jpaproject.crud;

import jpaproject.entity.Car;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sergii on 30.10.18.
 */
public class CarService {

    public EntityManager em = Persistence.createEntityManagerFactory("SPORTTEAM").createEntityManager();

    public Car add(Car car) {
        Car carFromDb = null;

        em.getTransaction().begin();
        carFromDb = em.merge(car);
        try {

            em.getTransaction().commit();
        } catch (TransactionRequiredException | RollbackException ex){
            em.getTransaction().rollback();
        }
        return carFromDb;
    }

    public Car get(long id) {
        return em.find(Car.class, id);
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(Car car) {
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public List<Car> getAll() {
        TypedQuery<Car> nameQuery = em.createNamedQuery("Car.getAll", Car.class);
        return nameQuery.getResultList();
    }
 }
