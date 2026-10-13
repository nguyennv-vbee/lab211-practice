/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p0056;

import controller.WorkerController;
import dto.WorkerDTO;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author nguye
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WorkerController controller = new WorkerController();
        while (true) {
            controller.displayMenu();
            int choose = readInt("your choose", 1, 5);
            switch (choose) {
                case 1:
                    System.out.println("---------- Add Worker ----------");
                    String code;
                    while (true) {
                        code = readCode();
                        if (controller.checkID(code)) {
                            System.out.println("Code is exist!");
                        } else {
                            break;
                        }
                    }
                    String name = readString("Name");
                    int age = readInt("Age", 18, 50);
                    double salary = readDouble("Salary");
                    String workLocation = readString("work location");
                    WorkerDTO inputForm = new WorkerDTO(code, name, age, salary, workLocation);
                    controller.setInputData(inputForm);
                    try {
                        controller.addWorker();
                        System.out.println("Add worker successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("------- Up Salary ------");
                    String codeUp;
                    while (true) {
                        codeUp = readCode();
                        if (controller.checkID(codeUp)) {
                            break;
                        } else {
                            System.out.println("Code is not exist!");
                        }
                    }
                    double amountUp = readDouble("amount");
                    controller.upSalary(codeUp, amountUp);
                    System.out.println("Up salary successfully!");
                    break;
                case 3:
                    System.out.println("------- Down Salary ------");
                    String codeDown;
                    while (true) {
                        codeDown = readCode();
                        if (!controller.checkID(codeDown)) {
                            System.out.println("Code is not exist!");
                        } else {
                            break;
                        }
                    }
                    double amountDown = readDouble("amount");
                    controller.downSalary(codeDown, amountDown);
                    System.out.println("Down salary successfully!");
                    break;
                case 4:
                    controller.displaySalaryHistory();
                    break;
                case 5:
                    break;

            }
            if (choose == 5) {
                break;
            }
        }

    }

    private static int readInt(String field, int min, int max) {
        while (true) {
            System.out.println("Enter " + field + ":");
            try {
                return Validation.checkInt(sc.nextLine(), min, max);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double readDouble(String field) {
        while (true) {
            System.out.println("Enter " + field + ":");
            try {
                return Validation.checkDouble(sc.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readString(String field) {
        while (true) {
            System.out.println("Enter " + field + ":");
            try {
                return Validation.checkString(sc.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readCode() {
        while (true) {
            System.out.println("Enter Code:");
            try {
                return Validation.checkCode(sc.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
