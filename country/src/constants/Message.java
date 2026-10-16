package constants;

public final class Message {
    private Message() {
    }

    public static final String MENU = "\n                               MENU\n"
            + "==========================================================================\n"
            + "1. Input the information of 11 countries in East Asia\n"
            + "2. Display the information of country you've just input\n"
            + "3. Search the information of country by user-entered name\n"
            + "4. Display the information of countries sorted name in ascending order\n"
            + "5. Exit\n"
            + "==========================================================================";
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_CODE = "Enter code of country: ";
    public static final String INPUT_NAME = "Enter name of country: ";
    public static final String INPUT_AREA = "Enter total Area: ";
    public static final String INPUT_TERRAIN = "Enter terrain of country: ";
    public static final String INPUT_SEARCH = "Enter the name you want to search for: ";
    public static final String EMPTY_INPUT = "Input must not be empty.";
    public static final String INVALID_INTEGER = "Please enter a valid integer.";
    public static final String INVALID_RANGE = "Please enter a number from %d to %d.";
    public static final String INVALID_NUMBER = "Please enter a valid number.";
    public static final String INVALID_AREA = "Total area must be finite and greater than 0.";
    public static final String DUPLICATE_CODE = "Country code already exists.";
    public static final String COUNTRY_LIMIT = "Only 11 countries can be entered.";
    public static final String NO_COUNTRIES = "No countries have been entered.";
    public static final String NO_RESULTS = "No countries match the entered name.";
    public static final String ADD_SUCCESS = "Country added successfully.";
    public static final String COUNTRY_HEADER = "%-12s %-24s %-16s %-20s%n";
    public static final String COUNTRY_ROW = "%-12s %-24s %-16.1f %-20s%n";
    public static final String BASE_COUNTRY_ROW = "%-12s %-24s %-16.1f%n";
    public static final String EXIT = "Goodbye!";
}
