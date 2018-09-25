package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.Mongo.ConnectMongoDB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class TrainingProject {
    public final static String BASE_PATH = "/Users/alistair.williams/Documents/";

    public static void main(String[] args) {

        String dbName = "userProfiles";
        String dbCollection = "profiles";
        ConnectMongoDB database = new ConnectMongoDB();
        database.connectMongoDB(dbName, dbCollection);

        String folder = "Data Document/";
        String fileName = "MOCK_DATA.csv";
        String file = BASE_PATH + folder + fileName;
        ReadCSV file1 = new ReadCSV();
        file1.readCSV(file);

        //https://github.com/awilliamsmsm/Milestone-2.git

        //String firstName = "Alistair";
        //String lastName = "Williams";


//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        //mongoClient.getDatabaseNames().forEach(System.out::println);
//        MongoDatabase database = mongoClient.getDatabase("myMongoDb");
//       // database.createCollection("customers", null);
//        MongoCollection collection = database.getCollection("customers", BasicDBObject.class);
//        BasicDBObject document = new BasicDBObject();
//        document.put("firstName", "df");
//        document.put("lastName", "Bdffdob");
//
//        collection.insertOne(document);




//            for (int i = 1; i <= 3; i++) {
//                if (i ==1) {
//                    com.moneysupermarket.milestone2.domain.Address add = new com.moneysupermarket.milestone2.domain.Address(57, "Spring Gardens", "Manchester", "Manchester", "M2 2BY");
//                    com.moneysupermarket.milestone2.domain.CarDetails car = new com.moneysupermarket.milestone2.domain.CarDetails("MS68 MSM", "Audi", "R8", "5.2");
//                    com.moneysupermarket.milestone2.domain.User user = new com.moneysupermarket.milestone2.domain.User("Money", "Supermarket", add, car);
//                    com.moneysupermarket.milestone2.PrintToFile.printToFile(user, i);
//                }
//                else if (i == 2){
//                    com.moneysupermarket.milestone2.domain.Address add = new com.moneysupermarket.milestone2.domain.Address(6, "Oldham Road", "Manchester", "Manchester", "M4 5DB");
//                    com.moneysupermarket.milestone2.domain.CarDetails car = new com.moneysupermarket.milestone2.domain.CarDetails("BDW 816", "Vauxhall", "Corsa SXI", "1.6");
//                    com.moneysupermarket.milestone2.domain.User user = new com.moneysupermarket.milestone2.domain.User("Alistair", "Williams", add, car);
//                    com.moneysupermarket.milestone2.PrintToFile.printToFile(user, i);
//                }
//                else if (i == 3) {
//                    com.moneysupermarket.milestone2.domain.Address add = new com.moneysupermarket.milestone2.domain.Address(101, "Long Road", "Place Town", "Big City", "C4 21OL");
//                    com.moneysupermarket.milestone2.domain.CarDetails car = new com.moneysupermarket.milestone2.domain.CarDetails("NU56 4MB", "VW", "Golf", "2");
//                    com.moneysupermarket.milestone2.domain.User user = new com.moneysupermarket.milestone2.domain.User("Person", "Three", add, car);
//                    com.moneysupermarket.milestone2.PrintToFile.printToFile(user, i);
//
//                }


    }
}

