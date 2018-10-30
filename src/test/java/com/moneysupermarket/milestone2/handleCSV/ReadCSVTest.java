package com.moneysupermarket.milestone2.handleCSV;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReadCSVTest {

    @Test
    public void reutrnsStringList(){
        ReadCSV testReadCSV = new ReadCSV();
        List<String> testList = testReadCSV.readCSV("src/test/resources/CSV/TEST_DATA.csv");

        String user1String =  "Erminie,McCluney,97,Heffernan,Grand Junction,Colorado,81505,3N1BC1AP5BL916571,Saab,9000,3.8";
        assertEquals(testList.get(0), user1String);
    }

}