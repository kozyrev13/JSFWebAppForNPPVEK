package com.kozyrev.prime.faces.beans;


import com.kozyrev.jpa.data.BucketDTO;
import com.kozyrev.jpa.data.CraneScale;
import com.kozyrev.spring.service.CraneScaleService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class AddToBucketButtonBean {

    @ManagedProperty("#{bucketBean}")
    private BucketBean bucketBean;

    @ManagedProperty("#{craneScaleService}")
    private CraneScaleService craneScaleService;

    public BucketBean getBucketBean() {
        return bucketBean;
    }

    public void setBucketBean(BucketBean bucketBean) {
        this.bucketBean = bucketBean;
    }

    public CraneScaleService getCraneScaleService() {
        return craneScaleService;
    }

    public void setCraneScaleService(CraneScaleService craneScaleService) {
        this.craneScaleService = craneScaleService;
    }

    public void buttonAction(Long id) {
        CraneScale craneScale = craneScaleService.findById(id);
        BucketDTO bucketDTO = new BucketDTO();
        bucketDTO.setTitle(craneScale.getTitle());
        bucketDTO.setPrice(craneScale.getPrice());
        bucketDTO.setQuantity(1);
        bucketBean.addBucketDTOtoList(bucketDTO);
        addMessage( craneScale.getTitle() + " добавлены в корзину.");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}