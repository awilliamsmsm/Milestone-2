package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.AppRunners.MyAppReader;

public class TrainingProjectReader {

    public static void main(String[] args) {
        int argsLength = args.length;

        switch(argsLength){
            case 3:     MyAppReader.runAppReader(args[0], args[1], args[2]);
                        break;
            case 4:     MyAppReader.runAppReader(args[0], args[1], args[2], args[3]);
                        break;
            default:    System.out.println("Invalid number of arguments");
                        break;
        }

    }
}
