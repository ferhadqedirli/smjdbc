package com.company.expenseapp.entity;

public class Product {
    private Integer productId;
    private Integer barcode;
    private Integer categoryId;
    private String productName;
    private Double purchasePrice;
    private Double sellingPrice;
    private CurrencyType currency;
    private MeasurementType measurement;
    private int state;

    public Product(Integer barcode, Integer categoryId, String productName, Double purchasePrice, Double sellingPrice, CurrencyType currency, MeasurementType measurement) {
        this.barcode = barcode;
        this.categoryId = categoryId;
        this.productName = productName;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.currency = currency;
        this.measurement = measurement;
    }

    public Product(Integer productId, Integer barcode, Integer categoryId, String productName, Double purchasePrice, Double sellingPrice) {
        this.productId = productId;
        this.barcode = barcode;
        this.categoryId = categoryId;
        this.productName = productName;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public MeasurementType getMeasurement() {
        return measurement;
    }

    public void setMeasurement(MeasurementType measurement) {
        this.measurement = measurement;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", barcode=" + barcode +
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", currency=" + currency.getLogo() +
                ", measurement=" + measurement.getName() +
                '}';
    }
}
