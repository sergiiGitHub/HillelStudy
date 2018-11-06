package com.sport.my.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sergii on 30.10.18.
 */
public class ProductService {

    public EntityManager em = Persistence.createEntityManagerFactory("SPORTTEAM").createEntityManager();

    public ProductJpa add(ProductJpa productJpa) {
        ProductJpa ProductJpaFromDb = null;

        em.getTransaction().begin();
        ProductJpaFromDb = em.merge(productJpa);
        em.getTransaction().commit();
        return ProductJpaFromDb;
    }

    public ProductJpa get(int id) {
        return em.find(ProductJpa.class, id);
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(ProductJpa ProductJpa) {
        em.getTransaction().begin();
        em.merge(ProductJpa);
        em.getTransaction().commit();
    }

    public List<ProductJpa> getAll() {
        TypedQuery<ProductJpa> nameQuery = em.createNamedQuery("ProductJpa.getAll", ProductJpa.class);
        return nameQuery.getResultList();
    }
 }
