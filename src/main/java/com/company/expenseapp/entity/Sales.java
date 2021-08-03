package com.company.expenseapp.entity;

import java.sql.Date;

public class Sales {
    private Integer salesId;
    private Date salesDate;
    private Integer productId;
    private Double quantity;
    private CurrencyType currency;
    private Double price;
    private int state;

    public Sales(Integer salesId, Date salesDate, Integer productId, Double quantity, Double price) {
        this.salesId = salesId;
        this.salesDate = salesDate;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId=" + salesId +
                ", salesDate=" + salesDate +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", currency=" + currency +
                ", price=" + price +
                '}';
    }
}
