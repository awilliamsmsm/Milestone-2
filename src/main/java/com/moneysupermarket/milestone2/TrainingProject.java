package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.AppRunners.MyApp;

public class TrainingProject {
    //public static ConnectMongoDB mongoConnection = new ConnectMongoDB();
    public final static String BASE_PATH = "src/main/resources/CSV/";

    public static void main(String[] args) {
        if (args.length == 3){
            MyApp.runApp(args[0], args[1], args[2]);
        }
        else{
            System.out.println("Invalid number of arguments");
        }
    }
}

