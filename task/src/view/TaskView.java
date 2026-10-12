package view;

import constants.Message;
import dto.TaskResponseDTO;
import java.util.List;
import java.util.Locale;

public class TaskView {
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showTasks(List<TaskResponseDTO> tasks) {
        if (tasks.isEmpty()) {
            showMessage(Message.NO_TASKS);
            return;
        }
        System.out.println(Message.TASK_TITLE);
        System.out.printf(Message.TASK_HEADER, "ID", "Name", "Task Type", "Date",
                "Time", "Assignee", "Reviewer");
        System.out.println(Message.TASK_SEPARATOR);
        for (TaskResponseDTO task : tasks) {
            System.out.printf(Locale.ENGLISH, Message.TASK_ROW, task.getId(), task.getRequirementName(),
                    task.getTaskType(), task.getDate(), task.getTime(), task.getAssignee(), task.getReviewer());
        }
    }
}
