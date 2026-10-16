package view;

import constants.Message;
import dto.CountryResponseDTO;
import java.util.List;
import java.util.Locale;

public class CountryView {
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showCountry(CountryResponseDTO country) {
        showHeader();
        showRow(country);
    }

    public void showCountries(List<CountryResponseDTO> countries, String emptyMessage) {
        if (countries.isEmpty()) {
            showMessage(emptyMessage);
            return;
        }
        showHeader();
        for (CountryResponseDTO country : countries) {
            showRow(country);
        }
    }

    private void showHeader() {
        System.out.printf(Message.COUNTRY_HEADER, "ID", "Name", "Total Area", "Terrain");
    }

    private void showRow(CountryResponseDTO country) {
        System.out.printf(Locale.ENGLISH, Message.COUNTRY_ROW, country.getCountryCode(),
                country.getCountryName(), country.getTotalArea(), country.getCountryTerrain());
    }
}
