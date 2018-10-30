package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReadDBTest {
    private ReadDB readDB;


    private Mongo mongo;
    @Mock
    private MongoCollection<BasicDBObject> mockCollection;
    @Mock
    private FindIterable<BasicDBObject> profiles;
    @Mock
    private BasicDBObject basicDBObject;
    @Mock
    private MongoCursor<BasicDBObject> basicDBObjectIt;

    @InjectMocks
    private ReadDB mockReader;

    @Before
    public void initMocks() {

        MockitoAnnotations.initMocks(this);
        this.mockReader = new ReadDB(mockCollection);


    }

    @Test
    public void readAllProfiles() {
        when(mockCollection.find()).thenReturn(profiles);
        when(profiles.iterator()).thenReturn(basicDBObjectIt);
        when(basicDBObjectIt.hasNext()).thenReturn(true, false);
        when(basicDBObjectIt.next()).thenReturn(basicDBObject);

//        List<User> mockUsers =
        mockReader.readAllProfiles();

        //System.out.println(mockUsers);
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