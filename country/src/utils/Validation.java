package utils;

import constants.Message;

public final class Validation {
    private Validation() {
    }

    public static String getString(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    public static int getInteger(String input, int min, int max) {
        final int number;
        try {
            number = Integer.parseInt(getString(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_INTEGER);
        }
        if (number < min || number > max) {
            throw new IllegalArgumentException(String.format(Message.INVALID_RANGE, min, max));
        }
        return number;
    }

    public static float getPositiveFloat(String input) {
        final float number;
        try {
            number = Float.parseFloat(getString(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_NUMBER);
        }
        return validateArea(number);
    }

    public static float validateArea(float area) {
        if (!Float.isFinite(area) || area <= 0) {
            throw new IllegalArgumentException(Message.INVALID_AREA);
        }
        return area;
    }
}
