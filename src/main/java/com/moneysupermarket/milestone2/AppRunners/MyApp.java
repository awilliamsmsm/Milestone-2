package com.moneysupermarket.milestone2.AppRunners;

import com.moneysupermarket.milestone2.Mongo.ConnectMongoDB;
import com.moneysupermarket.milestone2.Mongo.MongoWriter;
import com.moneysupermarket.milestone2.TrainingProjectWriter;
import com.moneysupermarket.milestone2.domain.User;
import com.moneysupermarket.milestone2.handleCSV.CSVToUserList;
import com.moneysupermarket.milestone2.handleCSV.ReadCSV;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.List;

public class MyApp {
    public void runApp(String dbName, String dbCollectionName, String fileName){
        ReadCSV csvReader = new ReadCSV();
        String filePath = TrainingProjectWriter.BASE_PATH + fileName;
        List<String> userList = csvReader.readCSV(filePath);

        CSVToUserList convertToUser = new CSVToUserList();
        ArrayList<User> users = convertToUser.stringToUser(userList);

        ConnectMongoDB mongoConnection = new ConnectMongoDB();
        MongoCollection<BasicDBObject> collection = mongoConnection.connectMongoDB(dbName, dbCollectionName);
        MongoWriter writeUsersToDB = new MongoWriter();
        writeUsersToDB.writeDocumentsToMongo(users, collection);
    }
}
