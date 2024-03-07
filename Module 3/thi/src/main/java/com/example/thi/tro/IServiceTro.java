package com.example.thi.tro;

import java.util.List;

public interface IServiceTro {
    void add(Tro tro);
    List<Tro> getAll();
    List<Tro> delete(int id);
    Tro findByID(int id);

    List<Tro> search(String key);
}
