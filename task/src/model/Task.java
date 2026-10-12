package model;

import java.util.Date;

public class Task {
    private final int id;
    private final int taskTypeID;
    private final String requirementName;
    private final Date date;
    private final double planFrom;
    private final double planTo;
    private final String assignee;
    private final String reviewer;

    public Task(int id, int taskTypeID, String requirementName, Date date,
            double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = new Date(date.getTime());
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }
}
