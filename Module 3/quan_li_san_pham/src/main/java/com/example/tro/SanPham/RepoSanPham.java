package com.example.tro.SanPham;

import com.example.tro.BaseRepository.BaseRepository;
import com.example.tro.Category.Category;
import com.example.tro.Category.RepoCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoSanPham implements IRepoSanPham{
    private static final String SELECT = "select * from san_pham;";
    private static final String DELETE = "delete from san_pham where san_pham.id=?;";
    private static final String SEARCH = "call tim_kiem(?);";
    private static final String UPDATE = "update san_pham \n" +
            "set \n" +
            "ten=?,gia=?,so_luong=?,mau=?,mo_ta=?,id_danh_muc=?\n" +
            "where san_pham.id=?;";
    private static final String INSERT = "insert into san_pham(ten,gia,so_luong,mau,mo_ta,id_danh_muc)\n" +
            "values(?,?,?,?,?,?);";

    RepoCategory repoCategory=new RepoCategory();
    @Override
    public void add(SanPham sanPham) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,sanPham.getTen());
            preparedStatement.setInt(2,sanPham.getGia());
            preparedStatement.setInt(3,sanPham.getSoLuong());
            preparedStatement.setString(4,sanPham.getMauSac());
            preparedStatement.setString(5,sanPham.getMoTa());
            preparedStatement.setInt(6,sanPham.getMaDanhMuc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SanPham> findAll() {
        List<SanPham> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("id");
                String ten=rs.getString("ten");
                int gia=rs.getInt("gia");
                int soLuong=rs.getInt("so_luong");
                String mau=rs.getString("mau");
                String moTa=rs.getString("mo_ta");
                int maDanhMuc=rs.getInt("id_danh_muc");
                Category category=repoCategory.findById(maDanhMuc);
                SanPham sanPham=new SanPham(id,ten,gia,soLuong,mau,moTa,category);
                list.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SanPham> delete(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAll();
    }

    @Override
    public SanPham findByID(int id) {
        return null;
    }

    @Override
    public List<SanPham> update(SanPham sanPham) {
        Connection connection = BaseRepository.getConnection();
//        "update san_pham \n" +
//                "set \n" +
//                "ten=?,gia=?,so_luong=?,mau=?,mo_ta=?,id_danh_muc=?\n" +
//                "where san_pham.id=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,sanPham.getTen());
            preparedStatement.setInt(2,sanPham.getGia());
            preparedStatement.setInt(3,sanPham.getSoLuong());
            preparedStatement.setString(4,sanPham.getMauSac());
            preparedStatement.setString(5,sanPham.getMoTa());
            preparedStatement.setInt(6,sanPham.getMaDanhMuc());
            preparedStatement.setInt(7,sanPham.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAll();
    }

    @Override
    public List<SanPham> search(String key) {
        List<SanPham> list=new ArrayList<>();
        Connection connection=BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1,"%"+key+"%");
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int id=rs.getInt("id");
                String ten=rs.getString("ten");
                int gia=rs.getInt("gia");
                int soLuong=rs.getInt("so_luong");
                String mau=rs.getString("mau");
                String moTa=rs.getString("mo_ta");
                int maDanhMuc=rs.getInt("id_danh_muc");
                Category category=repoCategory.findById(maDanhMuc);
                SanPham sanPham=new SanPham(id,ten,gia,soLuong,mau,moTa,category);
                list.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
