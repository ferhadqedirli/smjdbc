package com.company.expenseapp.database.dao;

import com.company.expenseapp.entity.Stock;

import java.util.List;

public interface StockDao {
    boolean addStock(Stock stock);
    boolean updateStock(Stock stock);
    boolean removeStock(Integer stockId);
    List<Stock> getAllStock();
    Stock getStockById(Integer stockId);
    Stock getStockByName(String stockName);
}
