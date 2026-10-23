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
        Main application = new Main();
        while (true) {
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);
            if (!application.scanner.hasNextLine()) {
                return;
            }
            try {
                int choice = Validation.getMenuChoice(application.scanner.nextLine());
                switch (choice) {
                    case 1: application.createStudents(); break;
                    case 2: application.findAndSort(); break;
                    case 3: application.updateOrDelete(); break;
                    case 4: application.controller.report(); break;
                    case 5:
                        System.out.println(Message.EXIT);
                        return;
                    default: break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (!application.scanner.hasNextLine()) {
                    return;
                }
            }
        }
    }

    private void createStudents() throws Exception {
        while (true) {
            StudentRequestDTO request = inputStudent(false);
            // One Controller call per created record (Guide.xlsx).
            int count = controller.createStudent(request);
            if (count >= Constants.MIN_STUDENTS && !inputYesNo()) return;
        }
    }

    private void findAndSort() throws Exception {
        String keyword = inputText(Message.INPUT_SEARCH);
        // One Controller call for this workflow.
        controller.findAndSort(keyword);
    }

    private void updateOrDelete() throws Exception {
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
        // One Controller call for this workflow.
        controller.updateOrDelete(request);
    }

    private StudentRequestDTO inputStudent(boolean editing) throws Exception {
        String id = inputText(editing ? Message.INPUT_NEW_ID : Message.INPUT_ID);
        String name = inputText(editing ? Message.INPUT_NEW_NAME : Message.INPUT_NAME);
        String semester = inputText(editing ? Message.INPUT_NEW_SEMESTER : Message.INPUT_SEMESTER);
        String course = inputCourse(editing ? Message.INPUT_NEW_COURSE : Message.INPUT_COURSE);
        return new StudentRequestDTO(id, name, semester, course);
    }

    private String inputText(String prompt) throws Exception {
        System.out.print(prompt);
        return Validation.requireText(scanner.nextLine());
    }

    private String inputCourse(String prompt) throws Exception {
        System.out.print(prompt);
        return Validation.getCourse(scanner.nextLine());
    }

    private boolean inputYesNo() throws Exception {
        System.out.print(Message.ASK_CONTINUE);
        return Validation.getYesNo(scanner.nextLine());
    }

    private Constants.Action inputAction() throws Exception {
        System.out.print(Message.INPUT_ACTION);
        return Validation.getAction(scanner.nextLine());
    }
}
