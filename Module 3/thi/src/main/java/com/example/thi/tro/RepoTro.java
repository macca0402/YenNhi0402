package com.example.thi.tro;

import com.example.thi.BaseRepository.BaseRepository;
import com.example.thi.thanh_toan.IRepoThanhToan;
import com.example.thi.thanh_toan.RepoThanhToan;
import com.example.thi.thanh_toan.ThanhToan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepoTro implements IRepoTro{
    private static final String SELECT = "select * from tro;";
    private static final String INSERT = "insert into tro(ten_nguoi_thue_tro,so_dien_thoai,ngay_bat_dau_thue,ma_hinh_thuc_thanh_toan,ghi_chu)\n" +
            " values(?,?,?,?,?);";

    private static final String DELETE = " delete from tro where ma_tro=?; ";
    private static final String SEARCH = "  call tim_kiem(?);";
    private IRepoThanhToan iRepoThanhToan=new RepoThanhToan();
    @Override
    public void add(Tro tro) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, tro.getTenNguoiThueTro());
            preparedStatement.setString(2, tro.getSoDienThoai());
            preparedStatement.setString(3, tro.getNgayBatDau());
            preparedStatement.setInt(4,tro.getMaThanhToan());
            preparedStatement.setString(5, tro.getGhiChu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tro> findAll() {
        List<Tro> troDanhSach = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maTro = rs.getInt("ma_tro");
                String tenNguoiThueTro = rs.getString("ten_nguoi_thue_tro");
                String soDienThoai = rs.getString("so_dien_thoai");
                String ngayBatDau = rs.getString("ngay_bat_dau_thue");
                int maThanhToan=rs.getInt("ma_hinh_thuc_thanh_toan");
                String ghiChu=rs.getString("ghi_chu");
                ThanhToan thanhToan= iRepoThanhToan.timKiemThanhToan(maThanhToan);
                Tro tro=new Tro(maTro,tenNguoiThueTro,soDienThoai,ngayBatDau,thanhToan,ghiChu);
                troDanhSach.add(tro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return troDanhSach;
    }
    @Override
    public List<Tro> delete(int id) {
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
    public Tro findByID(int id) {
        return null;
    }

    @Override
    public List<Tro> search(String key) {
        List<Tro> list=new ArrayList<>();
        Connection connection=BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1,"%"+key+"%");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int maTro = rs.getInt("ma_tro");
                String tenNguoiThueTro = rs.getString("ten_nguoi_thue_tro");
                String soDienThoai = rs.getString("so_dien_thoai");
                String ngayBatDau = rs.getString("ngay_bat_dau_thue");
                int maThanhToan=rs.getInt("ma_hinh_thuc_thanh_toan");
                String ghiChu=rs.getString("ghi_chu");
                ThanhToan thanhToan= iRepoThanhToan.timKiemThanhToan(maThanhToan);
                Tro tro=new Tro(maTro,tenNguoiThueTro,soDienThoai,ngayBatDau,thanhToan,ghiChu);
                list.add(tro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
       
    }
}
