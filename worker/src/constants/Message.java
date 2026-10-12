package constants;

public final class Message {
    private Message() {
    }

    public static final String MENU = "\n========== WORKER MANAGEMENT ==========\n"
            + "1. Add Worker\n"
            + "2. Increase Salary\n"
            + "3. Decrease Salary\n"
            + "4. Show Salary History\n"
            + "5. Exit\n"
            + "=======================================";

    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_CODE = "Enter Code: ";
    public static final String INPUT_NAME = "Enter Name: ";
    public static final String INPUT_AGE = "Enter Age: ";
    public static final String INPUT_SALARY = "Enter Salary: ";
    public static final String INPUT_LOCATION = "Enter Work Location: ";
    public static final String INPUT_AMOUNT = "Enter Amount: ";

    public static final String EMPTY_INPUT = "Input must not be empty.";
    public static final String INVALID_INTEGER = "Please enter a valid integer.";
    public static final String INVALID_NUMBER = "Please enter a valid number.";
    public static final String INVALID_RANGE = "Please enter a number from %d to %d.";
    public static final String POSITIVE_NUMBER = "The number must be greater than 0.";
    public static final String DUPLICATE_CODE = "Worker code already exists.";
    public static final String WORKER_NOT_FOUND = "Worker code does not exist.";
    public static final String INVALID_SALARY = "Salary after adjustment must be greater than 0.";
    public static final String INVALID_STATUS = "Invalid salary adjustment status.";
    public static final String ADD_SUCCESS = "Worker added successfully.";
    public static final String CHANGE_SUCCESS = "Salary adjusted successfully.";
    public static final String NO_HISTORY = "No salary adjustment history found.";
    public static final String HISTORY_TITLE = "\n---------------- SALARY HISTORY ----------------";
    public static final String HISTORY_HEADER = "%-10s %-18s %-5s %-12s %-8s %-20s%n";
    public static final String HISTORY_ROW = "%-10s %-18s %-5d %-12.2f %-8s %-20s%n";
    public static final String HISTORY_SEPARATOR = "--------------------------------------------------------------------------";
    public static final String EXIT = "Goodbye!";
}
