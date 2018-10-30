package com.moneysupermarket.milestone2.AppRunners;


import com.moneysupermarket.milestone2.Mongo.ReadDB;
import com.moneysupermarket.milestone2.domain.Address;
import com.moneysupermarket.milestone2.domain.CarDetails;
import com.moneysupermarket.milestone2.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class  MyAppReaderTest {

    @Mock
    private ReadDB readDB;
    private List<User> mockUserList = new ArrayList<User>();

    private MyAppReader myAppReader;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        Address mockAddress = new Address("1","testStreet", "testTown", "testCity", "testPostCode");
        CarDetails mockCar = new CarDetails("testReg", "testMake", "testModel",1.0);
        User mockUser = new User("read", "all", mockAddress, mockCar);
        this.mockUserList.add(mockUser);
        this.myAppReader = new MyAppReader("Strign1", "string2");
        this.readDB = mock(ReadDB.class);
    }

    @Test
    public void testReadAll() {//throws Exception{
        when(readDB.readAllProfiles()).thenReturn(mockUserList);

        List<User> resultsList = readDB.readAllProfiles();

        System.out.println(resultsList.get(0).getFirstName() + " " + resultsList.get(0).getLastName());
        assertNotNull(resultsList);
        assertEquals(mockUserList, resultsList);
        assertEquals(mockUserList.get(0).getFirstName(), resultsList.get(0).getFirstName());
        assertEquals(mockUserList.get(0).getAddress().getPostCode(), resultsList.get(0).getAddress().getPostCode());
        assertEquals(mockUserList.get(0).getCar().getEngSize(), resultsList.get(0).getCar().getEngSize());
    }

    @Test
    public void testReadAllCall() throws Exception{
        when(readDB.readAllProfiles()).thenReturn(mockUserList);
        myAppReader.runAppReader("ReadAll", "sgdr");
        verify(readDB, times(1)).readAllProfiles();
        //verify
    }


}