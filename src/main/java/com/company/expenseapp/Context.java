package com.company.expenseapp;

import com.company.expenseapp.database.dao.CategoryDao;
import com.company.expenseapp.database.impl.CategoryDaoImpl;

public class Context {
    public CategoryDao instanceCategoryDao() {
        return new CategoryDaoImpl();
    }
}
