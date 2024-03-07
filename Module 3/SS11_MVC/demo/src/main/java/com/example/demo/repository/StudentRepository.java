package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> list;
    static {
        list = new ArrayList<>();
        list.add(new Student(1,"Nhi",false,6));
        list.add(new Student(2,"Hà",false,5));
        list.add(new Student(3,"Nhật Long",true,1));
        list.add(new Student(4,"Quang Ánh",true,8));
    }

    @Override
    public List<Student> findAll() {
        return list;
    }

    @Override
    public void save(Student student) {
        list.add(student);
    }
}
