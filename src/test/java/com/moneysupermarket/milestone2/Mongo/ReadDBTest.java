package com.moneysupermarket.milestone2.Mongo;

import com.mongodb.Mongo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadDBTest {
    private ReadDB readDB;

    private static final String DATABASE_NAME = "embedded";

    private Mongo mongo;

    @Before
    public void setup() {
        // setups mongodb test connection
        // puts some sample records in it
        // readDB = new ReadDb(mongoCollection);
    }

    @Test
    public void readAllProfiles() {
//        result = readDB.readAllProfiles();
//        assert values
    }

    @Test
    public void readLastProfiles() {
    }

    @Test
    public void carModelSearch() {
    }

    @Test
    public void postCodeSearch() {
    }

    @Test
    public void copyAddress() {
    }
}