package model;

import constants.SalaryStatus;
import java.time.LocalDateTime;

// Snapshot: previous records do not change when a worker's salary changes again.
public class SalaryHistory {
    private final String code;
    private final String name;
    private final int age;
    private final double salary;
    private final SalaryStatus status;
    private final LocalDateTime date;

    public SalaryHistory(Worker worker, SalaryStatus status, LocalDateTime date) {
        this.code = worker.getCode();
        this.name = worker.getName();
        this.age = worker.getAge();
        this.salary = worker.getSalary();
        this.status = status;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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
