package com.example.furama2.customer;

import com.example.furama2.BaseRepository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    private final static String SELECT_CATEGORY = "select * from loai_khach";
    private final static String FIND_CATEGORY_BY_ID = "select * from loai_khach where ma_loai_khach = ?";

    @Override
    public List<CategoryCustomer> showListCategory() {
        List<CategoryCustomer> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);
            CategoryCustomer categoryCustomer;
            while (resultSet.next()){
                int id = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ten_loai_khach");
                categoryCustomer = new CategoryCustomer(id,name);
                list.add(categoryCustomer);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryCustomer findCategoryById(int id) {
        CategoryCustomer categoryCustomer = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(FIND_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idCategory = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ten_loai_khach");
                categoryCustomer = new CategoryCustomer(idCategory,name);
            }
            return categoryCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
