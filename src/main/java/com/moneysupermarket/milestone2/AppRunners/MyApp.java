package com.moneysupermarket.milestone2.AppRunners;

import com.moneysupermarket.milestone2.Mongo.ConnectMongoDB;
import com.moneysupermarket.milestone2.Mongo.MongoWriter;
import com.moneysupermarket.milestone2.TrainingProject;
import com.moneysupermarket.milestone2.domain.User;
import com.moneysupermarket.milestone2.handleCSV.CSVToUserList;
import com.moneysupermarket.milestone2.handleCSV.ReadCSV;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;

public class MyApp {
    public static void runApp(String dbName, String dbCollectionName, String fileName){
        String filePath = TrainingProject.BASE_PATH + fileName;
        ReadCSV usersCSV = new ReadCSV();
        usersCSV.readCSV(filePath);

        ArrayList<User> users  = CSVToUserList.returnListOfUsers();
        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollectionName);
        MongoWriter.writeDocumentsToMongo(users, collection);
    }

}
