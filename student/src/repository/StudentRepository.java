package repository;

import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentRepository {
    private final ArrayList<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
    }

    public int size() { return students.size(); }

    public void add(Student student) { students.add(student); }

    public boolean delete(Student student) { return students.remove(student); }

    public List<Student> getAll() { return new ArrayList<>(students); }

    public List<Student> findById(String id) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) result.add(student);
        }
        return result;
    }

    public Student findExact(String id, String semester, String course) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)
                    && student.getSemester().equalsIgnoreCase(semester)
                    && student.getCourseName().equalsIgnoreCase(course)) {
                return student;
            }
        }
        return null;
    }

    public boolean hasEnrollment(String id, String semester, String course,
                                 Student except) {
        Student found = findExact(id, semester, course);
        return found != null && found != except;
    }

    public void update(Student target, Student source) {
        target.setId(source.getId());
        target.setStudentName(source.getStudentName());
        target.setSemester(source.getSemester());
        target.setCourseName(source.getCourseName());
    }

    public void renameById(String id, String newName) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                student.setStudentName(newName);
            }
        }
    }
}
