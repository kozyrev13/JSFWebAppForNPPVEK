package com.kozyrev.prime.faces.beans;

import com.kozyrev.jpa.data.BucketDTO;
import com.kozyrev.jpa.data.Order;
import com.kozyrev.spring.service.OrderService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class BucketBean {

    private String phone;

    private ArrayList<BucketDTO> dtoArrayList = new ArrayList<>();

    Long sum = 0L;

    public Long getSum() {
        sum=calculateSum();
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @ManagedProperty("#{orderService}")
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Long calculateSum(){
        long sum = 0;
        if(dtoArrayList.isEmpty()) return null;
        for (BucketDTO bucketDTO:dtoArrayList){
            sum+=bucketDTO.getPrice()*bucketDTO.getQuantity();
        }
        return sum;
    }

    public void addBucketDTOtoList(BucketDTO bucketDTO){
        int index = dtoArrayList.indexOf(bucketDTO);
        if (index!=-1) {dtoArrayList.get(index).incrementQuantity(); return;}
        dtoArrayList.add(bucketDTO);
    }

    public ArrayList<BucketDTO> getDtoArrayList() {
        return dtoArrayList;
    }

    public String dtoArrayListToString(){
        String s ="";
        StringBuilder sb = new StringBuilder(s);
        for (BucketDTO dto: dtoArrayList){
            sb.append(dto.toString());
            sb.append("\n");
        }
        sb.append("----------------------------------------\n");
        sb.append("Итого: ");
        sb.append(sum);
        return sb.toString();
    }

    public void setDtoArrayList(ArrayList<BucketDTO> dtoArrayList) {
        this.dtoArrayList = dtoArrayList;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void add(Long Id){

    }

    public String registrAction(int i) {
        Order order = new Order();
        order.setPnoneNumber(this.getPhone());
        order.setOrderDescription(this.dtoArrayListToString());
        orderService.addOrder(order);
        // Add message
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Заказ по вашему  "+this.phone+" обрабатывается. Ожидайте звонка."));
        dtoArrayList.clear();
        return "";
    }
}
