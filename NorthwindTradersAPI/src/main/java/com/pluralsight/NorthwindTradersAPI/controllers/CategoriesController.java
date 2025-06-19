package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    @Qualifier("categoryDao")
    private CategoryDao categoryDao;

    // constructor
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    // returns list of categories
    @GetMapping("/api/categories")
    public List<Category> getCategories(){
        return categoryDao.getAll();
    }

    // returns list of categories by id
    @GetMapping("/api/categories/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryDao.getById(id);
    }

    // adding postmapping
    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }

}
