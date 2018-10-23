package com.moneysupermarket.milestone2.AppRunners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moneysupermarket.milestone2.Mongo.ConnectMongoDB;
import com.moneysupermarket.milestone2.Mongo.ReadDB;
import com.moneysupermarket.milestone2.domain.User;

//import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyAppReader {
    private final static String missingFilterArgumentMessage = "Missing filter argument";
    private final ReadDB readDB;
    private final String dbName;
    private final ObjectMapper objectMapper;
    private List<User> userList = new ArrayList<>();

    public MyAppReader(String dbName, String dbCollection) {
        ConnectMongoDB dbReader = new ConnectMongoDB();
        this.readDB = new ReadDB(dbReader.connectMongoDB(dbName, dbCollection));
        this.dbName = dbName;
        this.objectMapper = new ObjectMapper();
    }

    public void runAppReader(String readType, String filterField)  throws Exception{
        switch (readType) {
            case "ReadAll":
                userList = readDB.readAllProfiles();
                printUsers(userList);
                break;

            case "CopyAddresses":
                readDB.copyAddress(dbName);
                break;

            case "LastX":
            case "CarMakeFilter":
            case "PostCodeFilter":
                runAppReaderWithFilter(readType, filterField);
                break;

            default:
                System.out.println(readType + " is not a valid argument");
                break;
        }
    }

    private void runAppReaderWithFilter(String readType, String filterField) throws Exception {
        if (filterField == null) {
            System.out.println(missingFilterArgumentMessage);
            return;
        }
        switch (readType) {
            case "LastX":
                Integer numberOfProfilesDisplayed = Integer.parseInt(filterField);
                userList = readDB.readLastProfiles(numberOfProfilesDisplayed);
                printUsers(userList);
                break;

            case "CarMakeFilter":
                userList = readDB.carModelSearch(filterField);
                printUsers(userList);
                break;

            case "PostCodeFilter":
                userList = readDB.postCodeSearch(filterField);
                printUsers(userList);
                break;
        }
    }

    private void printUsers(List<User> users) throws Exception{
        for (User user : users)
            System.out.println(objectMapper.writeValueAsString(user));
    }
}
