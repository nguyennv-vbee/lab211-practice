package controller;

import constants.Constants.Action;
import constants.Message;
import dto.StudentActionRequestDTO;
import dto.StudentRequestDTO;
import services.StudentService;
import view.StudentView;

public class StudentController {
    private final StudentService service;
    private final StudentView view;

    public StudentController() {
        service = new StudentService();
        view = new StudentView();
    }

    public int createStudent(StudentRequestDTO request) {
        int count = service.create(request);
        view.showMessage(Message.CREATE_SUCCESS);
        return count;
    }

    public void findAndSort(String keyword) {
        view.setStudentResults(service.findAndSort(keyword));
        view.displayStudents();
    }

    public void updateOrDelete(StudentActionRequestDTO request) {
        service.updateOrDelete(request);
        view.showMessage(request.getAction() == Action.UPDATE
                ? Message.UPDATE_SUCCESS : Message.DELETE_SUCCESS);
    }

    public void report() {
        view.setReportResults(service.report());
        view.displayReport();
    }
}
