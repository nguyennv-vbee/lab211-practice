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
            System.out.println("Enter your choose:");
            if (!sc.hasNextLine()) {
                return;
            }
            try {
                int choose = Validation.checkInt(sc.nextLine(), 1, 5);
                switch (choose) {
                    case 1:
                        System.out.println("---------- Add Worker ----------");
                        String code = readCode();
                        if (controller.checkID(code)) {
                            throw new Exception("Code is exist!");
                        }
                        String name = readString("Name");
                        int age = readInt("Age", 18, 50);
                        double salary = readDouble("Salary");
                        String workLocation = readString("work location");
                        WorkerDTO inputForm = new WorkerDTO(code, name, age, salary, workLocation);
                        controller.setInputData(inputForm);
                        controller.addWorker();
                        System.out.println("Add worker successfully!");
                        break;
                    case 2:
                        System.out.println("------- Up Salary ------");
                        String codeUp = readCode();
                        if (!controller.checkID(codeUp)) {
                            throw new Exception("Code is not exist!");
                        }
                        double amountUp = readDouble("amount");
                        controller.upSalary(codeUp, amountUp);
                        System.out.println("Up salary successfully!");
                        break;
                    case 3:
                        System.out.println("------- Down Salary ------");
                        String codeDown = readCode();
                        if (!controller.checkID(codeDown)) {
                            throw new Exception("Code is not exist!");
                        }
                        double amountDown = readDouble("amount");
                        controller.downSalary(codeDown, amountDown);
                        System.out.println("Down salary successfully!");
                        break;
                    case 4:
                        controller.displaySalaryHistory();
                        break;
                    case 5:
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (!sc.hasNextLine()) {
                    return;
                }
            }
        }

    }

    private static int readInt(String field, int min, int max) throws Exception {
        System.out.println("Enter " + field + ":");
        return Validation.checkInt(sc.nextLine(), min, max);
    }

    private static double readDouble(String field) throws Exception {
        System.out.println("Enter " + field + ":");
        return Validation.checkDouble(sc.nextLine());
    }

    private static String readString(String field) throws Exception {
        System.out.println("Enter " + field + ":");
        return Validation.checkString(sc.nextLine());
    }

    private static String readCode() throws Exception {
        System.out.println("Enter Code:");
        return Validation.checkCode(sc.nextLine());
    }

}
