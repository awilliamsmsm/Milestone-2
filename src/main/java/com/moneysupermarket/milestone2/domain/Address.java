package com.moneysupermarket.milestone2.domain;

public class Address{

    private String houseNumber;
    private String street;
    private String town;
    private String city;
    private String postCode;

    public Address(String houseNum, String streetName, String townName, String cityName, String postCode){
        setHouseNumber(houseNum);
        setStreet(streetName);
        setTown(townName);
        setCity(cityName);
        setPostCode(postCode);

    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

}
