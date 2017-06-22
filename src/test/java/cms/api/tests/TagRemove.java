package cms.api.tests;

import cms.utils.RandomIdHelper;
import cms.utils.RandomUserHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by npletnyova on 15.06.2017.
 */

public class TagRemove extends BaseTest {
    public String uid;
    public int userId;
    private static RandomIdHelper randomIdHelper;
    private static RandomUserHelper randomUserHelper;


    @BeforeClass
    public void writeUid() {
        randomIdHelper = new RandomIdHelper();
        uid = randomIdHelper.generateRandomId();
        randomUserHelper = new RandomUserHelper();
        userId = randomUserHelper.generateRandomUser();
    }


    @Test
    public void deleteTagFromUser() { // delete all tags from specified user

        given()
                .spec(requestSpec)
                .when().delete("/usertags/user/{userId}", userId)
                .then().spec(responseSpec);
    }

    @Test
    public void deleteTag() { //delete item by id and schemaVersion
        given()
                .spec(requestSpec)
                .when().delete("/tags/1/{id}", uid)
                .then().spec(responseSpec);

    }
}

