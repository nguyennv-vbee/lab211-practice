package constants;

public final class Message {
    private Message() {
    }

    public static final String MENU = "\n========= Task program =========\n"
            + "1. Add Task\n"
            + "2. Delete task\n"
            + "3. Display Task\n"
            + "4. Exit\n"
            + "================================";
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String ADD_TITLE = "------------Add Task---------------";
    public static final String DELETE_TITLE = "---------Del Task------";
    public static final String INPUT_REQUIREMENT_NAME = "Requirement Name: ";
    public static final String INPUT_TASK_TYPE = "Task Type (1-Code, 2-Test, 3-Design, 4-Review): ";
    public static final String INPUT_DATE = "Date (dd-MM-yyyy): ";
    public static final String INPUT_PLAN_FROM = "From: ";
    public static final String INPUT_PLAN_TO = "To: ";
    public static final String INPUT_ASSIGNEE = "Assignee: ";
    public static final String INPUT_REVIEWER = "Reviewer: ";
    public static final String INPUT_ID = "ID: ";

    public static final String EMPTY_INPUT = "Input must not be empty.";
    public static final String INVALID_INTEGER = "Please enter a valid integer.";
    public static final String INVALID_NUMBER = "Please enter a valid number.";
    public static final String INVALID_RANGE = "Please enter a number from %d to %d.";
    public static final String INVALID_DATE = "Please enter a valid date in dd-MM-yyyy format.";
    public static final String INVALID_PLAN_TIME = "Time must be from 8.0 to 17.5 in steps of 0.5.";
    public static final String INVALID_PLAN_ORDER = "Plan From must be less than Plan To.";
    public static final String TASK_NOT_FOUND = "Task ID does not exist.";
    public static final String ADD_SUCCESS = "Task added successfully. ID: %d";
    public static final String DELETE_SUCCESS = "Task deleted successfully.";
    public static final String NO_TASKS = "No tasks found.";
    public static final String TASK_TITLE = "\n----------------------------------------- Task ---------------------------------------";
    public static final String TASK_HEADER = "%-5s %-22s %-12s %-12s %-8s %-18s %-18s%n";
    public static final String TASK_ROW = "%-5d %-22s %-12s %-12s %-8.1f %-18s %-18s%n";
    public static final String TASK_SEPARATOR = "---------------------------------------------------------------------------------------";
    public static final String EXIT = "Goodbye!";
}
