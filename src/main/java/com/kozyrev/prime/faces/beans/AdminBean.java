package com.kozyrev.prime.faces.beans;

import com.kozyrev.jpa.data.Order;
import com.kozyrev.spring.service.OrderService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class AdminBean {

    @ManagedProperty("#{orderService}")
    private OrderService orderService;

    List<Order> orderList;

    public List<Order> getOrderList() {
        return orderService.getList();
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
