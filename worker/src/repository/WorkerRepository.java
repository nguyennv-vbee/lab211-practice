package repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.SalaryHistory;
import model.Worker;

// In-memory database. No console input/output belongs here.
public class WorkerRepository {
    private final Map<String, Worker> workers = new LinkedHashMap<>();
    private final List<SalaryHistory> salaryHistories = new ArrayList<>();

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
        salaryHistories.add(history);
    }

    public List<SalaryHistory> getSalaryHistories() {
        return new ArrayList<>(salaryHistories);
    }
}
