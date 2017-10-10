package cms.api.tests;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;

    String phone;
    String email;
    String code = "12345";
    final String firstName = "TestFirstName";
    final String lastName = "TestLastName";
    final String password = "123456";


    private final static String URI = "https://qa.cloudbridge.ru/";


    @BeforeClass
    public static void setupRequestSpecBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                //.addHeader("Authorization", "Basic bnBsZXRueW92YTpOYXRhOTc1Nm0jIw==")
                .setContentType(ContentType.fromContentType("application/json;charset=utf-8"))
                .setBaseUri(URI)
                .addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter());
        requestSpec = builder.build();
    }

    @BeforeMethod
    public static void setupResponseSpecBuilder() {
        ResponseSpecBuilder builder1 = new ResponseSpecBuilder().expectStatusCode(200);
        //builder1.expectBody(containsString("Your Website Title"));
        responseSpec = builder1.build();


    }


}



