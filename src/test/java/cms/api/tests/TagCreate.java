package cms.api.tests;
/**
 * Created by npletnyova on 14.06.2017.
 */

import cms.utils.RandomIdHelper;
import cms.utils.RandomUserHelper;
import cms.utils.objects.UserTag;
import cms.utils.objects.User;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TagCreate extends BaseTest {
    private static RandomIdHelper randomIdHelper;
    private static RandomUserHelper randomUserHelper;

    public String uid;
    public int userId;
    UserTag userTag = new UserTag();
    User user = new User();


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

        userTag.setId(uid);

        if (uid != null) {
            given().spec(requestSpec).body(userTag).when().put("tags/1").then().spec(responseSpec);
        } else {
            System.out.println("Error!");
        }
    }


    @Test
    public void putTagToUser() { // add tag from createTag to random user from RandomUserHelper
        user.setUserId(userId);
        user.setTag(uid);
        if (userId != 0 && userId > 0) {

            given().spec(requestSpec).body(user).when().put("/usertags").then().spec(responseSpec);
        } else {
            System.out.println("Unable to get userId!" + userId);
        }

    }
}





