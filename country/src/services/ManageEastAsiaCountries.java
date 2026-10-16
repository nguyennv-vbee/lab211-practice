package services;

import constants.Constants;
import constants.Message;
import dto.CountryRequestDTO;
import dto.CountryResponseDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import model.EastAsiaCountries;
import repository.CountryRepository;
import utils.Validation;

public class ManageEastAsiaCountries {
    private final CountryRepository repository;

    public ManageEastAsiaCountries() {
        repository = new CountryRepository();
    }

    // Adapter for Controller: convert request DTO into Model inside Service.
    public void addCountry(CountryRequestDTO request) throws Exception {
        if (request == null) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        addCountryInformation(new EastAsiaCountries(request.getCountryCode(),
                request.getCountryName(), request.getTotalArea(), request.getCountryTerrain()));
    }

    // Required by J1.S.P0052.
    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        if (country == null) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT);
        }
        String code = Validation.getString(country.getCountryCode());
        String name = Validation.getString(country.getCountryName());
        float area = Validation.validateArea(country.getTotalArea());
        String terrain = Validation.getString(country.getCountryTerrain());
        if (repository.existsByCode(code)) {
            throw new IllegalArgumentException(Message.DUPLICATE_CODE);
        }
        if (repository.size() >= Constants.MAX_COUNTRIES) {
            throw new IllegalArgumentException(Message.COUNTRY_LIMIT);
        }
        repository.add(new EastAsiaCountries(code, name, area, terrain));
    }

    // Required by J1.S.P0052: return the single most recently entered country.
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        EastAsiaCountries country = repository.getLast();
        if (country == null) {
            throw new IllegalArgumentException(Message.NO_COUNTRIES);
        }
        return country;
    }

    // Required by J1.S.P0052. Search by part of the name, ignoring letter case.
    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        String keyword = Validation.getString(name).toLowerCase(Locale.ROOT);
        List<EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries country : repository.getAll()) {
            if (country.getCountryName().toLowerCase(Locale.ROOT).contains(keyword)) {
                result.add(country);
            }
        }
        return result.toArray(new EastAsiaCountries[0]);
    }

    // Required by J1.S.P0052. Sort a copy so the most recent country is unchanged.
    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        List<EastAsiaCountries> result = repository.getAll();
        result.sort(Comparator.comparing(EastAsiaCountries::getCountryName,
                String.CASE_INSENSITIVE_ORDER));
        return result.toArray(new EastAsiaCountries[0]);
    }

    public CountryResponseDTO getRecentlyEnteredResponse() throws Exception {
        return toResponse(getRecentlyEnteredInformation());
    }

    public List<CountryResponseDTO> searchCountryResponse(String name) throws Exception {
        return toResponses(searchInformationByName(name));
    }

    public List<CountryResponseDTO> getSortedCountryResponse() throws Exception {
        return toResponses(sortInformationByAscendingOrder());
    }

    private List<CountryResponseDTO> toResponses(EastAsiaCountries[] countries) {
        List<CountryResponseDTO> result = new ArrayList<>();
        for (EastAsiaCountries country : countries) {
            result.add(toResponse(country));
        }
        return result;
    }

    private CountryResponseDTO toResponse(EastAsiaCountries country) {
        return new CountryResponseDTO(country.getCountryCode(), country.getCountryName(),
                country.getTotalArea(), country.getCountryTerrain());
    }
}
