package com.example.thi.thanh_toan;

import com.example.thi.BaseRepository.BaseRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoThanhToan implements IRepoThanhToan{
    private final static String SELECT_THANH_TOAN = "select * from hinh_thuc_thanh_toan;";
    private final static String TIM_KIEM_THANH_TOAN = "SELECT * from hinh_thuc_thanh_toan where hinh_thuc_thanh_toan.ma_hinh_thuc_thanh_toan=?;";
    private static JEditorPane response;

    @Override
    public List<ThanhToan> danhSachThanhToan() {
        List<ThanhToan> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_THANH_TOAN);
            ThanhToan thanhToan;
            while (resultSet.next()){
                int id = resultSet.getInt("ma_hinh_thuc_thanh_toan");
                String name = resultSet.getString("ten_hinh_thuc");
                thanhToan = new ThanhToan(id,name);
                list.add(thanhToan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ThanhToan timKiemThanhToan(int id) {
        ThanhToan thanhToan = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(TIM_KIEM_THANH_TOAN);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int ma = resultSet.getInt("ma_hinh_thuc_thanh_toan");
                String ten = resultSet.getString("ten_hinh_thuc");
                thanhToan= new ThanhToan(ma,ten);
            }
            return thanhToan;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        RepoThanhToan repoThanhToan=new RepoThanhToan();
        for (ThanhToan t:repoThanhToan.danhSachThanhToan()) {
            System.out.println(t.getMaThanhToan()+"  "+t.getTenThanhToan());
        }
    }
}
