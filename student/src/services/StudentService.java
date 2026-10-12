package services;

import constants.Constants.Action;
import constants.Message;
import dto.ReportResponseDTO;
import dto.StudentActionRequestDTO;
import dto.StudentRequestDTO;
import dto.StudentResponseDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Student;
import repository.StudentRepository;
import utils.Validation;

public class StudentService {
    private final StudentRepository repository;

    public StudentService() {
        repository = new StudentRepository();
    }

    public int create(StudentRequestDTO request) {
        Student student = validatedStudent(request);
        if (repository.hasEnrollment(student.getId(), student.getSemester(),
                                     student.getCourseName(), null)) {
            throw new IllegalArgumentException(Message.DUPLICATE_ENROLLMENT);
        }
        ensureConsistentName(student, null);
        repository.add(student);
        return repository.size();
    }

    public List<StudentResponseDTO> findAndSort(String keyword) {
        keyword = Validation.requireText(keyword).toLowerCase();
        List<Student> matches = new ArrayList<>();
        for (Student student : repository.getAll()) {
            if (student.getStudentName().toLowerCase().contains(keyword)) {
                matches.add(student);
            }
        }
        // Assignment requirement: Collections.sort + Comparator.compare.
        Collections.sort(matches, new Comparator<Student>() {
            @Override
            public int compare(Student first, Student second) {
                int result = first.getStudentName()
                        .compareToIgnoreCase(second.getStudentName());
                if (result != 0) return result;
                result = first.getId().compareToIgnoreCase(second.getId());
                if (result != 0) return result;
                result = first.getSemester().compareToIgnoreCase(second.getSemester());
                if (result != 0) return result;
                return first.getCourseName().compareToIgnoreCase(second.getCourseName());
            }
        });
        List<StudentResponseDTO> response = new ArrayList<>();
        for (Student student : matches) response.add(toResponse(student));
        return response;
    }

    public void updateOrDelete(StudentActionRequestDTO request) {
        if (request == null || request.getAction() == null) {
            throw new IllegalArgumentException(Message.INVALID_ACTION);
        }
        String id = Validation.requireText(request.getId());
        String semester = Validation.requireText(request.getOldSemester());
        String course = Validation.getCourse(request.getOldCourseName());

        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException(Message.STUDENT_NOT_FOUND);
        }
        Student target = repository.findExact(id, semester, course);
        if (target == null) throw new IllegalArgumentException(Message.RECORD_NOT_FOUND);

        if (request.getAction() == Action.DELETE) {
            repository.delete(target);
            return;
        }

        Student updated = validatedStudent(request.getUpdatedStudent());
        if (repository.hasEnrollment(updated.getId(), updated.getSemester(),
                                     updated.getCourseName(), target)) {
            throw new IllegalArgumentException(Message.DUPLICATE_ENROLLMENT);
        }
        // Changing the name of an existing ID also renames its other records.
        // Moving one enrollment to a different ID only affects that enrollment.
        ensureConsistentName(updated, target);
        boolean sameId = target.getId().equalsIgnoreCase(updated.getId());
        if (sameId) repository.renameById(target.getId(), updated.getStudentName());
        repository.update(target, updated);
    }

    public List<ReportResponseDTO> report() {
        List<Student> students = repository.getAll();
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                int result = a.getStudentName().compareToIgnoreCase(b.getStudentName());
                if (result != 0) return result;
                result = a.getId().compareToIgnoreCase(b.getId());
                if (result != 0) return result;
                return a.getCourseName().compareToIgnoreCase(b.getCourseName());
            }
        });
        // Group by actual student identity (ID) + course, not by name alone.
        Map<String, ReportResponseDTO> grouped = new LinkedHashMap<>();
        for (Student student : students) {
            String key = student.getId().toLowerCase() + "\u0000" + student.getCourseName();
            ReportResponseDTO current = grouped.get(key);
            int total = current == null ? 1 : current.getTotal() + 1;
            grouped.put(key, new ReportResponseDTO(student.getStudentName(),
                                                    student.getCourseName(), total));
        }
        return new ArrayList<>(grouped.values());
    }

    private Student validatedStudent(StudentRequestDTO request) {
        if (request == null) throw new IllegalArgumentException(Message.EMPTY_INPUT);
        return new Student(
                Validation.requireText(request.getId()),
                Validation.requireText(request.getStudentName()),
                Validation.requireText(request.getSemester()),
                Validation.getCourse(request.getCourseName()));
    }

    private void ensureConsistentName(Student proposed, Student editing) {
        for (Student existing : repository.findById(proposed.getId())) {
            // Name is allowed to change for this ID if we are editing one of its
            // records; StudentRepository.renameById will keep all records in sync.
            boolean editingSameId = editing != null
                    && editing.getId().equalsIgnoreCase(proposed.getId());
            if (!editingSameId && !existing.getStudentName()
                    .equalsIgnoreCase(proposed.getStudentName())) {
                throw new IllegalArgumentException(Message.INCONSISTENT_NAME);
            }
        }
    }

    private StudentResponseDTO toResponse(Student student) {
        return new StudentResponseDTO(student.getId(), student.getStudentName(),
                                      student.getSemester(), student.getCourseName());
    }
}
