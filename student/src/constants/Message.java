package constants;

public final class Message {
    private Message() { }

    public static final String MENU =
            "\nWELCOME TO STUDENT MANAGEMENT\n"
            + "1. Create\n"
            + "2. Find and Sort\n"
            + "3. Update/Delete\n"
            + "4. Report\n"
            + "5. Exit";
    public static final String INPUT_CHOICE = "Please choose (1-5): ";
    public static final String INPUT_ID = "Enter student ID: ";
    public static final String INPUT_NAME = "Enter student name: ";
    public static final String INPUT_SEMESTER = "Enter semester: ";
    public static final String INPUT_COURSE = "Enter course (Java, .Net, C/C++): ";
    public static final String INPUT_SEARCH = "Enter name or part of name: ";
    public static final String INPUT_ACTION = "Update (U) or Delete (D)? ";
    public static final String INPUT_OLD_SEMESTER = "Enter CURRENT semester of the record: ";
    public static final String INPUT_OLD_COURSE = "Enter CURRENT course of the record (Java, .Net, C/C++): ";
    public static final String INPUT_NEW_ID = "Enter NEW student ID: ";
    public static final String INPUT_NEW_NAME = "Enter NEW student name: ";
    public static final String INPUT_NEW_SEMESTER = "Enter NEW semester: ";
    public static final String INPUT_NEW_COURSE = "Enter NEW course (Java, .Net, C/C++): ";
    public static final String ASK_CONTINUE = "Do you want to continue (Y/N)? ";
    public static final String EMPTY_INPUT = "Input must not be empty.";
    public static final String INVALID_CHOICE = "Please select a number from 1 to 5.";
    public static final String INVALID_YES_NO = "Please enter Y or N.";
    public static final String INVALID_ACTION = "Please enter U or D.";
    public static final String INVALID_COURSE = "Course must be Java, .Net, or C/C++.";
    public static final String DUPLICATE_ENROLLMENT = "This student has already registered this course in this semester.";
    public static final String INCONSISTENT_NAME = "The same student ID must have the same student name.";
    public static final String STUDENT_NOT_FOUND = "Student ID not found.";
    public static final String RECORD_NOT_FOUND = "No record matches this ID, semester and course.";
    public static final String NO_RESULT = "No matching students found.";
    public static final String EMPTY_DATABASE = "No students in the database.";
    public static final String CREATE_SUCCESS = "Student record created successfully.";
    public static final String UPDATE_SUCCESS = "Student record updated successfully.";
    public static final String DELETE_SUCCESS = "Student record deleted successfully.";
    public static final String EXIT = "Goodbye!";
    public static final String STUDENT_HEADER = "%-12s | %-24s | %-14s | %-10s%n";
    public static final String REPORT_HEADER = "%-24s | %-12s | %-8s%n";
}
