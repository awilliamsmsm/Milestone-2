package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.CSVToUserList;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;

import java.util.ArrayList;

public class ReadDB {

    public void readInProfiles(String dbName, String dbCollection){
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);

        FindIterable<BasicDBObject> profiles = collection.find();
        for (BasicDBObject profile :   profiles){
            System.out.println(profile);
        }
    }


}
