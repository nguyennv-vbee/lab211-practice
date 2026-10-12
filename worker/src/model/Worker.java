package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Worker {
    private final String code;
    private final String name;
    private final int age;
    private double salary;
    private final String workLocation;
    private final List<SalaryHistory> salaryHistories = new ArrayList<>();

    public Worker(String code, String name, int age, double salary, String workLocation) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
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

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void addSalaryHistory(SalaryHistory history) {
        if (history == null || history.getWorker() != this) {
            throw new IllegalArgumentException("Salary history must belong to this worker.");
        }
        salaryHistories.add(history);
    }

    public List<SalaryHistory> getSalaryHistories() {
        return Collections.unmodifiableList(salaryHistories);
    }
}
