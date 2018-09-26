package com.moneysupermarket.milestone2;

import com.moneysupermarket.milestone2.domain.User;

import java.util.ArrayList;

public class CSVToUserList {

    public static ArrayList<User> userList = new ArrayList<>();

    public static void addToList(User user){
        userList.add(user);
    }

    public static ArrayList<User> returnList(){
        return userList;
    }


}
