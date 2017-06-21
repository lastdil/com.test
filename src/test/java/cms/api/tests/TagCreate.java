package cms.api.tests;
/**
 * Created by npletnyova on 14.06.2017.
 */

import cms.utils.RandomIdHelper;
import cms.utils.RandomUserHelper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TagCreate extends BaseTest {
    private static RandomIdHelper randomIdHelper;
    private static RandomUserHelper randomUserHelper;

    public String uid;
    public int userId;


    @BeforeClass
    public void generateUid() { // show uid from RandomIdHelper
        randomIdHelper = new RandomIdHelper();
        uid = randomIdHelper.generateRandomId();
        randomUserHelper = new RandomUserHelper();
        userId = randomUserHelper.generateRandomUser();


    }


    /**
     * @BeforeTest public void generateUidUser() { // show uid from RandomIdHelper
     * randomIdHelper = new RandomIdHelper();
     * uid = randomIdHelper.generateRandomId();
     * randomUserHelper = new RandomUserHelper();
     * userId = randomUserHelper.generateRandomUser();
     * }
     */

    @Test
    public void createTag() { // create tag with random id from RandomIdHelper ("id":"uid")
        String myJsonTag = "{\n" +
                " \"id\": \"" + uid + "\" \n" + "}";
        if (uid != null && !uid.isEmpty()) {
            given()
                    .spec(requestSpec)
                    .body(myJsonTag)
                    .when().put("tags/1")
                    .then().spec(responseSpec);
        } else {
            System.out.println("Error!");
        }
    }


    @Test
    public void putTagToUser() { // add tag from createTag to random user from RandomUserHelper
        String myJsonUserTag = "{\n" +
                " \"userId\": \"" + userId + "\", \n" +
                " \"tag\": \"" + uid + "\"\n" +
                "}";
        if (userId != 0) {

            given()
                    .spec(requestSpec)
                    .body(myJsonUserTag)
                    .when().put("/usertags")
                    .then().spec(responseSpec);
        } else {
            System.out.println("Error2!");
        }

    }
}





