package com.moneysupermarket.milestone2.Mongo;

import com.moneysupermarket.milestone2.domain.Address;
import com.moneysupermarket.milestone2.domain.CarDetails;
import com.moneysupermarket.milestone2.domain.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;

import java.util.ArrayList;
import java.util.List;

public class ReadDB {
    private final MongoCollection<BasicDBObject> mongoCollection;
    private List<User> users = new ArrayList<>();
    public ReadDB(MongoCollection<BasicDBObject> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public List<User> readAllProfiles() {
        FindIterable<BasicDBObject> profiles = mongoCollection.find();

        for (BasicDBObject profile : profiles) {
            //System.out.println(profile);
            users.add(convertToUser(profile));
        }
        return users;
    }

    public List<User> readLastProfiles(int lastNumber) {
        FindIterable<BasicDBObject> profiles = mongoCollection.find().sort(new BasicDBObject("_id", -1)).limit(lastNumber);

        for (BasicDBObject profile : profiles) {
            users.add(convertToUser(profile));
        }
        return users;
    }

    public List<User> carModelSearch(String carMake) {
        BasicDBObject query = new BasicDBObject();
        query.put("car.make", carMake);
        FindIterable<BasicDBObject> profiles = mongoCollection.find(query);

        for (BasicDBObject profile : profiles) {
            users.add(convertToUser(profile));
        }
        return users;
    }

    public List<User> postCodeSearch(String postCode) {
        String postCodeRegex = "^" + postCode + ".*";
        BasicDBObject query = new BasicDBObject();
        query.put("address.postCode", new BasicDBObject("$regex", postCodeRegex).append("$options", "i"));

        FindIterable<BasicDBObject> profiles = mongoCollection.find(query);
        for (BasicDBObject profile : profiles) {
            users.add(convertToUser(profile));
        }
        return users;
    }

    public void copyAddress(String dbName) {
        FindIterable<BasicDBObject> profiles = mongoCollection.find();
        ArrayList<BasicDBObject> addresses = new ArrayList<>();

        for (BasicDBObject profile : profiles) {
            BasicDBObject address = ((BasicDBObject) profile.get("address"));
            addresses.add(address);
        }
        WriteAddress addressWrite = new WriteAddress();
        addressWrite.writeAddressToDB(addresses, dbName);
    }

    private User convertToUser(BasicDBObject basicDBObject) {
        CarDetails carDetails = convertToCarDetails(basicDBObject);
        Address address = convertToAddress(basicDBObject);
        return new User(basicDBObject.getString("firstName"),
                basicDBObject.getString("lastName"),
                address,
                carDetails
        );
    }

    private CarDetails convertToCarDetails(BasicDBObject basicDBObject) {

        BasicDBObject car = (BasicDBObject)basicDBObject.get("car");

        return new CarDetails(car.getString("carRegistration"),
                car.getString("make"),
                car.getString("model"),
                car.getDouble("engineSize",0)
        );
    }

    private Address convertToAddress(BasicDBObject basicDBObject) {

        BasicDBObject address = (BasicDBObject)basicDBObject.get("address");

        return new Address(address.getString("houseNumber"),
                address.getString("street"),
                address.getString("town"),
                address.getString("city"),
                address.getString("postCode")
        );
    }
}
