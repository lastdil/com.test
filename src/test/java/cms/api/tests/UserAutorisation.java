package cms.api.tests;


import cms.utils.GenerateEmail;
import cms.utils.GeneratePhone;

import cms.utils.UserHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserAutorisation extends BaseTest {
    UserHelper userHelper = new UserHelper();


    @BeforeClass
    public void generateUserData() {
        GeneratePhone generatePhone = new GeneratePhone();
        phone = generatePhone.generatePhone();
        GenerateEmail generateEmail = new GenerateEmail();
        email = generateEmail.generate();
    }

    @DataProvider(name = "createData")
    public Object[][] createData() {
        return new Object[][]{
                new Object[]{userHelper.createUser(null, lastName, email, phone, password, null)},
                new Object[]{userHelper.createUser(firstName, null, email, phone, password, null)},
                new Object[]{userHelper.createUser(firstName, lastName, null, phone, password, null)},
                new Object[]{userHelper.createUser(firstName, lastName, email, null, password, null)},
                new Object[]{userHelper.createUser(firstName, lastName, email, phone, null, null)},
                new Object[]{userHelper.createUser(firstName, lastName, email, phone, null, null)}
        };
    }

    @Test(dataProvider = "createData")
    public void shouldCreateUser(Object createData) {
        given(requestSpec).body(createData).when().post("api/rest-auth/register/").then().assertThat().statusCode(400);
    }

    @Test
    public void shouldCreateUser() {
        Object user = userHelper.createUser(firstName, lastName, email, phone, password, null);
        given(requestSpec).body(user).when().post("api/rest-auth/register/").then();
        Object userConfirmation = userHelper.createUser(firstName, lastName, email, phone, password, code);
        given(requestSpec).body(userConfirmation).when().post("api/rest-auth/register/complete/").then();

    }

    @Test public void shouldCreateUser() {
        given().
                param("param1", "value1").
                param("param2", "value2").
                when().
                get("/something");
    }

}



