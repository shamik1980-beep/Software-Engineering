package com.uosrak.mvc.controller;

import com.uosrak.mvc.model.StudentRepository;
import com.uosrak.mvc.view.StudentView;

public class StudentController {
    private final StudentRepository repo;
    private final StudentView view;

    public StudentController(StudentRepository repo, StudentView view) {
        this.repo = repo;
        this.view = view;
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showMenu();
            int choice = view.askMenuChoice();

            switch (choice) {
                case 1 -> view.showStudents(repo.findAll());

                case 2 -> {
                    String name = view.askName();
                    String course = view.askCourse();
                    repo.add(name, course);
                    view.showMessage("Student added successfully.");
                }

                case 3 -> {
                    int id = view.askStudentId();
                    String name = view.askName();
                    String course = view.askCourse();
                    boolean ok = repo.update(id, name, course);
                    view.showMessage(ok ? "Student updated." : "Student ID not found.");
                }

                case 4 -> {
                    int id = view.askStudentId();
                    boolean ok = repo.delete(id);
                    view.showMessage(ok ? "Student deleted." : "Student ID not found.");
                }

                case 5 -> {
                    view.showMessage("Exiting... Bye!");
                    running = false;
                }

                default -> view.showMessage("Invalid choice. Choose 1-5.");
            }
        }
    }
}
