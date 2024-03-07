package com.example.tro.Category;

import com.example.tro.BaseRepository.BaseRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoCategory implements IRepoCategory{
    private final static String SELECT_CATEGORY = "select * from danh_muc;";
    private final static String TIM_KIEM_CATEGORY = "select * from danh_muc where danh_muc.id_danh_muc=?;";
    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);
            Category category;
            while (resultSet.next()){
                int id = resultSet.getInt("id_danh_muc");
                String name = resultSet.getString("ten");
                category = new Category(id,name);
                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Category findById(int id) {
        Category category = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(TIM_KIEM_CATEGORY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int ma = resultSet.getInt("id_danh_muc");
                String name = resultSet.getString("ten");
                category= new Category(ma,name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

}
