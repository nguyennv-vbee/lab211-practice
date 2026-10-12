package main;

import constants.Constants;
import constants.Message;
import controller.StudentController;
import dto.StudentActionRequestDTO;
import dto.StudentRequestDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {
    private final Scanner scanner;
    private final StudentController controller;

    public Main() {
        scanner = new Scanner(System.in);
        controller = new StudentController();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        while (true) {
            System.out.println(Message.MENU);
            int choice = inputMenuChoice();
            switch (choice) {
                case 1: createStudents(); break;
                case 2: findAndSort(); break;
                case 3: updateOrDelete(); break;
                case 4: controller.report(); break;
                case 5:
                    System.out.println(Message.EXIT);
                    return;
                default: break;
            }
        }
    }

    private void createStudents() {
        while (true) {
            StudentRequestDTO request = inputStudent(false);
            try {
                // One Controller call per created record (Guide.xlsx).
                int count = controller.createStudent(request);
                if (count >= Constants.MIN_STUDENTS && !inputYesNo()) return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void findAndSort() {
        String keyword = inputText(Message.INPUT_SEARCH);
        // One Controller call for this workflow.
        controller.findAndSort(keyword);
    }

    private void updateOrDelete() {
        String id = inputText(Message.INPUT_ID);
        Constants.Action action = inputAction();
        // ID can appear several times (different semesters/courses).
        // Semester + course specify the record to update or delete.
        String oldSemester = inputText(Message.INPUT_OLD_SEMESTER);
        String oldCourse = inputCourse(Message.INPUT_OLD_COURSE);
        StudentRequestDTO updated = null;
        if (action == Constants.Action.UPDATE) {
            updated = inputStudent(true);
        }
        StudentActionRequestDTO request = new StudentActionRequestDTO(
                id, oldSemester, oldCourse, action, updated);
        try {
            // One Controller call for this workflow.
            controller.updateOrDelete(request);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private StudentRequestDTO inputStudent(boolean editing) {
        String id = inputText(editing ? Message.INPUT_NEW_ID : Message.INPUT_ID);
        String name = inputText(editing ? Message.INPUT_NEW_NAME : Message.INPUT_NAME);
        String semester = inputText(editing ? Message.INPUT_NEW_SEMESTER : Message.INPUT_SEMESTER);
        String course = inputCourse(editing ? Message.INPUT_NEW_COURSE : Message.INPUT_COURSE);
        return new StudentRequestDTO(id, name, semester, course);
    }

    private String inputText(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Validation.requireText(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputCourse(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Validation.getCourse(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputMenuChoice() {
        while (true) {
            System.out.print(Message.INPUT_CHOICE);
            try {
                return Validation.getMenuChoice(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean inputYesNo() {
        while (true) {
            System.out.print(Message.ASK_CONTINUE);
            try {
                return Validation.getYesNo(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Constants.Action inputAction() {
        while (true) {
            System.out.print(Message.INPUT_ACTION);
            try {
                return Validation.getAction(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
