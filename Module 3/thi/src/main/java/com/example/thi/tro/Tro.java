package com.example.thi.tro;

import com.example.thi.thanh_toan.ThanhToan;

public class Tro {
    private int maTro;
    private String tenNguoiThueTro;
    private String soDienThoai;
    private String ngayBatDau;
    private ThanhToan thanhToan;
   private int maThanhToan;
    private String ghiChu;

    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public Tro(String tenNguoiThueTro, String soDienThoai, String ngayBatDau, ThanhToan thanhToan, String ghiChu) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDau = ngayBatDau;
        this.thanhToan = thanhToan;
        this.ghiChu = ghiChu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Tro(int maTro, String tenNguoiThueTro, String soDienThoai, String ngayBatDau, ThanhToan thanhToan, String ghiChu) {
        this.maTro = maTro;
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDau = ngayBatDau;
        this.thanhToan = thanhToan;
        this.ghiChu = ghiChu;
    }

    public Tro(String tenNguoiThueTro, String soDienThoai, String ngayBatDau, ThanhToan thanhToan) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDau = ngayBatDau;
        this.thanhToan = thanhToan;
    }

    public Tro(String tenNguoiThueTro, String soDienThoai, String ngayBatDau, int maThanhToan, String ghiChu) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDau = ngayBatDau;
        this.maThanhToan = maThanhToan;
        this.ghiChu = ghiChu;
    }

    public int getMaTro() {
        return maTro;
    }

    public void setMaTro(int maTro) {
        this.maTro = maTro;
    }

    public String getTenNguoiThueTro() {
        return tenNguoiThueTro;
    }

    public void setTenNguoiThueTro(String tenNguoiThueTro) {
        this.tenNguoiThueTro = tenNguoiThueTro;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public ThanhToan getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(ThanhToan thanhToan) {
        this.thanhToan = thanhToan;
    }
}
