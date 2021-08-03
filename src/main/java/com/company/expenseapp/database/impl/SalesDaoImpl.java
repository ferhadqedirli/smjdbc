package com.company.expenseapp.database.impl;

import com.company.expenseapp.database.dao.Connectable;
import com.company.expenseapp.database.dao.SalesDao;
import com.company.expenseapp.entity.CurrencyType;
import com.company.expenseapp.entity.Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesDaoImpl implements SalesDao, Connectable {

    @Override
    public boolean addSales(Sales sales) {
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("INSERT INTO SALES " +
                    "(SALES_ID, SALES_DATE, PRODUCT_ID, QUANTITY, CURRENCY, PRICE) " +
                    "VALUES (sal_seq.NEXTVAL, ?, ?, ?, ?, ?)");
            psmt.setDate(1, sales.getSalesDate());
            psmt.setInt(2, sales.getProductId());
            psmt.setDouble(3, sales.getQuantity());
            psmt.setString(4, sales.getCurrency().getLogo());
            psmt.setDouble(5, sales.getPrice());
            return psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSales(Sales sales) {
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("UPDATE SALES SET " +
                    "SALES_DATE = ?, PRODUCT_ID = ?, QUANTITY = ?, CURRENCY = ?, PRICE = ?, STATE = ? " +
                    "WHERE SALES_ID = ?");
            psmt.setDate(1, sales.getSalesDate());
            psmt.setInt(2, sales.getProductId());
            psmt.setDouble(3, sales.getQuantity());
            psmt.setString(4, sales.getCurrency().getLogo());
            psmt.setDouble(5, sales.getPrice());
            psmt.setInt(6, sales.getState());
            psmt.setInt(7, sales.getSalesId());
            return psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSales(Integer salesId) {
        Sales sales = getSalesById(salesId);
        sales.setState(0);
        return updateSales(sales);
    }

    @Override
    public List<Sales> getAllSales() {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT  " +
                    "S.SALES_ID, SALES_DATE, S.PRODUCT_ID, P.BARCODE, P.PRODUCT_NAME, S.QUANTITY, S.PRICE, S.CURRENCY, " +
                    "C.CATEGORY_NAME, S.STATE " +
                    "FROM SALES S  " +
                    "LEFT JOIN PRODUCT P ON S.PRODUCT_ID = P.PRODUCT_ID " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE S.STATE = 1");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                salesList.add(getSales(rs));
            }
            return salesList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Sales getSalesById(Integer salesId) {
        Sales sales = null;
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT  " +
                    "S.SALES_ID, SALES_DATE, S.PRODUCT_ID, P.BARCODE, P.PRODUCT_NAME, S.QUANTITY, S.PRICE, S.CURRENCY, " +
                    "C.CATEGORY_NAME, S.STATE " +
                    "FROM SALES S  " +
                    "LEFT JOIN PRODUCT P ON S.PRODUCT_ID = P.PRODUCT_ID " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE S.STATE = 1 AND SALES_ID = ?");
            psmt.setInt(1, salesId);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                sales = getSales(rs);
            }
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Sales> getSalesByDate(Date fromDate, Date toDate) {
        List<Sales> salesList = new ArrayList<>();
        try (Connection connection = connect()){
            PreparedStatement psmt = connection.prepareStatement("SELECT  " +
                    "S.SALES_ID, SALES_DATE, S.PRODUCT_ID, P.BARCODE, P.PRODUCT_NAME, S.QUANTITY, S.PRICE, S.CURRENCY, " +
                    "C.CATEGORY_NAME, S.STATE " +
                    "FROM SALES S  " +
                    "LEFT JOIN PRODUCT P ON S.PRODUCT_ID = P.PRODUCT_ID " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE S.SALES_DATE BETWEEN TO_DATE(?) AND TO_DATE(?) AND S.STATE = 1");
            psmt.setDate(1, (java.sql.Date) fromDate);
            psmt.setDate(2, (java.sql.Date) toDate);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                salesList.add(getSales(rs));
            }
            return salesList;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Sales getSales(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("SALES_ID");
        java.sql.Date salesDate = rs.getDate("SALES_DATE");
        Integer productId = rs.getInt("PRODUCT_ID");
        Double quantity = rs.getDouble("QUANTITY");
        String currency = rs.getString("CURRENCY");
        Double price = rs.getDouble("PRICE");

        Sales sales = new Sales(id, salesDate, productId, quantity, price);
        switch (currency) {
            case "₼" -> sales.setCurrency(CurrencyType.AZN);
            case "$" -> sales.setCurrency(CurrencyType.USD);
            case "€" -> sales.setCurrency(CurrencyType.EUR);
        }
        return sales;
    }
}
