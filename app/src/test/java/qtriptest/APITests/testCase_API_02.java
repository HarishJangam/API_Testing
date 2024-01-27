package qtriptest.APITests;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
public class testCase_API_02 {

    @Test(description="API for displaying cities for planning tour.",groups="API Tests")
    // @Test(priority = 2,groups = {"API test"},description = "Search City functionality testing")
    public void testCase02(){
        String url="https://content-qtripdynamic-qa-backend.azurewebsites.net/api/v1/cities?q=beng";
        RequestSpecification httpRequest=RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
        Response response=httpRequest.get(url);
        JsonPath jsonpath=response.jsonPath();
        // String description=jsonpath.get();
        // System.out.println(description);
        System.out.println(response.getBody());
        response.then().assertThat().statusCode(200);
        // Assert.assertEquals(description, "100+ Places");
        
    }
}
