package com.company.expenseapp.database.impl;

import com.company.expenseapp.database.dao.Connectable;
import com.company.expenseapp.database.dao.SalesDao;
import com.company.expenseapp.entity.Sales;

import java.util.Date;
import java.util.List;

public class SalesDaoImpl implements SalesDao, Connectable {
    @Override
    public boolean addSales(Sales sales) {
        return false;
    }

    @Override
    public boolean updateSales(Sales sales) {
        return false;
    }

    @Override
    public boolean removeSales(Integer salesId) {
        return false;
    }

    @Override
    public List<Sales> getAllSales() {
        return null;
    }

    @Override
    public Sales getSalesById(Integer salesId) {
        return null;
    }

    @Override
    public List<Sales> getSalesByDate(Date fromDate, Date toDate) {
        return null;
    }
}
