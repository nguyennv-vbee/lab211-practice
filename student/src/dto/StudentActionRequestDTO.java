package dto;

import constants.Constants.Action;

public class StudentActionRequestDTO {
    private final String id;
    private final String oldSemester;
    private final String oldCourseName;
    private final Action action;
    private final StudentRequestDTO updatedStudent;

    public StudentActionRequestDTO(String id, String oldSemester,
                                   String oldCourseName, Action action,
                                   StudentRequestDTO updatedStudent) {
        this.id = id;
        this.oldSemester = oldSemester;
        this.oldCourseName = oldCourseName;
        this.action = action;
        this.updatedStudent = updatedStudent;
    }

    public String getId() { return id; }
    public String getOldSemester() { return oldSemester; }
    public String getOldCourseName() { return oldCourseName; }
    public Action getAction() { return action; }
    public StudentRequestDTO getUpdatedStudent() { return updatedStudent; }
}
