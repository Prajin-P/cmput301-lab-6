package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {

    /**
     * The name of the city.
     */
    private String city;

    /**
     * The name of the province.
     */
    private String province;

    /**
     * Constructor for object City with the city name and province name.
     *
     * @param city     the name of the city
     * @param province the name of the province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Getter to return city's name
     *
     * @return city's name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Getter to return province's name
     *
     * @return province's name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares two cities names for sorting
     * @param o
     * city you want to compare the current city with.
     * @return int
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(o.getCityName());
    }


    /**
     * Compares two cities names to see if they are the same, i.e. if the name and the province are the same they are the same.
     * @param o
     * the object to compare the city name with
     * @return
     * true if they are same, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }

        /**
         * The other city to check with if it is equal with.
         */
        City other = (City) o;

        return Objects.equals(city, ((City) o).city)
                && Objects.equals(province, ((City) o).province);
    }


    /**
     * Creates a hascode for equals.
     * @return
     * the has for the city and province name.
     */
    @Override
    public int hashCode(){
        return Objects.hash(city, province);
    }
}

