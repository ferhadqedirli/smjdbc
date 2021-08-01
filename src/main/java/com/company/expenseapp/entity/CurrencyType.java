package com.company.expenseapp.entity;

public enum CurrencyType {
    AZN("₼"), USD("$"), EUR("€");

    private String logo;

    CurrencyType(String logo) {
        this.logo = logo;
    }
}
