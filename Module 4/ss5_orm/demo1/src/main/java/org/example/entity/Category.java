package org.example.entity;


import java.util.List;
@Entity
@Table (name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name",columnDefinition = "varchar(50)")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category(int categoryId, String categoryName, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productList = productList;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
