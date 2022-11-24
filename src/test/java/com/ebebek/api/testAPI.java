package com.ebebek.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testAPI extends TestBase {


    @DisplayName("GET ile başarılı test senaryosu - doğru dil parametresi girildi")
    @Test
    @Order(1)
    public void testGetIle() {

        given().accept(ContentType.JSON)
                .and().pathParam("language", "java")
                    .when().get("/gen/clients/{language}")
                         .then().statusCode(200);
    }



    @DisplayName("GET ile başarısız test senaryosu - yanlış dil parametresi girildi")
    @Test
    @Order(2)
    public void testGetIle2() {

        given().accept(ContentType.JSON)
                .and().pathParam("language", "ebebek")
                    .when().get("/gen/clients/{language}")
                        .then().statusCode(400);
    }



    @DisplayName("POST ile başarısız test senaryosu - doğru dil parametresi ve Json objesi girildi")
    @Test
    @Order(3)
    public void testPostIle() {

        String jsonObjesi = "{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"string\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\",\n" +
                "    \"urlMatcher\": {}\n" +
                "  },\n" +
                "  \"usingFlattenSpec\": true,\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}";


        given().accept(ContentType.JSON)
                    .and().contentType(ContentType.JSON)
                        .and().pathParam("language", "java")
                            .and().body(jsonObjesi)
                              .when().post("/gen/clients/{language}")
                                    .then().statusCode(500);
    }



    @DisplayName("POST ile başarısız test senaryosu - yanlış dil parametresi ve doğru Json objesi girildi")
    @Test
    @Order(4)
    public void testPostIle2() {

        String jsonObjesi = "{\"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"string\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\",\n" +
                "    \"urlMatcher\": {}\n" +
                "  },\n" +
                "  \"usingFlattenSpec\": true,\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "}";


        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                    .and().pathParam("language", "ebebek")
                        .and().body(jsonObjesi)
                            .when().post("/gen/clients/{language}")
                                .then().statusCode(500);
    }



    @DisplayName("POST ile başarısız test senaryosu - doğru dil parametresi ve yanlış Json objesi girildi")
    @Test
    @Order(5)
    public void testPostIle3() {

        String jsonObjesi = "ebebek";


        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                    .and().pathParam("language", "java")
                        .and().body(jsonObjesi)
                            .when().post("/gen/clients/{language}")
                                .then().statusCode(400);
    }


}