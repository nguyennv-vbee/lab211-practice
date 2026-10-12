package dto;

public class SalaryHistoryResponseDTO {
    private final String code;
    private final String name;
    private final int age;
    private final double salary;
    private final String status;
    private final String date;

    public SalaryHistoryResponseDTO(String code, String name, int age,
            double salary, String status, String date) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}
