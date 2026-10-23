package main;

import constants.Constants;
import constants.Message;
import controller.CountryController;
import dto.CountryRequestDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        CountryController controller = new CountryController();
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
                        CountryRequestDTO request = new CountryRequestDTO();
                        request.setCountryCode(readString(scanner, Message.INPUT_CODE));
                        request.setCountryName(readString(scanner, Message.INPUT_NAME));
                        request.setTotalArea(readArea(scanner));
                        request.setCountryTerrain(readString(scanner, Message.INPUT_TERRAIN));
                        controller.addCountry(request);
                        break;
                    case 2:
                        controller.showRecentlyEnteredCountry();
                        break;
                    case 3:
                        controller.searchCountries(readString(scanner, Message.INPUT_SEARCH));
                        break;
                    case 4:
                        controller.showSortedCountries();
                        break;
                    case 5:
                        System.out.println(Message.EXIT);
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (!scanner.hasNextLine()) {
                    return;
                }
            }
        }
    }

    private static String readString(Scanner scanner, String prompt) throws Exception {
        System.out.print(prompt);
        return Validation.getString(scanner.nextLine());
    }

    private static float readArea(Scanner scanner) throws Exception {
        System.out.print(Message.INPUT_AREA);
        return Validation.getPositiveFloat(scanner.nextLine());
    }
}
