package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.domain.Address;
import com.moneysupermarket.milestone2.domain.CarDetails;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

public class MongoWriter {

    public static void writeDocumentsToMongo(ArrayList<User> userList, MongoCollection<BasicDBObject> collection){
        //String dbName = "myMongoDb";
        String dbCollection = "profiles";
        //MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection); //return collection
        int i = 1;
        for (User user : userList) {

            BasicDBObject document = buildDocument(user);

            collection.insertOne(document);
            System.out.println("Profile " + i +" added to database");
            i++;
        }
    }

    private static BasicDBObject buildDocument(User user){
        BasicDBObject document = new BasicDBObject();
        document.put("firstName", user.getFirstName());
        document.put("lastName", user.getLastName());

        Address address = user.getAddress();
        BasicDBObject addr = buildAddressDocument(address);
        document.put("address", addr);

        CarDetails car = user.getCar();
        BasicDBObject carDetails = buildCarDocument(car);
        document.put("car", carDetails);

        return document;
    }

    private static BasicDBObject buildAddressDocument(Address address){
        BasicDBObject addr = new BasicDBObject();
        addr.put("houseNumber", address.getHouseNumber());
        addr.put("street", address.getStreet());
        addr.put("town", address.getTown());
        addr.put("city", address.getCity());
        addr.put("postCode", address.getPostCode());

        return addr;
    }

    private static BasicDBObject buildCarDocument(CarDetails car){
        BasicDBObject carDetails = new BasicDBObject();
        carDetails.put("make", car.getCarMake());
        carDetails.put("model", car.getCarModel());
        carDetails.put("carRegistration", car.getCarReg());
        carDetails.put("engineSize", car.getEngSize());

        return carDetails;
    }


}
