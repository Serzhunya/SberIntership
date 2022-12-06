import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = SupportingFunctions.parseFile();
        SupportingFunctions.sortingCitiesByName (cities);
        SupportingFunctions.sortingCitiesByDistrict(cities);
        SupportingFunctions.print(cities);
    }
}