package view;

import constants.Message;
import dto.ReportResponseDTO;
import dto.StudentResponseDTO;
import java.util.List;

public class StudentView {
    private List<StudentResponseDTO> studentResults;
    private List<ReportResponseDTO> reportResults;

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void setStudentResults(List<StudentResponseDTO> results) {
        studentResults = results;
    }

    public void displayStudents() {
        if (studentResults == null || studentResults.isEmpty()) {
            showMessage(Message.NO_RESULT);
            return;
        }
        System.out.printf(Message.STUDENT_HEADER, "ID", "Student name", "Semester", "Course");
        for (StudentResponseDTO student : studentResults) {
            System.out.printf(Message.STUDENT_HEADER, student.getId(),
                    student.getStudentName(), student.getSemester(), student.getCourseName());
        }
    }

    public void setReportResults(List<ReportResponseDTO> results) {
        reportResults = results;
    }

    public void displayReport() {
        if (reportResults == null || reportResults.isEmpty()) {
            showMessage(Message.EMPTY_DATABASE);
            return;
        }
        System.out.printf(Message.REPORT_HEADER, "Student name", "Course", "Total");
        for (ReportResponseDTO item : reportResults) {
            System.out.printf(Message.REPORT_HEADER, item.getStudentName(),
                    item.getCourseName(), item.getTotal());
        }
    }
}
