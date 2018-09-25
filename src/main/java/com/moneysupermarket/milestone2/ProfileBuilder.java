package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.domain.Address;
import com.moneysupermarket.milestone2.domain.CarDetails;
import com.moneysupermarket.milestone2.domain.User;

public class ProfileBuilder {
    public User build(String profLine) {//, Integer profNum){
        String splitVal = ",";
        String line = profLine;
        //Integer num = profNum;
        String[] prof = line.split(splitVal);
        int topIndex = 10;
        int size = prof.length;
        if (size > topIndex) {
//            Address add = buildAddress(prof);
//            CarDetails car = buildCar(prof);
            User user = buildUser(prof);
            return user;
        } else {
            System.out.println("Input is missing data");
            return null;
        }
        //com.moneysupermarket.milestone2.PrintToFile.printToFile(user, num);
        //return user;
    }

    private User buildUser(String[] data){
        String firstName = data[0];
        String lastName = data[1];
        Address add = buildAddress(data);
        CarDetails car = buildCar(data);

        return new User(firstName, lastName, add, car);
    }

    private Address buildAddress(String[] data) {
        String houseNumber = data[2];
        String street = data[3];
        String town = data[4];
        String city = data[5];
        String postCode = data[6];

        return new Address(houseNumber, street, town, city, postCode);
    }

    private CarDetails buildCar(String[] data) {
        String carReg = data[7];
        String carMake = data[8];
        String carModel = data[9];
        Double engineSize = Double.parseDouble(data[10]);

        return new CarDetails(carReg, carMake, carModel, engineSize);
    }

}