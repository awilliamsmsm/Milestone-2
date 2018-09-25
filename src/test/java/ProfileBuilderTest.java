import com.moneysupermarket.milestone2.ProfileBuilder;
import com.moneysupermarket.milestone2.domain.Address;
import com.moneysupermarket.milestone2.domain.CarDetails;
import com.moneysupermarket.milestone2.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileBuilderTest {

    @Test
    public void testProfileBuilder() {
       //Arrange
       //Make com.moneysupermarket.milestone2.domain.User object
       //make a test String
        Address add = new Address("57", "Spring Gardens", "Manchester", "Manchester", "M2 2BY");
        CarDetails car = new CarDetails("MS68 MSM", "Audi", "R8", 5.2);
        User userTest = new User("Money", "Supermarket", add, car);
        ProfileBuilder profile = new ProfileBuilder();
        String userProf = "Money,Supermarket,57,Spring Gardens,Manchester,Manchester,M2 2BY,MS68 MSM,Audi,R8,5.2";

        //Act
        // Calling the profile builder method - passing in String and interger

        User userResult = profile.build(userProf);

       //Assert
        //Assert equals that Object matches your test String, match each item in the Object
        assertEquals(userResult.getFirstName(), userTest.getFirstName());
        assertEquals(userResult.getLastName(), userTest.getLastName());
        assertEquals(userResult.getAddress().getHouseNumber(), userTest.getAddress().getHouseNumber());
        assertEquals(userResult.getAddress().getStreet(), userTest.getAddress().getStreet());
        assertEquals(userResult.getAddress().getTown(), userTest.getAddress().getTown());
        assertEquals(userResult.getAddress().getCity(), userTest.getAddress().getCity());
        assertEquals(userResult.getAddress().getPostCode(), userTest.getAddress().getPostCode());
        assertEquals(userResult.getCar().getCarReg(), userTest.getCar().getCarReg());
        assertEquals(userResult.getCar().getCarMake(), userTest.getCar().getCarMake());
        assertEquals(userResult.getCar().getCarModel(), userTest.getCar().getCarModel());
        assertEquals(userResult.getCar().getEngSize(), userTest.getCar().getEngSize());

        //assertEquals(userResult.getCar(), userTest.getCar());




    }

    @Test
    public void testMissingData(){
        ProfileBuilder profile = new ProfileBuilder();
        String userProf = "Money,Supermarket,57,Spring Gardens,Manchester,Manchester,M2 2BY,MS68 MSM,Audi,R8";
        User userResult = profile.build(userProf);

        assertNull(userResult);

    }



}