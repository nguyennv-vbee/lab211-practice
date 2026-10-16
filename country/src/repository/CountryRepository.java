package repository;

import java.util.ArrayList;
import java.util.List;
import model.EastAsiaCountries;

// In-memory storage. Copies prevent callers from changing stored countries.
public class CountryRepository {
    private final List<EastAsiaCountries> countries = new ArrayList<>();

    public int size() {
        return countries.size();
    }

    public boolean existsByCode(String code) {
        for (EastAsiaCountries country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void add(EastAsiaCountries country) {
        countries.add(copy(country));
    }

    public EastAsiaCountries getLast() {
        return countries.isEmpty() ? null : copy(countries.get(countries.size() - 1));
    }

    public List<EastAsiaCountries> getAll() {
        List<EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries country : countries) {
            result.add(copy(country));
        }
        return result;
    }

    private EastAsiaCountries copy(EastAsiaCountries country) {
        return new EastAsiaCountries(country.getCountryCode(), country.getCountryName(),
                country.getTotalArea(), country.getCountryTerrain());
    }
}
