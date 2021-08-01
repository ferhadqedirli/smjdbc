package com.company.expenseapp.database.impl;

import com.company.expenseapp.database.dao.Connectable;
import com.company.expenseapp.database.dao.ProductDao;
import com.company.expenseapp.entity.Product;

import java.util.List;

public class ProductDaoImpl implements ProductDao, Connectable {
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean removeProduct(Integer id) {
        return false;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public Product getProductByBarcode(Integer barcode) {
        return null;
    }

    @Override
    public List<Product> getAllProductByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Product> getAllProductByName(String productName) {
        return null;
    }
}
