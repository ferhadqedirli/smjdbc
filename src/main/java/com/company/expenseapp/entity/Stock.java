package com.company.expenseapp.entity;

public class Stock {
    private Integer stockId;
    private String stockName;
    private Integer salesId;
    private Integer productId;
    private Double quantity;
    private int state;

    public Stock() {
    }

    public Stock(String stockName, Integer salesId, Integer productId, Double quantity) {
        this.stockName = stockName;
        this.salesId = salesId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                ", salesId=" + salesId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
