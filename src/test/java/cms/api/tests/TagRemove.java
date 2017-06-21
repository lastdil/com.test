package cms.api.tests;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.BeforeTest;

/**
 * Created by npletnyova on 15.06.2017.
 */

public class TagRemove {
    private static String uri = "http://pre-cms.spb.play.dc/";
    private static String username = "npletnyova";
    private static String pwd = "Nata9756m##";
    public String uid;
    public int userId;
    private static TagCreate tagCreate;

    @BeforeTest
    public void writeUid() {
        tagCreate = new TagCreate();
        uid = tagCreate.generateUid();
        userId = tagCreate.generateUser();
    }


    @Test
    public void deleteTagFromUser() { // delete all tags from specified user

        given()
        .baseUri(uri)
        .contentType("application/json;charset=utf-8")
        .auth().preemptive().basic(username, pwd)
        .when().delete("/usertags/user/{userId}",userId)
        .then().log().all().statusCode(200);
    }

    @Test
    public void deleteTag(){ //delete item by id and schemaVersion
        given()
                .baseUri(uri)
                .contentType("application/json;charset=utf-8")
                .auth().preemptive().basic(username, pwd)
                // .expect().body(uid,  notNullValue())
                .when().delete("/tags/1/{id}", uid)
                .then().log().all().statusCode(200);

    }
}

