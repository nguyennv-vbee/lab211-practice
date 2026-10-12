package services;

import constants.Constants;
import constants.Message;
import constants.TaskType;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import model.Task;
import repository.TaskRepository;
import utils.Validation;

public class Management {
    private final TaskRepository repository;

    public Management() {
        repository = new TaskRepository();
    }

    // Adapter for Controller: converts a DTO into a Model inside Service.
    public int addTask(TaskRequestDTO request) throws Exception {
        if (request == null) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        return addTask(request.getRequirementName(), request.getAssignee(),
                request.getReviewer(), request.getTaskTypeID(), request.getDate(),
                request.getPlanFrom(), request.getPlanTo());
    }

    // Required by J1.S.P0071.
    public int addTask(String requirementName, String assignee, String reviewer,
            String taskTypeID, String date, String planFrom, String planTo) throws Exception {
        requirementName = Validation.getString(requirementName);
        assignee = Validation.getString(assignee);
        reviewer = Validation.getString(reviewer);
        int typeId = Validation.getInteger(taskTypeID,
                Constants.MIN_TASK_TYPE, Constants.MAX_TASK_TYPE);
        Date taskDate = Validation.getDate(date);
        double from = Validation.getPlanTime(planFrom);
        double to = Validation.getPlanTime(planTo);
        if (from >= to) {
            throw new IllegalArgumentException(Message.INVALID_PLAN_ORDER);
        }

        int id = repository.getNextId();
        repository.addTask(new Task(id, typeId, requirementName, taskDate,
                from, to, assignee, reviewer));
        return id;
    }

    // Required by J1.S.P0071.
    public void deleteTask(String id) throws Exception {
        int taskId = Validation.getInteger(id, 1, Integer.MAX_VALUE);
        if (!repository.deleteTask(taskId)) {
            throw new IllegalArgumentException(Message.TASK_NOT_FOUND);
        }
    }

    // Required by J1.S.P0071.
    public List<Task> getDataTasks() {
        List<Task> result = repository.getTasks();
        result.sort(Comparator.comparingInt(Task::getId));
        return result;
    }

    // Only response DTOs leave the service for presentation.
    public List<TaskResponseDTO> getTaskResponse() {
        List<TaskResponseDTO> result = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_PATTERN, Locale.ENGLISH);
        for (Task task : getDataTasks()) {
            result.add(new TaskResponseDTO(task.getId(), task.getRequirementName(),
                    TaskType.fromId(task.getTaskTypeID()).getName(), formatter.format(task.getDate()),
                    task.getPlanTo() - task.getPlanFrom(), task.getAssignee(), task.getReviewer()));
        }
        return result;
    }
}
