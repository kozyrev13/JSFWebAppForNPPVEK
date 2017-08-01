package com.kozyrev.spring.service;

import com.kozyrev.jpa.data.CraneScale;
import com.kozyrev.prime.faces.beans.SliderBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class CraneScaleService {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public List<CraneScale> getList(){
        Query query = em.createNativeQuery("SELECT * FROM crane_scale",CraneScale.class);
        return query.getResultList();
    }


    @Transactional
    public List<CraneScale> getFilteredList(SliderBean sliderBean){
        Query query = em.createNativeQuery(
                "SELECT * FROM crane_scale where price>=? AND price<=? and cargo_capacity >=? and cargo_capacity<=?",
                 CraneScale.class);
        query.setParameter(1, sliderBean.getMinPrice());
        query.setParameter(2, sliderBean.getMaxPrice());
        query.setParameter(3, sliderBean.getMinCapacity());
        query.setParameter(4, sliderBean.getMaxCapacity());
        return query.getResultList();
    }


    @Transactional
    public CraneScale findById(Long id){
        Query query = em.createNativeQuery("SELECT * FROM crane_scale WHERE id=?",CraneScale.class);
        query.setParameter(1,id);
        return (CraneScale) query.getSingleResult();
    }
}
