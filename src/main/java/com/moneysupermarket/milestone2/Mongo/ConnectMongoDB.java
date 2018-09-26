package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.ReadCSV;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.moneysupermarket.milestone2.TrainingProject.BASE_PATH;

public class ConnectMongoDB {

    public ConnectMongoDB(){

    }


    public static MongoCollection<BasicDBObject> connectMongoDB(String dbName, String dbCollection){
        String name = dbName;
        String collectionName = dbCollection;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase(name);
        MongoCollection collection = database.getCollection(collectionName, BasicDBObject.class);
        //BasicDBObject document = new BasicDBObject();
        return collection;

    }

}