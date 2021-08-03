package com.company.expenseapp;

import com.company.expenseapp.database.dao.SalesDao;
import com.company.expenseapp.entity.CurrencyType;
import com.company.expenseapp.entity.Sales;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExpenseApp {
    public static void main(String[] args) {
        SalesDao dao = Context.instanceSalesDao();
//        Sales sales = new Sales(Date.valueOf("2021-08-03"), 1001, 12.0, CurrencyType.AZN, 3.0);
//        dao.addSales(sales);

//        Sales sales = dao.getSalesById(1000);
//        sales.setQuantity(7.0);
//        dao.updateSales(sales);

//        dao.removeSales(1002);

//        Date fromDate = Date.valueOf("2021-08-03");
//        Date toDate = Date.valueOf("2021-09-03");
//
//        System.out.println(dao.getSalesByDate(fromDate, toDate));

//        List<Sales> list = dao.getAllSales();
//
//        for (Sales s : list) {
//            System.out.println(s);
//        }
    }
}
