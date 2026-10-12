package model;

import constants.SalaryStatus;
import java.time.LocalDateTime;
import java.util.Objects;

// Each salary change belongs to one worker and retains its salary at that time.
public class SalaryHistory {
    private final Worker worker;
    private final double salary;
    private final SalaryStatus status;
    private final LocalDateTime date;

    public SalaryHistory(Worker worker, SalaryStatus status, LocalDateTime date) {
        this.worker = Objects.requireNonNull(worker, "Worker must not be null.");
        this.salary = worker.getSalary();
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public String getCode() {
        return worker.getCode();
    }

    public String getName() {
        return worker.getName();
    }

    public int getAge() {
        return worker.getAge();
    }

    public double getSalary() {
        return salary;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
