package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.Mongo.ConnectMongoDB;
import com.moneysupermarket.milestone2.Mongo.MongoWriter;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import java.util.ArrayList;

public class TrainingProject {
    public final static String BASE_PATH = "/Users/alistair.williams/Documents/";

    public static void main(String[] args) {
        String folder = "Data Document/";
        String fileName = "MOCK_DATA.csv";
        String file = BASE_PATH + folder + fileName;
        ReadCSV file1 = new ReadCSV();
        file1.readCSV(file);

        ArrayList<User> users  = CSVToUserList.returnList();
        MongoWriter.writeDocumentsToMongo(users);



    }
}

