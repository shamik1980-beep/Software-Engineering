package com.uosrak.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public List<Student> findAll() {
        return new ArrayList<>(students); // return copy (safe)
    }

    public Student add(String name, String course) {
        Student s = new Student(nextId++, name, course);
        students.add(s);
        return s;
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public boolean update(int id, String name, String course) {
        Student s = findById(id);
        if (s == null) return false;
        s.setName(name);
        s.setCourse(course);
        return true;
    }

    public boolean delete(int id) {
        Student s = findById(id);
        if (s == null) return false;
        students.remove(s);
        return true;
    }
}
