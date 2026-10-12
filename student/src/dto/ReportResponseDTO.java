package dto;

public class ReportResponseDTO {
    private final String studentName;
    private final String courseName;
    private final int total;

    public ReportResponseDTO(String studentName, String courseName, int total) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.total = total;
    }

    public String getStudentName() { return studentName; }
    public String getCourseName() { return courseName; }
    public int getTotal() { return total; }
}
