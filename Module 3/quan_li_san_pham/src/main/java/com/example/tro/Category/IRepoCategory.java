package com.example.tro.Category;

import java.util.List;

public interface IRepoCategory {
    List<Category> getAll();
    Category findById(int id);
}
