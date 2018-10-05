package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.Mongo.ReadDB;

public class TrainingProjectReader {

    public static void main(String[] args) {

        String dbName = "myMongoDb";
        String dbCollection = "profiles";
        int numberDisplayed = 10;
        ReadDB db = new ReadDB();
        db.readAllProfiles(dbName, dbCollection);
        //db.readLastProfiles(dbName, dbCollection, numberDisplayed);
        //db.carModelSearch(dbName, dbCollection, "BMW");
        //db.postCodeSearch(dbName, dbCollection, "79");
        //db.copyAddress(dbName, dbCollection);
    }
}
