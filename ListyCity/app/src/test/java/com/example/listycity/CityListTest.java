package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList cityList = new CityList();

        City edmonton = new City("Edmonton","Alberta");
        City toronto = new City("Toronto","Ontario");

        assertFalse(cityList.hasCity(toronto));
        cityList.add(toronto);

        assertTrue(cityList.hasCity(toronto));

        assertFalse(cityList.hasCity(edmonton));

        assertTrue(cityList.hasCity(new City("Toronto","Ontario")));

    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.add(charlottetown);
        assertEquals(2, cityList.countCities());

        assertTrue(cityList.hasCity(charlottetown));
        cityList.delete(charlottetown);

        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(charlottetown));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.add(charlottetown);
        cityList.delete(charlottetown);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(charlottetown);
        });
    }

    @Test

    void testCount() {

        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.add(charlottetown);

        assertEquals(2, cityList.countCities());

    }
}
