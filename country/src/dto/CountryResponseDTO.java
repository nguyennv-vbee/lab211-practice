package dto;

public class CountryResponseDTO {
    private final String countryCode;
    private final String countryName;
    private final float totalArea;
    private final String countryTerrain;

    public CountryResponseDTO(String countryCode, String countryName,
            float totalArea, String countryTerrain) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
        this.countryTerrain = countryTerrain;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }
}
