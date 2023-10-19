package dataCreationFromModel;

import dataModel.UserP;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class UserDataCreator
{
    public static UserP user;
    public static Faker fake = new Faker();

    public UserP DataForUSerCreation() {
        user = new UserP();
        user.setId(fake.number().randomDigitNotZero());
        user.setUsername(fake.name().username());
        user.setFirstName(fake.name().firstName());
        user.setLastName(fake.name().lastName());
        user.setEmail(fake.internet().emailAddress());
        user.setPassword(fake.internet().password());
        user.setPhone(fake.phoneNumber().phoneNumber());
        user.setUserStatus("1");
        return user;
    }
    public List<UserP> createUser(long numberOfUsers){

        List<UserP> userPjoList = new ArrayList<>();

        for(int count=0;count<numberOfUsers;count++){

            userPjoList.add(DataForUSerCreation());
        }

        return userPjoList;
    }
}
