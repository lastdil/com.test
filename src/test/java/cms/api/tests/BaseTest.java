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

    public static RequestSpecBuilder builder;
    public static ResponseSpecBuilder builder1;
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;


    private final static String URI = "http://pre-cms.spb.play.dc/";


    @BeforeClass
    public static void setupRequestSpecBuilder() {
        builder = new RequestSpecBuilder()
                .addHeader("Authorization", "Basic bnBsZXRueW92YTpOYXRhOTc1Nm0jIw==")
                .setContentType(ContentType.fromContentType("application/json;charset=utf-8"))
                .setBaseUri(URI)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter());  //log request and response for better debugging. You can also only log if a requests fails.
        requestSpec = builder.build();
    }

    @BeforeMethod
    public static void setupResponseSpecBuilder() {
        builder1 = new ResponseSpecBuilder()

                .expectStatusCode(200);

        //builder1.expectBody(containsString("Your Website Title"));

        responseSpec = builder1.build();


    }


}



