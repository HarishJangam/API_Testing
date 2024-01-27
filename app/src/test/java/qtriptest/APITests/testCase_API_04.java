package qtriptest.APITests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.UUID;

public class testCase_API_04 {

    @Test(description="API for negative testing of register.",groups="API Tests")
    // @Test(priority = 4,description = "re registation functionality tesing",groups = {"API test"})
    public void testCase04(){
        String url="https://content-qtripdynamic-qa-backend.azurewebsites.net/api/v1/register";
        RequestSpecification httpResquest=RestAssured.given();
        httpResquest.contentType(ContentType.JSON);
        UUID uuid=UUID.randomUUID();
        String dynamicEmail="harish"+uuid+"@gmail.com";
        HashMap<String,String>mp=new HashMap<>();
        mp.put("email",dynamicEmail);
        mp.put("password","harish");
        mp.put("confirmpassword","harish");
        httpResquest.body(mp);
        Response response=httpResquest.post(url);
        response.then().assertThat().statusCode(201);
        System.out.println(response.getBody());
        JsonPath jsonpath=response.jsonPath();    

        response=httpResquest.post(url);

        response.then().assertThat().statusCode(400);
    }
}

  

