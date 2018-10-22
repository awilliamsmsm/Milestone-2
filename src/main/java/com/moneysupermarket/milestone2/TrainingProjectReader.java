package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.AppRunners.MyAppReader;

public class TrainingProjectReader {

    public static void main(String[] args) throws Exception{
        int argsLength = args.length;

        if (argsLength < 3) {
            System.out.println("Invalid number of arguments");
            return;
        }

        MyAppReader myAppReader = new MyAppReader(args[0], args[1]);

        switch (argsLength) {
            case 3:
                myAppReader.runAppReader(args[2], null);
                break;
            case 4:
                myAppReader.runAppReader(args[2], args[3]);
                break;
            default:
                System.out.println("Invalid number of arguments");
                break;
        }

    }
}
