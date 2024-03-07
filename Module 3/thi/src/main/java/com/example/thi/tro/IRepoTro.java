package com.example.thi.tro;

import java.util.List;

public interface IRepoTro {
    void add(Tro tro);
    List<Tro> findAll();
    List<Tro> delete(int id);
    Tro findByID(int id);

    List<Tro> search(String key);
}
