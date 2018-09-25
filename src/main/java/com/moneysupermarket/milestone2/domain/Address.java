package com.moneysupermarket.milestone2.domain;

public class Address{

    private String houseNumber;
    private String street;
    private String town;
    private String city;
    private String postCode;

    public Address(String hNum, String strt, String twn, String cty, String pCode){
        setHouseNumber(hNum);
        setStreet(strt);
        setTown(twn);
        setCity(cty);
        setPostCode(pCode);

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

//    public String getAddress(){
//        String add = Integer.toString(getHouseNumber()) + " " + getStreet() + ",\n" + getTown() + ",\n" + getCity() + ",\n" + getPostCode();
//        return add;
//    }

//    public String toString(){
//        String add = Integer.toString(getHouseNumber()) + " " + getStreet() + ",\n" + getTown() + ",\n" + getCity() + ",\n" + getPostCode();
//        return add;
//    }
}
