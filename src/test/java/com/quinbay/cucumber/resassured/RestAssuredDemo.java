package com.quinbay.cucumber.resassured;

import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredDemo {


    public static void main(String []args) {
        RestAssured.baseURI = "https://reqes.in/";
      //  given()
               // .queryParam("page","2")
             //   .header("Content-Type","application/json")
              //  .log()
              //  .all()
              //  .when()
              //  .get("/api/users/")
               // .then()
                //.statusCode(200)
                //.assertThat()
                //.body("page",equalTo("2"))
                //.log()
               // .all();
String body="{\n" + "    \"name\": \"morpheus\",\n" + "    \"job\": \"leader\"\n" + "}";
given()
        .header("Content-Type","application/json")
        .log()
        .all()
        .when()
        .body(body)
        .post("/api/users")
        .then()
        .statusCode(201)
        .assertThat()
        .body("name",equalTo("morpheus"))
        .assertThat()
        .body("job",equalTo("leader"))
        .assertThat()
        .body(matchesJsonSchemaInClasspath("test1.json"))
        .log()
        .all();


    }


}
