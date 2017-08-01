package com.kozyrev.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    @Column(name = "phone_number")
    private String pnoneNumber;

    @Column(name = "order_description")
    private String orderDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPnoneNumber() {
        return pnoneNumber;
    }

    public void setPnoneNumber(String pnoneNumber) {
        this.pnoneNumber = pnoneNumber;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
