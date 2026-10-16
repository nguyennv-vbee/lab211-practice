package model;

import constants.Message;
import java.util.Locale;

public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName,
            float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf(Locale.ENGLISH, Message.COUNTRY_ROW,
                countryCode, countryName, totalArea, countryTerrain);
    }
}
