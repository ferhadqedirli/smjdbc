package com.company.expenseapp.database.dao;

import com.company.expenseapp.entity.Category;

import java.util.List;

public interface CategoryDao {
    boolean add(Category category);
    boolean remove(int id);
    boolean update(Category category);
    Category getById(int id);
    Category getByName(String categoryName);
    List<Category> getAll();
}
