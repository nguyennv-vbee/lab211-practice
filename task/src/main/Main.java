package main;

import constants.Constants;
import constants.Message;
import controller.TaskController;
import dto.TaskRequestDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        TaskController controller = new TaskController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);
            if (!scanner.hasNextLine()) {
                return;
            }
            try {
                int choice = Validation.getInteger(scanner.nextLine(),
                        Constants.MIN_CHOICE, Constants.MAX_CHOICE);
                switch (choice) {
                    case 1:
                        System.out.println(Message.ADD_TITLE);
                        TaskRequestDTO request = new TaskRequestDTO();
                        System.out.print(Message.INPUT_REQUIREMENT_NAME);
                        request.setRequirementName(Validation.getString(scanner.nextLine()));
                        System.out.print(Message.INPUT_TASK_TYPE);
                        String taskTypeID = Validation.getString(scanner.nextLine());
                        Validation.getInteger(taskTypeID, Constants.MIN_TASK_TYPE, Constants.MAX_TASK_TYPE);
                        request.setTaskTypeID(taskTypeID);
                        System.out.print(Message.INPUT_DATE);
                        String date = Validation.getString(scanner.nextLine());
                        Validation.getDate(date);
                        request.setDate(date);
                        System.out.print(Message.INPUT_PLAN_FROM);
                        String planFrom = Validation.getString(scanner.nextLine());
                        Validation.getPlanTime(planFrom);
                        request.setPlanFrom(planFrom);
                        System.out.print(Message.INPUT_PLAN_TO);
                        String planTo = Validation.getString(scanner.nextLine());
                        Validation.getPlanTime(planTo);
                        request.setPlanTo(planTo);
                        System.out.print(Message.INPUT_ASSIGNEE);
                        request.setAssignee(Validation.getString(scanner.nextLine()));
                        System.out.print(Message.INPUT_REVIEWER);
                        request.setReviewer(Validation.getString(scanner.nextLine()));
                        controller.addTask(request);
                        break;
                    case 2:
                        System.out.println(Message.DELETE_TITLE);
                        System.out.print(Message.INPUT_ID);
                        controller.deleteTask(Validation.getString(scanner.nextLine()));
                        break;
                    case 3:
                        controller.showTasks();
                        break;
                    case 4:
                        System.out.println(Message.EXIT);
                        return;
                    default:
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (!scanner.hasNextLine()) {
                    return;
                }
            }
        }
    }
}
