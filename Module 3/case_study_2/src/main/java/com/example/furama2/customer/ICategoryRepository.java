package com.example.furama2.customer;

import java.util.List;

public interface ICategoryRepository {
    List<CategoryCustomer> showListCategory();
    CategoryCustomer findCategoryById(int id);
}
