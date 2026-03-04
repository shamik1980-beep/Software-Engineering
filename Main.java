package com.uosrak.mvc;

import com.uosrak.mvc.controller.StudentController;
import com.uosrak.mvc.model.StudentRepository;
import com.uosrak.mvc.view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository(); // Model
        StudentView view = new StudentView();             // View
        StudentController controller = new StudentController(repo, view); // Controller

        controller.start();
    }
}
