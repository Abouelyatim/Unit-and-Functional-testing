package com.example.test;

import com.example.model.City;
import com.example.service.DatabaseConnection;
import com.example.service.DatabaseService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.sql.Connection;

import static org.junit.Assert.*;


public class DatabaseServiceTest {

    DatabaseConnection dbconnection;
    Connection conn;
    City city;
    DatabaseService dbservice=new DatabaseService();;


    @Before
    public void setUp() throws Exception {
         dbconnection=new DatabaseConnection("sa","", "org.h2.Driver", "jdbc:h2:mem:test");
         conn=dbconnection.connect();
         dbconnection.createDb(conn);

    }

    @After
    public void tearDown() throws Exception {
        dbconnection.disconnect(conn);
    }

    @org.junit.Test
    public void addCity() throws Exception {
        city=new City(100,"alger",400,"alger alger");
        Assert.assertEquals(dbservice.addCity(conn,city),1);

    }

    @org.junit.Test
    public void getCity() throws Exception {
        city=new City(100,"alger",400,"alger alger");
        dbservice.addCity(conn,city);
        Assert.assertEquals(DatabaseService.getCity(conn,100),city);
    }

}