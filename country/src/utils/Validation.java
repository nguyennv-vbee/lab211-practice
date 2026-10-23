package utils;

import constants.Message;

public final class Validation {
    private Validation() {
    }

    public static String getString(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    public static int getInteger(String input, int min, int max) throws Exception {
        final int number;
        try {
            number = Integer.parseInt(getString(input));
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_INTEGER);
        }
        if (number < min || number > max) {
            throw new Exception(String.format(Message.INVALID_RANGE, min, max));
        }
        return number;
    }

    public static float getPositiveFloat(String input) throws Exception {
        final float number;
        try {
            number = Float.parseFloat(getString(input));
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
        return validateArea(number);
    }

    public static float validateArea(float area) throws Exception {
        if (!Float.isFinite(area) || area <= 0) {
            throw new Exception(Message.INVALID_AREA);
        }
        return area;
    }
}
