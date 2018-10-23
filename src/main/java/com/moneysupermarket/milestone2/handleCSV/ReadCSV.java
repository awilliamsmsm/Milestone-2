package com.moneysupermarket.milestone2.handleCSV;

import com.moneysupermarket.milestone2.ProfileBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadCSV {
    public List<String> readCSV(String filePath){
        String file = filePath;
        try (Stream<String> stream = Files.lines(Paths.get(file)).skip(1)){
            List<String> userLines = stream.collect(Collectors.toList());
            //CSVToUserList.stringToUser(userLines);
            return userLines;
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }

    }

}
