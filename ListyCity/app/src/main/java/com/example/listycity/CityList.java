package com.example.listycity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns a boolean value; true if the list has the City, false if it does not
     * @param city
     * The city to look for in the list
     * @return
     * Return a boolean value stating if the list has the city.
     */
    public boolean hasCity(City city){
        boolean city_available = cities.contains(city);
        return city_available;
    }


    /**
     * This removes the given city from the list, and throws an exception if not able to
     * @param city
     * The city to remove from the list
     * @throws IllegalArgumentException
     * throws an exception if no city was deleted.
     */
    public void delete(City city){
        if (!cities.remove(city)){
            throw new IllegalArgumentException("Could not Delete the item.");
        }
    }

    /**
     * This counts the number of city in the list
     * @return
     * returns the integer value/ count of all items in the list.
     */
    public int countCities(){
        return cities.size();
    }

}
