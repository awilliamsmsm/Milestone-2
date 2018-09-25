package com.moneysupermarket.milestone2;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.moneysupermarket.milestone2.domain.User;

import static com.moneysupermarket.milestone2.TrainingProject.BASE_PATH;

public class PrintToFile {

    public static void printToFile(User user){//, Integer profNum){


        //String profileFilePath = BASE_PATH + "User Profiles/json2/";
       // String fileName = "userprofile " + Integer.toString(profNum) + ".json";
        //String file = profileFilePath + fileName;
//        ObjectMapper userMap = new ObjectMapper();
//        try {
//            userMap.writeValue(new File(file), user);
//            System.out.println("Done " + profNum);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

//    public static void printToTxt(com.moneysupermarket.milestone2.domain.User user, Integer profNum){
//        String filePath = "/Users/alistair.williams/Documents/com.moneysupermarket.milestone2.domain.User Profiles/json/";
//        String fileName = "userprofile " + Integer.toString(profNum) + ".txt";
//        String file = filePath + fileName;
//        try {
//            PrintWriter pw = new PrintWriter(file);
//            pw.println(output);
//            pw.close();
//            System.out.println("Done " + profNum);
//        }
//        catch(FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }

}
