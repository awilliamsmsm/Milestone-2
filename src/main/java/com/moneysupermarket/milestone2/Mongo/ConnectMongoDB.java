package com.moneysupermarket.milestone2.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class ConnectMongoDB {

    public static MongoCollection<BasicDBObject> connectMongoDB(String dbName, String dbCollection){
        String name = dbName;
        String collectionName = dbCollection;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase(name);
        MongoCollection collection = database.getCollection(collectionName, BasicDBObject.class);
        return collection;

    }
//
//    public static MongoCollection<BasicDBObject> getMongoDB(String dbName, String dbCollection){
//        String name = dbName;
//        String collectionName = dbCollection;
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        return ;
//
//    }

}