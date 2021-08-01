package com.company.expenseapp.database.impl;

import com.company.expenseapp.database.dao.Connectable;
import com.company.expenseapp.database.dao.StockDao;
import com.company.expenseapp.entity.Stock;

import java.util.List;

public class StockDaoImpl implements StockDao, Connectable {
    @Override
    public boolean addStock(Stock stock) {
        return false;
    }

    @Override
    public boolean updateStock(Stock stock) {
        return false;
    }

    @Override
    public boolean removeStock(Integer stockId) {
        return false;
    }

    @Override
    public List<Stock> getAllStock() {
        return null;
    }

    @Override
    public Stock getStockById(Integer stockId) {
        return null;
    }

    @Override
    public Stock getStockByName(String stockName) {
        return null;
    }
}
