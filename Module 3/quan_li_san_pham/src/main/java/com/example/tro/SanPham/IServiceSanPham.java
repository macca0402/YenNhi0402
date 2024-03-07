package com.example.tro.SanPham;

import java.util.List;

public interface IServiceSanPham {
    void add(SanPham sanPham);
    List<SanPham> findAll();
    List<SanPham> delete(int id);
    SanPham findByID(int id);
    List<SanPham> update(SanPham sanPham);
    List<SanPham> search(String key);
}

