package main;

import constants.Constants;
import constants.Message;
import constants.SalaryStatus;
import controller.WorkerController;
import dto.SalaryChangeRequestDTO;
import dto.WorkerRequestDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        WorkerController controller = new WorkerController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);
            try {
                int choice = Validation.getInteger(scanner.nextLine(),
                        Constants.MIN_CHOICE, Constants.MAX_CHOICE);
                switch (choice) {
                    case 1:
                        WorkerRequestDTO workerRequest = new WorkerRequestDTO();
                        System.out.print(Message.INPUT_CODE);
                        workerRequest.setCode(Validation.getString(scanner.nextLine()));
                        System.out.print(Message.INPUT_NAME);
                        workerRequest.setName(Validation.getString(scanner.nextLine()));
                        System.out.print(Message.INPUT_AGE);
                        workerRequest.setAge(Validation.getInteger(scanner.nextLine(),
                                Constants.MIN_AGE, Constants.MAX_AGE));
                        System.out.print(Message.INPUT_SALARY);
                        workerRequest.setSalary(Validation.getPositiveDouble(scanner.nextLine()));
                        System.out.print(Message.INPUT_LOCATION);
                        workerRequest.setWorkLocation(Validation.getString(scanner.nextLine()));
                        controller.addWorker(workerRequest);
                        break;
                    case 2:
                    case 3:
                        SalaryChangeRequestDTO salaryRequest = new SalaryChangeRequestDTO();
                        System.out.print(Message.INPUT_CODE);
                        salaryRequest.setCode(Validation.getString(scanner.nextLine()));
                        System.out.print(Message.INPUT_AMOUNT);
                        salaryRequest.setAmount(Validation.getPositiveDouble(scanner.nextLine()));
                        controller.changeSalary(choice == 2 ? SalaryStatus.UP : SalaryStatus.DOWN,
                                salaryRequest);
                        break;
                    case 4:
                        controller.showSalaryHistory();
                        break;
                    case 5:
                        System.out.println(Message.EXIT);
                        return;
                    default:
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
