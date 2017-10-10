package cms.api.tests;


import cms.utils.GenerateEmail;
import cms.utils.GeneratePhone;

import cms.utils.objects.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserTest extends BaseTest {


    @BeforeClass
    public void generateUserData() {
        GeneratePhone generatePhone = new GeneratePhone();
        phone = generatePhone.generatePhone();
        GenerateEmail generateEmail = new GenerateEmail();
        email = generateEmail.generate();
    }


    @Test
    public void shouldCreateUser() {
        User user = new User(firstName, lastName, email, phone, password, "");
        given(requestSpec).body(user).when().post("api/rest-auth/register/").then();


    }

    @Test(dependsOnMethods = "shouldCreateUser")
    public void shouldConfirmOtp() {
        User user = new User(firstName, lastName, email, phone, password, code);
        given(requestSpec).body(user).when().post("api/rest-auth/register/complete/").then().spec(responseSpec);
    }

}





