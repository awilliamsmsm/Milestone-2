package com.moneysupermarket.milestone2.Mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;

import java.util.ArrayList;

public class ReadDB {

    public static void readAllProfiles(String dbName, String dbCollection){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        FindIterable<BasicDBObject> profiles = collection.find();

        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }

    }

    public static void readLastProfiles(String dbName, String dbCollection, int lastNumber){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        FindIterable<BasicDBObject> profiles = collection.find().sort(new BasicDBObject("_id", -1)).limit(10);
        System.out.println((profiles));

        for (BasicDBObject profile :   profiles) {
            System.out.println(profile);
        }
    }

    public static void carModelSearch(String dbName, String dbCollection, String carMake){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        BasicDBObject query = new BasicDBObject();
        query.put("car.make", carMake);
        FindIterable<BasicDBObject> profiles = collection.find(query);

        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }
    }

    public static void postCodeSearch(String dbName, String dbCollection, String postCode){
        String postCodeRegex= "^" + postCode + ".*";
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        BasicDBObject query = new BasicDBObject();
        query.put("address.postCode", new BasicDBObject("$regex", postCodeRegex).append("$options", "i"));

        FindIterable<BasicDBObject> profiles = collection.find(query);
        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }

    }

    public static void copyAddress(String dbName, String dbCollection){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        FindIterable<BasicDBObject> profiles = collection.find();
        ArrayList<BasicDBObject> addresses = new ArrayList<>();

        for (BasicDBObject profile : profiles) {
            BasicDBObject address = ((BasicDBObject)profile.get("address"));
            addresses.add(address);
        }
        WriteAddress addressWrite = new WriteAddress();
        addressWrite.writeAddressToDB(addresses, dbName);
    }
}
