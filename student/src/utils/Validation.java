package utils;

import constants.Constants;
import constants.Message;

public final class Validation {
    private Validation() { }

    public static String requireText(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim().replaceAll("\\s+", " ");
    }

    public static int getMenuChoice(String input) throws Exception {
        try {
            int choice = Integer.parseInt(requireText(input));
            if (choice >= Constants.MENU_MIN && choice <= Constants.MENU_MAX) {
                return choice;
            }
        } catch (NumberFormatException ignored) {
            // Error message is provided below.
        }
        throw new Exception(Message.INVALID_CHOICE);
    }

    public static String getCourse(String input) throws Exception {
        String course = requireText(input);
        if (course.equalsIgnoreCase(Constants.JAVA)) return Constants.JAVA;
        if (course.equalsIgnoreCase(Constants.DOT_NET)) return Constants.DOT_NET;
        if (course.equalsIgnoreCase(Constants.CPP)) return Constants.CPP;
        throw new Exception(Message.INVALID_COURSE);
    }

    public static boolean getYesNo(String input) throws Exception {
        String value = requireText(input);
        if (value.equalsIgnoreCase("Y")) return true;
        if (value.equalsIgnoreCase("N")) return false;
        throw new Exception(Message.INVALID_YES_NO);
    }

    public static Constants.Action getAction(String input) throws Exception {
        String value = requireText(input);
        if (value.equalsIgnoreCase("U")) return Constants.Action.UPDATE;
        if (value.equalsIgnoreCase("D")) return Constants.Action.DELETE;
        throw new Exception(Message.INVALID_ACTION);
    }
}
