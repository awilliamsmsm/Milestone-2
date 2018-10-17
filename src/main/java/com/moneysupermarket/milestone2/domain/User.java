package com.moneysupermarket.milestone2.domain;

public class User{

    private String firstName;
    private String lastName;
    private Address address;
    private CarDetails car;

    public User(String firstName, String lastName, Address address, CarDetails car){
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCar(car);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CarDetails getCar() {
        return car;
    }

    public void setCar(CarDetails car) {
        this.car = car;
    }

}
