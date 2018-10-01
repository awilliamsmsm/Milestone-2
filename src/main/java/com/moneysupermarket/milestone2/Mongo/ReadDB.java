package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.CSVToUserList;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;

import java.util.ArrayList;

public class ReadDB {

    public void readAllProfiles(String dbName, String dbCollection){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);

        FindIterable<BasicDBObject> profiles = collection.find();

        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }

    }


    public void readLastProfiles(String dbName, String dbCollection){//}, int lastNumber){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        FindIterable<BasicDBObject> profiles = collection.find().sort(new BasicDBObject("_id", -1)).limit(10);
        System.out.println((profiles));
        //collection.find();
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




        //MongoCursor<BasicDBObject> profiles = collection.find().iterator();

        //String profile = profiles.toString();
        //System.out.println(profile);
//        while(profiles.hasNext()){
//            String profile = profiles.next().toString();
//            System.out.println(profile);
//        }
        //BasicDBObject topQuery = new BasicDBObject();
//        BasicDBObject query = new BasicDBObject();
//        query.put("car.make", "BMW");
//        //topQuery.put("car", query);
//        MongoCursor<BasicDBObject> profiles = collection.find(query).iterator();
//        while (profiles.hasNext()){
//            String profile = profiles.next().toString();
//            System.out.println(profile);
//        }




}
