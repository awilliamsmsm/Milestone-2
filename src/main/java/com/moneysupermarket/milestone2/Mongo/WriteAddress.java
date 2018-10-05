package com.moneysupermarket.milestone2.Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

public class WriteAddress {

    public static void writeAddressToDB(ArrayList<BasicDBObject> addresses, String dbName){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, "addresses");
        collection.insertMany(addresses);
    }
}
