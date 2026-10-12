package repository;

import constants.Message;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.SalaryHistory;
import model.Worker;

// In-memory database. No console input/output belongs here.
public class WorkerRepository {
    private final Map<String, Worker> workers = new LinkedHashMap<>();

    public boolean isDuplicate(String code) {
        return workers.containsKey(code);
    }

    public boolean addWorker(Worker worker) {
        if (isDuplicate(worker.getCode())) {
            return false;
        }
        workers.put(worker.getCode(), worker);
        return true;
    }

    public Worker findByCode(String code) {
        return workers.get(code);
    }

    public void addSalaryHistory(SalaryHistory history) {
        if (history == null) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        Worker worker = history.getWorker();
        if (findByCode(worker.getCode()) != worker) {
            throw new IllegalArgumentException(Message.WORKER_NOT_FOUND);
        }
        worker.addSalaryHistory(history);
    }

    public List<SalaryHistory> getSalaryHistories() {
        List<SalaryHistory> result = new ArrayList<>();
        for (Worker worker : workers.values()) {
            result.addAll(worker.getSalaryHistories());
        }
        return result;
    }
}
