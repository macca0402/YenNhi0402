package com.example.furama2.customer;

public class CategoryCustomer {
    int category;
    String nameCategory;

    public CategoryCustomer(int category, String nameCategory) {
        this.category = category;
        this.nameCategory = nameCategory;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
