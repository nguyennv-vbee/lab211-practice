package utils;

import constants.Constants;
import constants.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public final class Validation {
    private Validation() {
    }

    public static String getString(String input) {
        final String value;
        try {
            value = Objects.requireNonNull(input).trim();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        return value;
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

    public static Date getDate(String input) {
        String value = getString(input);
        if (!value.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
            throw new IllegalArgumentException(Message.INVALID_DATE);
        }
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_PATTERN, Locale.ENGLISH);
        formatter.setLenient(false);
        try {
            return formatter.parse(value);
        } catch (ParseException e) {
            throw new IllegalArgumentException(Message.INVALID_DATE);
        }
    }

    public static double getPlanTime(String input) {
        final double number;
        try {
            number = Double.parseDouble(getString(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_NUMBER);
        }
        if (!Double.isFinite(number) || number < Constants.MIN_PLAN_TIME
                || number > Constants.MAX_PLAN_TIME || number * 2 != Math.floor(number * 2)) {
            throw new IllegalArgumentException(Message.INVALID_PLAN_TIME);
        }
        return number;
    }
}
