package com.company.expenseapp.database.dao;

import com.company.expenseapp.entity.Sales;

import java.util.Date;
import java.util.List;

public interface SalesDao {
    boolean addSales(Sales sales);
    boolean updateSales(Sales sales);
    boolean removeSales(Integer salesId);
    List<Sales> getAllSales();
    Sales getSalesById(Integer salesId);
    List<Sales> getSalesByDate(Date fromDate, Date toDate);
}
