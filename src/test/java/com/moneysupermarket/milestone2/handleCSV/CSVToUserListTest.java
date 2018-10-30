package com.moneysupermarket.milestone2.handleCSV;

import com.moneysupermarket.milestone2.domain.Address;
import com.moneysupermarket.milestone2.domain.CarDetails;
import com.moneysupermarket.milestone2.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CSVToUserListTest {

    @Test
    public void testUsersInList(){
        //ArrayList<User> testUsers = new ArrayList<>();
        Address testAddress1 = new Address("97", "Heffernan", "Grand Junction", "Colorado", "81505");
        CarDetails testCar1 = new CarDetails("3N1BC1AP5BL916571","Saab", "9000", 3.8);
        User testUser1 = new User("Erminie", "McCluney", testAddress1, testCar1);
        //testUsers.add(testUser);

        Address testAddress2 = new Address("86", "Express", "Jacksonville", "Florida", "32244");
        CarDetails testCar2 = new CarDetails("WBAUU3C56CA231740","Lincoln", "Town Car", 3.1);
        User testUser2 = new User("Britni", "Nelle", testAddress2, testCar2);


        List<String> testUserList = new ArrayList<String>();
        testUserList.add("Erminie,McCluney,97,Heffernan,Grand Junction,Colorado,81505,3N1BC1AP5BL916571,Saab,9000,3.8");
        testUserList.add("Britni,Nelle,86,Express,Jacksonville,Florida,32244,WBAUU3C56CA231740,Lincoln,Town Car,3.1");
        CSVToUserList testCSVtoUser = new CSVToUserList();
        ArrayList<User> users = testCSVtoUser.stringToUser(testUserList);

        assertEquals(testUser1.getFirstName(), users.get(0).getFirstName());
        assertEquals(testUser1.getAddress().getPostCode(), users.get(0).getAddress().getPostCode());
        assertEquals(testUser1.getCar().getCarReg(), users.get(0).getCar().getCarReg());

        assertEquals(testUser2.getFirstName(), users.get(1).getFirstName());
        assertEquals(testUser2.getAddress().getPostCode(), users.get(1).getAddress().getPostCode());
        assertEquals(testUser2.getCar().getCarReg(), users.get(1).getCar().getCarReg());
    }

}