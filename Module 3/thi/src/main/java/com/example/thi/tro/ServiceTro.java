package com.example.thi.tro;

import java.util.List;

public class ServiceTro implements IServiceTro{
    IRepoTro repoTro=new RepoTro();
    @Override
    public void add(Tro tro) {
repoTro.add(tro);
    }

    @Override
    public List<Tro> getAll() {
        return repoTro.findAll();
    }

    @Override
    public List<Tro> delete(int id) {
        return repoTro.delete(id);
    }

    @Override
    public Tro findByID(int id) {
        return null;
    }

    @Override
    public List<Tro> search(String key) {
        return repoTro.search(key);
    }
}
