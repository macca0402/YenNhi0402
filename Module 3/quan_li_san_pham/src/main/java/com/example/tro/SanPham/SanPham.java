package com.example.tro.SanPham;

import com.example.tro.Category.Category;

public class SanPham {
    private int id;
    private String ten;
    private int gia;
    private int soLuong;
    private double soLuong2;
    private String mauSac;
    private String moTa;
    private Category category;
    private int maDanhMuc;

    public SanPham(String ten, int gia, double soLuong2, String mauSac, String moTa, int maDanhMuc) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong2 = soLuong2;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.maDanhMuc = maDanhMuc;
    }

    public double getSoLuong2() {
        return soLuong2;
    }

    public void setSoLuong2(double soLuong2) {
        this.soLuong2 = soLuong2;
    }

    public SanPham(int id, String ten, int gia, int soLuong, String mauSac, String moTa, Category category) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public SanPham(String ten, int gia, int soLuong, String mauSac, String moTa, int maDanhMuc) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.maDanhMuc = maDanhMuc;
    }

    public SanPham(String ten, int gia, int soLuong, String mauSac, String moTa, Category category) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.category = category;
    }
}
