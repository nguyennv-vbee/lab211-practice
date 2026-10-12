package dto;

public class StudentResponseDTO {
    private final String id;
    private final String studentName;
    private final String semester;
    private final String courseName;

    public StudentResponseDTO(String id, String studentName,
                              String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getSemester() { return semester; }
    public String getCourseName() { return courseName; }
}
