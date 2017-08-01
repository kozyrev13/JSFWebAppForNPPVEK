package com.kozyrev.prime.faces.beans;

import com.kozyrev.jpa.data.CraneScale;
import com.kozyrev.spring.service.CraneScaleService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class MainBean {

    @ManagedProperty("#{craneScaleService}")
    private CraneScaleService craneScaleService;

    @ManagedProperty("#{sliderBean}")
    private SliderBean sliderBean;

    private List<CraneScale> craneScaleList;


    public SliderBean getSliderBean() {
        return sliderBean;
    }

    public void setSliderBean(SliderBean sliderBean) {
        this.sliderBean = sliderBean;
    }

    public CraneScaleService getCraneScaleService() {
        return craneScaleService;
    }

    public void setCraneScaleService(CraneScaleService craneScaleService) {
        this.craneScaleService = craneScaleService;
    }

    public List<CraneScale> getCraneScaleList() {
        if (craneScaleList==null) return craneScaleService.getList();
        else return craneScaleList;
    }

    public void getFilteredScaleList() {
        setCraneScaleList(craneScaleService.getFilteredList(sliderBean));
    }

    public void setCraneScaleList(List<CraneScale> craneScaleList) {
        this.craneScaleList = craneScaleList;
    }


}
