import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;

public class SupportingFunctions {
    public static List<City> parseFile () {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/city_ru.csv"));
            while (scanner.hasNextLine()) { // считываю каждую строчку (будущий объект City)
                cities.add(parseLine(scanner.nextLine())); // добавляю в массив City новый объект City
            }
            scanner.close();
        } catch (FileNotFoundException e) { // выбросит исключение если файла нету
            e.printStackTrace();
        }
        return cities;
    }

    private static City parseLine(String line) { // парсер в строке
        Scanner scanner = new Scanner(line); // создаем поток строки
        scanner.useDelimiter(";"); // ";" разделитель в строке
        scanner.skip("\\d*"); // пропускаем порядковый номер строки
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) { // если дата основания указана
            foundation = scanner.next();
        }
        scanner.close();
        return new City(name, region, district, population, foundation);
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    public static void sortingCitiesByNameV1 (List<City> cities) {
        Collections.sort(cities, new Comparator <City>() {
            @Override
            // функция сравнения без учета регистра
            public int compare(City o1, City o2) {
                return o1.getName()
                        .compareToIgnoreCase(o2.getName());
            }
        });
    }

    public static void sortingCitiesByNameV2 (List<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    public static void sortingCitiesByDistrictAndName(List<City> cities) {
        // сортировка по федеральному округу
        Comparator<City> compareByDistrict = Comparator.comparing(City::getDistrict);
        // сортировка по названию города внутри федерального округа
        Comparator<City> compareByName = Comparator.comparing(City::getName);
        // сортировка по федеральному округу и названию города внутри каждого федерального округа
        Comparator<City> compareFull = compareByDistrict.thenComparing(compareByName);
        Collections.sort(cities, compareFull);
    }

    public static City[] getArrayOfCity (List<City> cities) { // получить массив класса City
        City[] arrayOfCities = new City[cities.size()];
        for(int i = 0; i < cities.size(); i++) {
            arrayOfCities[i] = cities.get(i);
        }
        return arrayOfCities;
    }

    public static void printCityWithMaxPopulation(City[] arrayOfCities) { // вывести город с наибольшим количеством жителей
        int maxPopulation = arrayOfCities[0].getPopulation();
        int index = 0;
        for(int i = 1; i < arrayOfCities.length; i++) {
            if(maxPopulation <  arrayOfCities[i].getPopulation()) {
                maxPopulation = arrayOfCities[i].getPopulation();
                index = i;
            }
        }
        System.out.println(MessageFormat.format("[{0}] = {1}", index, maxPopulation));
    }
}
