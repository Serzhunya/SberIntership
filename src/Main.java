import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = SupportingFunctions.parseFile();
        SupportingFunctions.sortingCitiesByNameV1(cities);
        SupportingFunctions.sortingCitiesByNameV2(cities);
        SupportingFunctions. sortingCitiesByDistrictAndName(cities);
        SupportingFunctions.print(cities);
    }
}