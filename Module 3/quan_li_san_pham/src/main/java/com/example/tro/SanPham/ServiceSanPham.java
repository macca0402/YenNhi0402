package com.example.tro.SanPham;

import java.util.List;

public class ServiceSanPham implements IServiceSanPham{
    RepoSanPham repoSanPham=new RepoSanPham();

    @Override
    public void add(SanPham sanPham) {
        repoSanPham.add(sanPham);
    }

    @Override
    public List<SanPham> findAll() {
        return repoSanPham.findAll();
    }

    @Override
    public List<SanPham> delete(int id) {
        return repoSanPham.delete(id);
    }

    @Override
    public SanPham findByID(int id) {
        return null;
    }

    @Override
    public List<SanPham> update(SanPham sanPham) {
        return repoSanPham.update(sanPham);
    }

    @Override
    public List<SanPham> search(String key) {
        return repoSanPham.search(key);
    }
}
