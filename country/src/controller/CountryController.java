package controller;

import constants.Message;
import dto.CountryRequestDTO;
import services.ManageEastAsiaCountries;
import view.CountryView;

// Controller coordinates DTO -> Service -> View.
public class CountryController {
    private final ManageEastAsiaCountries management;
    private final CountryView countryView;

    public CountryController() {
        management = new ManageEastAsiaCountries();
        countryView = new CountryView();
    }

    public void addCountry(CountryRequestDTO request) throws Exception {
        management.addCountry(request);
        countryView.showMessage(Message.ADD_SUCCESS);
    }

    public void showRecentlyEnteredCountry() throws Exception {
        countryView.showCountry(management.getRecentlyEnteredResponse());
    }

    public void searchCountries(String name) throws Exception {
        countryView.showCountries(management.searchCountryResponse(name), Message.NO_RESULTS);
    }

    public void showSortedCountries() throws Exception {
        countryView.showCountries(management.getSortedCountryResponse(), Message.NO_COUNTRIES);
    }
}
