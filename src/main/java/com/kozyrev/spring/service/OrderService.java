package com.kozyrev.spring.service;

import com.kozyrev.jpa.data.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class OrderService {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public List<Order> getList(){
        Query query = em.createNativeQuery("SELECT * FROM orders ORDER BY id DESC ",Order.class);
        return query.getResultList();
    }

    @Transactional
    public void addOrder(Order order) {

        this.em.persist(order);
    }
}
