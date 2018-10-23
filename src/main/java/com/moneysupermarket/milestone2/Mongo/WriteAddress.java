package com.moneysupermarket.milestone2.Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

public class WriteAddress {

    public static void writeAddressToDB(ArrayList<BasicDBObject> addresses, String dbName){
        ConnectMongoDB addressesToDB = new ConnectMongoDB();
        MongoCollection<BasicDBObject> collection = addressesToDB.connectMongoDB(dbName, "addresses");
        collection.insertMany(addresses);
    }
}
