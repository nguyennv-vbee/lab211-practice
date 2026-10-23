/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Pattern;

/**
 *
 * @author nguye
 */
public class Validation {

    private static final Pattern CODE_PATTERN = Pattern.compile("^[A-Za-z][0-9]{5}$");

    public Validation() {
    }

    // Parse and validate an integer without reading console input.
    public static int checkInt(String input, int min, int max) throws Exception {
        int number;
        try {
            number = Integer.parseInt(checkString(input));
        } catch (NumberFormatException e) {
            throw new Exception("Enter integer number, please!");
        }
        return checkInt(number, min, max);
    }

    public static int checkInt(int number, int min, int max) throws Exception {
        if (number < min || number > max) {
            throw new Exception("Number must be between " + min + " and " + max + " (inclusive).");
        }
        return number;
    }

    // Parse and validate a positive, finite number.
    public static double checkDouble(String input) throws Exception {
        double number;
        try {
            number = Double.parseDouble(checkString(input));
        } catch (NumberFormatException e) {
            throw new Exception("Enter double number, please!");
        }
        return checkDouble(number);
    }

    public static double checkDouble(double number) throws Exception {
        if (!Double.isFinite(number) || number <= 0) {
            throw new Exception("Number must be finite and greater than zero.");
        }
        return number;
    }

    // Worker code: exactly one letter followed by five digits.
    public static String checkCode(String code) throws Exception {
        if (code == null || !CODE_PATTERN.matcher(code).matches()) {
            throw new Exception("Code must contain exactly 6 characters: one letter followed by 5 digits (e.g. W00001).");
        }
        return code;
    }

    public static String checkString(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception("Value must not be empty.");
        }
        return input.trim();
    }

}
