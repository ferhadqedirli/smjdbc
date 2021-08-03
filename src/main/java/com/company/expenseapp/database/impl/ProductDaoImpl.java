package com.company.expenseapp.database.impl;

import com.company.expenseapp.database.dao.Connectable;
import com.company.expenseapp.database.dao.ProductDao;
import com.company.expenseapp.entity.CurrencyType;
import com.company.expenseapp.entity.MeasurementType;
import com.company.expenseapp.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao, Connectable {
    @Override
    public boolean addProduct(Product product) {
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("INSERT INTO PRODUCT (PRODUCT_ID, BARCODE, CATEGORY_ID, " +
                    "PRODUCT_NAME, PURCHASE_PRICE, SELLING_PRICE, CURRENCY, MEASUREMENT) " +
                    "VALUES (pro_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
            psmt.setInt(1, product.getBarcode());
            psmt.setInt(2, product.getCategoryId());
            psmt.setString(3, product.getProductName());
            if (product.getPurchasePrice() == null) {
                psmt.setDouble(4, 0);
            } else {
                psmt.setDouble(4, product.getPurchasePrice());
            }
            if (product.getSellingPrice() == null) {
                psmt.setDouble(5, 0);
            } else {
                psmt.setDouble(5, product.getSellingPrice());
            }
            psmt.setString(6, product.getCurrency().getLogo());
            psmt.setString(7, product.getMeasurement().getName());
            return psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("UPDATE PRODUCT SET BARCODE = ?, CATEGORY_ID = ?, " +
                    "PRODUCT_NAME = ?, PURCHASE_PRICE = ?, SELLING_PRICE = ?, CURRENCY = ?, MEASUREMENT = ?, STATE = ? WHERE PRODUCT_ID = ?");
            psmt.setInt(1, product.getBarcode());
            psmt.setInt(2, product.getCategoryId());
            psmt.setString(3, product.getProductName());
            if (product.getPurchasePrice() == null) {
                psmt.setDouble(4, 0);
            } else {
                psmt.setDouble(4, product.getPurchasePrice());
            }
            if (product.getSellingPrice() == null) {
                psmt.setDouble(5, 0);
            } else {
                psmt.setDouble(5, product.getSellingPrice());
            }
            psmt.setString(6, product.getCurrency().getLogo());
            psmt.setString(7, product.getMeasurement().getName());
            psmt.setInt(8, product.getState());
            psmt.setInt(9, product.getProductId());
            return psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeProduct(Integer id) {
        Product product = getProductById(id);
        product.setState(0);
        return updateProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT " +
                    "P.PRODUCT_ID, P.BARCODE, P.PRODUCT_NAME, P.PURCHASE_PRICE, P.SELLING_PRICE, P.CURRENCY, P.MEASUREMENT, C.ID AS CATEGORY_ID, C.CATEGORY_NAME " +
                    "FROM PRODUCT P " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE P.STATE = 1");
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                products.add(getProduct(rs));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = null;
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT " +
                    "P.*, CATEGORY_ID, C.CATEGORY_NAME " +
                    "FROM PRODUCT P " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE P.PRODUCT_ID = ? AND P.STATE = 1");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                product = getProduct(rs);
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product getProductByBarcode(Integer barcode) {
        Product product = null;
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT " +
                    "P.*, CATEGORY_ID, C.CATEGORY_NAME " +
                    "FROM PRODUCT P " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE P.BARCODE = ? P.STATE = 1");
            psmt.setInt(1, barcode);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                product = getProduct(rs);
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getAllProductByCategory(Integer categoryId) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT " +
                    "P.PRODUCT_ID, P.BARCODE, P.PRODUCT_NAME, P.PURCHASE_PRICE, P.SELLING_PRICE, P.CURRENCY, P.MEASUREMENT, C.ID AS CATEGORY_ID, C.CATEGORY_NAME " +
                    "FROM PRODUCT P " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE P.STATE = 1 AND CATEGORY_ID = ?");
            psmt.setInt(1, categoryId);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                products.add(getProduct(rs));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getAllProductByName(String productName) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT " +
                    "P.PRODUCT_ID, P.BARCODE, P.PRODUCT_NAME, P.PURCHASE_PRICE, P.SELLING_PRICE, P.CURRENCY, P.MEASUREMENT, C.ID AS CATEGORY_ID, C.CATEGORY_NAME " +
                    "FROM PRODUCT P " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE P.STATE = 1 AND PRODUCT_NAME = ?");
            psmt.setString(1, productName.trim());
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                products.add(getProduct(rs));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getAllProductByCategoryName(String categoryName) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement psmt = connection.prepareStatement("SELECT " +
                    "P.PRODUCT_ID, P.BARCODE, P.PRODUCT_NAME, P.PURCHASE_PRICE, P.SELLING_PRICE, P.CURRENCY, P.MEASUREMENT, C.ID AS CATEGORY_ID, C.CATEGORY_NAME " +
                    "FROM PRODUCT P " +
                    "LEFT JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE P.STATE = 1 AND CATEGORY_NAME = ?");
            psmt.setString(1, categoryName.trim());
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                products.add(getProduct(rs));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Product getProduct(ResultSet rs) throws SQLException {
        Integer productId = rs.getInt("PRODUCT_ID");
        Integer barcode = rs.getInt("BARCODE");
        String productName = rs.getString("PRODUCT_NAME");
        Double purchasePrice = rs.getDouble("PURCHASE_PRICE");
        Double sellingPrice = rs.getDouble("SELLING_PRICE");
        String currency = rs.getString("CURRENCY");
        String measurement = rs.getString("MEASUREMENT");
        Integer categoryId = rs.getInt("CATEGORY_ID");

        Product product = new Product(productId, barcode, categoryId, productName, purchasePrice, sellingPrice);

        switch (currency) {
            case "₼" -> product.setCurrency(CurrencyType.AZN);
            case "$" -> product.setCurrency(CurrencyType.USD);
            case "€" -> product.setCurrency(CurrencyType.EUR);
        }

        switch (measurement) {
            case "kg." -> product.setMeasurement(MeasurementType.KQ);
            case "metr" -> product.setMeasurement(MeasurementType.METER);
            case "litr" -> product.setMeasurement(MeasurementType.LITR);
            case "bağlama" -> product.setMeasurement(MeasurementType.PACKAGE);
            case "ədəd" -> product.setMeasurement(MeasurementType.QTY);
            case "rulon" -> product.setMeasurement(MeasurementType.RLN);
        }
        return product;
    }
}
