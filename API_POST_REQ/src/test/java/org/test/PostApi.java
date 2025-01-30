package org.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.payLoad.ResPayload;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utility.CommonRequestAndResponse;
import org.payLoad.ReqPayload;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostApi {
    @Test
    public void addNewPlace() throws IOException {
        String expectedStatus =  "OK";
        RequestSpecification res = given().log().all()
                .spec(CommonRequestAndResponse.commonRequest())
                .body(ReqPayload.getGooglePlayLoad());
        Response res1 =res.when()
                .post("/maps/api/place/add/json");
        ResPayload Response = res1.then().log().all()
                .spec(CommonRequestAndResponse.commonResponse())
                .extract().response().as(ResPayload.class);
        System.out.println(Response);
        System.out.println(Response.getId());
        System.out.println(Response.getPlace_id());
        System.out.println(Response.getReference());
        System.out.println(Response.getScope());
        System.out.println(Response.getStatus());
        Assert.assertEquals(Response.getStatus(), expectedStatus);
    }
}
