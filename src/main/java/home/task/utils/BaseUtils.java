package home.task.utils;

import home.task.utils.api.calls.ApiCalls;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseUtils {


    public ApiCalls apiCalls = new ApiCalls();

    /**
     * set base uri and base path to the RestAssured
     */
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        RestAssured.baseURI = "https://dummy.restapiexample.com";
        RestAssured.basePath = "/api/v1/";

    }

}
