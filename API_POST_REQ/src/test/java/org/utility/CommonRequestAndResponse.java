package org.utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class CommonRequestAndResponse {

    public static io.restassured.specification.RequestSpecification commonRequest() {
        return new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();
    }

    public static ResponseSpecification commonResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json;charset=UTF-8").build();
    }
}
