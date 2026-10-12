package repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Task;

// In-memory database. No console input/output belongs here.
public class TaskRepository {
    private final Map<Integer, Task> tasks = new LinkedHashMap<>();
    private int lastTaskId;

    public int getNextId() {
        return lastTaskId + 1;
    }

    public boolean addTask(Task task) {
        if (task.getId() != getNextId() || tasks.containsKey(task.getId())) {
            return false;
        }
        tasks.put(task.getId(), task);
        lastTaskId = task.getId();
        return true;
    }

    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }
}
