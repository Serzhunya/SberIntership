import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = SupportingFunctions.parseFile();
        City[] arrayOfCities = SupportingFunctions.getArrayOfCity(cities);
        SupportingFunctions.getCityWithMaxPopulation(arrayOfCities);
    }
}