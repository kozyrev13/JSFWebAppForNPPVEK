package com.kozyrev.jpa.data;


public class BucketDTO {
    private String title;
    private Integer quantity;
    private Long price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void incrementQuantity(){
        this.quantity=this.quantity+1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BucketDTO bucketDTO = (BucketDTO) o;

        if (title != null ? !title.equals(bucketDTO.title) : bucketDTO.title != null) return false;
        return price != null ? price.equals(bucketDTO.price) : bucketDTO.price == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  title + " " + quantity + " шт. Цена:" + price + ";\b";
    }


}
