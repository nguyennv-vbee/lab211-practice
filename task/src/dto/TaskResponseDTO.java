package dto;

public class TaskResponseDTO {
    private final int id;
    private final String requirementName;
    private final String taskType;
    private final String date;
    private final double time;
    private final String assignee;
    private final String reviewer;

    public TaskResponseDTO(int id, String requirementName, String taskType,
            String date, double time, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskType = taskType;
        this.date = date;
        this.time = time;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getDate() {
        return date;
    }

    public double getTime() {
        return time;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }
}
