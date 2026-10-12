package services;

import constants.Constants;
import constants.Message;
import constants.SalaryStatus;
import dto.SalaryHistoryResponseDTO;
import dto.WorkerRequestDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.SalaryHistory;
import model.Worker;
import repository.WorkerRepository;
import utils.Validation;

public class Management {
    private final WorkerRepository repository;

    public Management() {
        repository = new WorkerRepository();
    }

    // Adapter for Controller: converts a DTO into a Model inside Service.
    public boolean addWorker(WorkerRequestDTO request) throws Exception {
        if (request == null) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        return addWorker(new Worker(request.getCode(), request.getName(),
                request.getAge(), request.getSalary(), request.getWorkLocation()));
    }

    // Required by J1.S.P0056.
    public boolean addWorker(Worker worker) throws Exception {
        if (worker == null) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        String code = Validation.getString(worker.getCode());
        Validation.getString(worker.getName());
        Validation.getString(worker.getWorkLocation());
        if (worker.getAge() < Constants.MIN_AGE || worker.getAge() > Constants.MAX_AGE) {
            throw new IllegalArgumentException(String.format(Message.INVALID_RANGE,
                    Constants.MIN_AGE, Constants.MAX_AGE));
        }
        Validation.validatePositive(worker.getSalary());
        if (repository.isDuplicate(code)) {
            throw new IllegalArgumentException(Message.DUPLICATE_CODE);
        }
        // Normalization ensures that codes with surrounding whitespace are equal.
        Worker normalized = new Worker(code, worker.getName().trim(),
                worker.getAge(), worker.getSalary(), worker.getWorkLocation().trim());
        return repository.addWorker(normalized);
    }

    // Required by J1.S.P0056.
    public boolean changeSalary(SalaryStatus status, String code, double amount) {
        if (status == null) {
            throw new IllegalArgumentException(Message.INVALID_STATUS);
        }
        code = Validation.getString(code);
        Validation.validatePositive(amount);
        Worker worker = repository.findByCode(code);
        if (worker == null) {
            throw new IllegalArgumentException(Message.WORKER_NOT_FOUND);
        }

        double updatedSalary = status == SalaryStatus.UP
                ? worker.getSalary() + amount : worker.getSalary() - amount;
        if (!Double.isFinite(updatedSalary) || updatedSalary <= 0) {
            throw new IllegalArgumentException(Message.INVALID_SALARY);
        }

        worker.setSalary(updatedSalary);
        repository.addSalaryHistory(new SalaryHistory(worker, status, LocalDateTime.now()));
        return true;
    }

    // Required by J1.S.P0056 (spelling matches assignment).
    public List<SalaryHistory> getInfomationSalary() {
        List<SalaryHistory> result = repository.getSalaryHistories();
        result.sort(Comparator.comparing(SalaryHistory::getCode));
        // Java's stable sort keeps same-code changes in their original order.
        return result;
    }

    // Only response DTOs leave the service for presentation.
    public List<SalaryHistoryResponseDTO> getSalaryHistoryResponse() {
        List<SalaryHistoryResponseDTO> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_PATTERN);
        for (SalaryHistory record : getInfomationSalary()) {
            result.add(new SalaryHistoryResponseDTO(record.getCode(), record.getName(),
                    record.getAge(), record.getSalary(), record.getStatus().name(),
                    record.getDate().format(formatter)));
        }
        return result;
    }
}
