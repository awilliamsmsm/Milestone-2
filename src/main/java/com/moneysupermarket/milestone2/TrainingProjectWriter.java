package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.AppRunners.MyApp;

public class TrainingProjectWriter {
    public final static String BASE_PATH = "src/main/resources/CSV/";

    public static void main(String[] args) {
        MyApp myAppWriter = new MyApp();
        if (args.length == 3){
            myAppWriter.runApp(args[0], args[1], args[2]);
        }
        else{
            System.out.println("Invalid number of arguments");
        }
    }
}

