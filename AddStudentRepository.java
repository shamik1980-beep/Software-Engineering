package com.uosrak.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public StudentRepository() {
        students.add(new Student(nextId++, "Rohit", "Data Science & AI"));
        students.add(new Student(nextId++, "Arjun", "Computing Science"));
        students.add(new Student(nextId++, "David", "Software Engineering"));
    }

    public List<Student> findAll() { return new ArrayList<>(students); }

    public boolean deleteById(int id) {
        Student target = null;
        for (Student s : students) {
            if (s.getId() == id) {
                target = s;
                break;
            }
        }
        if (target == null) return false;
        students.remove(target);
        return true;
    }
}
