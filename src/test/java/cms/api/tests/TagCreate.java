package cms.api.tests;
/**
 * Created by npletnyova on 14.06.2017.
 */

import cms.utils.RandomIdHelper;
import cms.utils.RandomUserHelper;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.sun.javafx.fxml.expression.Expression.notEqualTo;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class TagCreate {
    private static String uri = "http://pre-cms.spb.play.dc/";
    private static String username = "npletnyova";
    private static String pwd = "Nata9756m##";
    private static RandomIdHelper randomIdHelper;
    private static RandomUserHelper randomUserHelper;
    public String uid;
    public int userId;


    @BeforeTest
    public String generateUid() { // show uid from RandomIdHelper
        randomIdHelper = new RandomIdHelper();
        uid = randomIdHelper.generateRandomId();
        return uid;
    }

    public int generateUser() {
        randomUserHelper = new RandomUserHelper();
        userId = randomUserHelper.generateRandomUser();
        return userId;
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
                    .baseUri(uri)
                    .contentType("application/json;charset=utf-8")
                    .body(myJsonTag).log().all()
                    .auth().preemptive().basic(username, pwd)
                    //.expect().body(uid,  notEqualTo(0))
                    .when().put("tags/1")
                    .then().log().all().statusCode(200);
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
                    .baseUri(uri)
                    .contentType("application/json;charset=utf-8")
                    .body(myJsonUserTag).log().all()
                    .auth().preemptive().basic(username, pwd)
                    //.expect().body(userId,  notEqualTo(0))
                    .when().put("/usertags")
                    .then().log().all().statusCode(200);
        } else {
            System.out.println("Error2!");
        }
    }
}





