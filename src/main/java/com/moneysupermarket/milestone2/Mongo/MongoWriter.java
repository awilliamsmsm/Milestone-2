package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.domain.Address;
import com.moneysupermarket.milestone2.domain.CarDetails;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

public class MongoWriter {

    public static void writeDocumentsToMongo(ArrayList<User> userList, MongoCollection<BasicDBObject> collection){
        //String dbCollection = "profiles";
        int profileCounter = 1;
        for (User user : userList) {

            BasicDBObject document = buildDocument(user);

            collection.insertOne(document);
            System.out.println("Profile " + profileCounter +" added to database");
            profileCounter++;
        }
    }

    private static BasicDBObject buildDocument(User user){
        BasicDBObject document = new BasicDBObject();
        document.put("firstName", user.getFirstName());
        document.put("lastName", user.getLastName());

        Address address = user.getAddress();
        BasicDBObject addressObject = buildAddressDocument(address);
        document.put("address", addressObject);

        CarDetails car = user.getCar();
        BasicDBObject carObject = buildCarDocument(car);
        document.put("car", carObject);

        return document;
    }

    private static BasicDBObject buildAddressDocument(Address address){
        BasicDBObject addressDocument = new BasicDBObject();
        addressDocument.put("houseNumber", address.getHouseNumber());
        addressDocument.put("street", address.getStreet());
        addressDocument.put("town", address.getTown());
        addressDocument.put("city", address.getCity());
        addressDocument.put("postCode", address.getPostCode());

        return addressDocument;
    }

    private static BasicDBObject buildCarDocument(CarDetails car){
        BasicDBObject carDocument = new BasicDBObject();
        carDocument.put("make", car.getCarMake());
        carDocument.put("model", car.getCarModel());
        carDocument.put("carRegistration", car.getCarReg());
        carDocument.put("engineSize", car.getEngSize());

        return carDocument;
    }


}
