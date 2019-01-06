package cms.api.tests;


import cms.utils.GenerateEmail;
import cms.utils.GeneratePhone;

import cms.utils.UserHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserTest extends BaseTest {
    UserHelper userHelper = new UserHelper();


    @BeforeClass
    public void generateUserData() {
        GeneratePhone generatePhone = new GeneratePhone();
        phone = generatePhone.generatePhone();
        GenerateEmail generateEmail = new GenerateEmail();
        email = generateEmail.generate();
    }


    @Test
    public void shouldCreateUser() {
        Object user = userHelper.createUser(firstName, lastName, email,phone,password, null);
        given(requestSpec).body(user).when().post("api/rest-auth/register/").then().assertThat().statusCode(400);
        Object user1= userHelper.createUser(null, lastName, email,phone, password, null);
        given(requestSpec).body(user1).when().post("api/rest-auth/register/").then().assertThat().statusCode(400);
        Object user2= userHelper.createUser(firstName,lastName, email, null, password, null);
        given(requestSpec).body(user2).when().post("api/rest-auth/register/").then().assertThat().statusCode(400);
        Object user3= userHelper.createUser(null, lastName, email, null, password, null);
        given(requestSpec).body(user3).when().post("api/rest-auth/register/").then().assertThat().statusCode(400);
        Object user4= userHelper.createUser(null, lastName, email, null, password, null);
        given(requestSpec).body(user4).when().post("api/rest-auth/register/").then().assertThat().statusCode(400);
        Object userConfirmation = userHelper.createUser(firstName, lastName, email, phone, password, code);
        given(requestSpec).body(userConfirmation).when().post("api/rest-auth/register/complete/").then();

    }


}



