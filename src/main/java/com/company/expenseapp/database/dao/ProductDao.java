package com.company.expenseapp.database.dao;

import com.company.expenseapp.entity.Product;

import java.util.List;

public interface ProductDao {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean removeProduct(Integer id);
    List<Product> getAllProduct();
    Product getProductById(Integer id);
    Product getProductByBarcode(Integer barcode);
    List<Product> getAllProductByCategory(Integer categoryId);
    List<Product> getAllProductByName(String productName);
}
