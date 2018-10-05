package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.CSVToUserList;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ReadDB {

    public void readAllProfiles(String dbName, String dbCollection){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        FindIterable<BasicDBObject> profiles = collection.find();

        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }

    }

    public void readLastProfiles(String dbName, String dbCollection, int lastNumber){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        FindIterable<BasicDBObject> profiles = collection.find().sort(new BasicDBObject("_id", -1)).limit(10);
        System.out.println((profiles));

        for (BasicDBObject profile :   profiles) {
            System.out.println(profile);
        }
    }

    public void carModelSearch(String dbName, String dbCollection, String carMake){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        BasicDBObject query = new BasicDBObject();
        query.put("car.make", carMake);
        FindIterable<BasicDBObject> profiles = collection.find(query);

        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }
    }

    public void postCodeSearch(String dbName, String dbCollection, String postCode){
        String postCodeRegex= "^" + postCode + ".*";
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        BasicDBObject query = new BasicDBObject();
        query.put("address.postCode", new BasicDBObject("$regex", postCodeRegex).append("$options", "i"));

        FindIterable<BasicDBObject> profiles = collection.find(query);
        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }

    }

    public void copyAddress(String dbName, String dbCollection){
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
