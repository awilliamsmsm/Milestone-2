package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.domain.User;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadCSV {
    public void readCSV(String filePath){
        String file = filePath;
        String line;
        ProfileBuilder profileBuilder = new ProfileBuilder();

//        String dbName = "myMongoDb";
//        String dbCollection = "profiles";
//        MongoCollection collection = ConnectMongoDB.connectMongoDB(dbName, dbCollection);
        int i = 1;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            while((line = br.readLine()) != null){
                User user = profileBuilder.build(line);
                CSVToUserList.addToList(user);//, i);
                i++;
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
