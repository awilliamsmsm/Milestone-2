package com.moneysupermarket.milestone2.handleCSV;

import com.moneysupermarket.milestone2.ProfileBuilder;
import com.moneysupermarket.milestone2.domain.User;

import java.util.ArrayList;
import java.util.List;

public class CSVToUserList {

    public static ArrayList<User> userList = new ArrayList<>();

    public static void addToList(User user){
        userList.add(user);
    }

    public ArrayList<User> stringToUser(List<String> userListString){
        ProfileBuilder profileBuilder = new ProfileBuilder();
        for (String rawUserString : userListString){
            User user = profileBuilder.build(rawUserString);
            addToList(user);
        }
        return userList;
    }

//    public static ArrayList<User> returnListOfUsers(){
//        return userList;
//    }


}
