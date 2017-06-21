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


/**
 * Created by lastdil on 21/06/2017.
 */
public class BaseTest {

    public static RequestSpecBuilder builder;
    public static ResponseSpecBuilder builder1;
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;


    private final static String URI = "http://pre-cms.spb.play.dc/";


    @BeforeClass
    public static void setupRequestSpecBuilder() {
        builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", "Basic bnBsZXRueW92YTpOYXRhOTc1Nm0jIw==");
        builder.setContentType(ContentType.fromContentType("application/json;charset=utf-8"));
        builder.setBaseUri(URI);
        builder.addFilter(new RequestLoggingFilter());
        builder.addFilter(new ResponseLoggingFilter());  //log request and response for better debugging. You can also only log if a requests fails.
        requestSpec = builder.build();
    }

    @BeforeMethod
    public static void setupResponseSpecBuilder() {
        builder1 = new ResponseSpecBuilder();

        builder1.expectStatusCode(200);

        //builder1.expectBody(containsString("Your Website Title"));

        responseSpec = builder1.build();


    }


}



