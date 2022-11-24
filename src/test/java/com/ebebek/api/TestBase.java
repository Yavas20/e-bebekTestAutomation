package com.ebebek.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class TestBase {

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "https://generator.swagger.io/api";

    }
}
