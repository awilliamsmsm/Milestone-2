package com.moneysupermarket.milestone2.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class ConnectMongoDB {



    //public MongoCollection collection;

    //public static ConnectMongoDB mongoConnection = new ConnectMongoDB();

    public static MongoCollection connectMongoDB(String dbName, String dbCollection){
        String name = dbName;
        String collectionName = dbCollection;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase(name);
        MongoCollection collection = database.getCollection(collectionName, BasicDBObject.class);
        //this.setCollection(collection);
        return collection;

    }

//    public void setCollection(MongoCollection collection) {
//        this.collection = collection;
//    }
//
//    public MongoCollection getCollection() {
//        return collection;
//    }
//    public static MongoCollection<BasicDBObject> connectMongoDBAddress(String dbName, String dbCollection) {
//        String name = dbName;
//        String collectionName = dbCollection + ".address";
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase database = mongoClient.getDatabase(name);
//        MongoCollection collection = database.getCollection(collectionName, BasicDBObject.class);
//        return collection;
//    }
//
//    public static MongoDatabase getMongoDB(String dbName, String dbCollection){
//        String name = dbName;
//        String collectionName = dbCollection;
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase database = mongoClient.getDatabase(name);
//        return database;
//
//    }

}