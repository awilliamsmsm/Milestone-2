package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.Mongo.ReadDB;

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
//        ArrayList<User> users  = CSVToUserList.returnList();
//        MongoCollection<BasicDBObject> collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
//        MongoWriter.writeDocumentsToMongo(users, collection);
        ReadDB db = new ReadDB();
        //db.readAllProfiles(dbName, dbCollection);
        db.postCodeSearch(dbName, dbCollection, "79");
        //db.readLastProfiles(dbName, dbCollection);
        //db.carModelSearch(dbName, dbCollection, "BMW");
    }
}

