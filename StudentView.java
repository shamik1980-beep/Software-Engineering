package com.uosrak.mvc.view;

import com.uosrak.mvc.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n=== Student Manager (Core Java MVC) ===");
        System.out.println("1. View all students");
        System.out.println("2. Add a student");
        System.out.println("3. Update a student");
        System.out.println("4. Delete a student");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public void showStudents(List<Student> students) {
        System.out.println("\n--- Student List ---");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s.getId() + ". " + s.getName() + " | " + s.getCourse());
        }
    }

    public String askName() {
        System.out.print("Enter student name: ");
        return scanner.nextLine().trim();
    }

    public String askCourse() {
        System.out.print("Enter course name: ");
        return scanner.nextLine().trim();
    }

    public int askStudentId() {
        System.out.print("Enter student ID: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next(); // discard invalid
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return id;
    }

    public int askMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter 1-5: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return choice;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
