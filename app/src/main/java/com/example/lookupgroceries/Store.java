package com.example.lookupgroceries;

public class Store {
    private Boolean Automobile;
    private Boolean Grocery;
    private Boolean Restaurant;
    private String City;
    private String State;
    private String Location;
    private String StoreName;
    private Integer Zip;
    private Integer ChainId;

    public Store(Boolean automobile, Boolean grocery, Boolean restaurant, String city, String state, String location, String storeName, Integer zip, Integer chainId) {
        Automobile = automobile;
        Grocery = grocery;
        Restaurant = restaurant;
        City = city;
        State = state;
        Location = location;
        StoreName = storeName;
        Zip = zip;
        ChainId = chainId;
    }

    public Boolean getAutomobile() {
        return Automobile;
    }

    public void setAutomobile(Boolean automobile) {
        Automobile = automobile;
    }

    public Boolean getGrocery() {
        return Grocery;
    }

    public void setGrocery(Boolean grocery) {
        Grocery = grocery;
    }

    public Boolean getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(Boolean restaurant) {
        Restaurant = restaurant;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public Integer getZip() {
        return Zip;
    }

    public void setZip(Integer zip) {
        Zip = zip;
    }

    public Integer getChainId() {
        return ChainId;
    }

    public void setChainId(Integer chainId) {
        ChainId = chainId;
    }
}
