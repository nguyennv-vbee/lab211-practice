package controller;

import constants.Message;
import dto.TaskRequestDTO;
import services.Management;
import view.TaskView;

// Controller only coordinates DTO -> Service -> View.
public class TaskController {
    private final Management management;
    private final TaskView taskView;

    public TaskController() {
        management = new Management();
        taskView = new TaskView();
    }

    public void addTask(TaskRequestDTO request) throws Exception {
        int id = management.addTask(request);
        taskView.showMessage(String.format(Message.ADD_SUCCESS, id));
    }

    public void deleteTask(String id) throws Exception {
        management.deleteTask(id);
        taskView.showMessage(Message.DELETE_SUCCESS);
    }

    public void showTasks() {
        taskView.showTasks(management.getTaskResponse());
    }
}
