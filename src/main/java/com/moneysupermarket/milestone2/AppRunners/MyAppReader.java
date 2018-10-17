package com.moneysupermarket.milestone2.AppRunners;

import com.moneysupermarket.milestone2.Mongo.ReadDB;

public class MyAppReader {

    public static void runAppReader(String dbName, String dbCollection, String readType){
        String missingFilterArgumentMessage = "Missing filter argument";
        switch(readType){
            case "ReadAll":         ReadDB.readAllProfiles(dbName, dbCollection);
                                    break;

            case "CopyAddresses":   ReadDB.copyAddress(dbName, dbCollection);
                                    break;

            case "LastX":           System.out.println(missingFilterArgumentMessage);
                                    break;

            case "CarMakeFilter":   System.out.println(missingFilterArgumentMessage);
                                    break;

            case "PostCodeFilter":  System.out.println(missingFilterArgumentMessage);
                                    break;

            default:                System.out.println(readType + " is not a valid argument");
                                    break;
       }
    }

    public static void runAppReader(String dbName, String dbCollection, String readType, String filterField){
        switch(readType){
            case "ReadAll":         ReadDB.readAllProfiles(dbName, dbCollection);
                                    break;

            case "CopyAddresses":   ReadDB.copyAddress(dbName, dbCollection);
                                    break;

            case "LastX":           Integer numberOfProfilesDisplayed = Integer.parseInt(filterField);
                                    ReadDB.readLastProfiles(dbName, dbCollection, numberOfProfilesDisplayed);
                                    break;

            case "CarMakeFilter":   ReadDB.carModelSearch(dbName, dbCollection, filterField);
                                    break;

            case "PostCodeFilter":  ReadDB.postCodeSearch(dbName, dbCollection, filterField);
                                    break;

            default:                System.out.println(readType + " is not a valid argument");
                                    break;
       }
    }
}
