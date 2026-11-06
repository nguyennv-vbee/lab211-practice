package repository;

import java.util.ArrayList;
import java.util.List;
import model.TaskType;

// Fixed task type data. No console input/output belongs here.
public class TaskTypeRepository {
    private final List<TaskType> taskTypes = new ArrayList<>();

    public TaskTypeRepository() {
        taskTypes.add(new TaskType(1, "Code"));
        taskTypes.add(new TaskType(2, "Test"));
        taskTypes.add(new TaskType(3, "Design"));
        taskTypes.add(new TaskType(4, "Review"));
    }

    public TaskType findById(int id) {
        for (TaskType taskType : taskTypes) {
            if (taskType.getId() == id) {
                return taskType;
            }
        }
        return null;
    }
}
