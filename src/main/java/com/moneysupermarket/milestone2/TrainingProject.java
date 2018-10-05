package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.Mongo.ConnectMongoDB;
import com.moneysupermarket.milestone2.Mongo.MongoWriter;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

public class TrainingProject {
    public final static String BASE_PATH = "/Users/alistair.williams/Documents/";

    public static void main(String[] args) {
        String folder = "Data Document/";
        String fileName = "MOCK_DATA.csv";
        String file = BASE_PATH + folder + fileName;
        ReadCSV file1 = new ReadCSV();
        file1.readCSV(file);

        String dbName = "myMongoDb";
        String dbCollection = "profiles";
        ArrayList<User> users  = CSVToUserList.returnList();
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        MongoWriter.writeDocumentsToMongo(users, collection);
    }
}

