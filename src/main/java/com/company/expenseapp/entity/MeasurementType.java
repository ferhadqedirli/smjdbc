package com.company.expenseapp.entity;

public enum MeasurementType {
    KQ("kg."), METER("metr"), LITR("litr"), PACKAGE("bağlama"), QTY("ədəd"), RLN("rulon");

    private String name;

    MeasurementType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
