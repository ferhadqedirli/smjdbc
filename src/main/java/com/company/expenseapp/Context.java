package com.company.expenseapp;

import com.company.expenseapp.database.dao.CategoryDao;
import com.company.expenseapp.database.dao.ProductDao;
import com.company.expenseapp.database.impl.CategoryDaoImpl;
import com.company.expenseapp.database.impl.ProductDaoImpl;

public class Context {
    public static CategoryDao instanceCategoryDao() {
        return new CategoryDaoImpl();
    }

    public static ProductDao instanceProductDao() {
        return new ProductDaoImpl();
    }
}
