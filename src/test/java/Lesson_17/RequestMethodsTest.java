package Lesson_17;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com/";
    }

    @Test
    public void testGetRequest() {
        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPutRequest() {
        given()
                .body("{\"key\": \"updatedValue\"}")
                .contentType("application/json")
                .when()
                .put("put")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("updatedValue"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .param("foo", "bar")
                .when()
                .delete("delete")
                .then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"));
    }

    @Test
    public void testPatchRequest() {
        given()
                .body("{\"key\": \"patchedValue\"}")
                .contentType("application/json")
                .when()
                .patch("patch")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("patchedValue"));
    }

    @Test
    public void testPostRawText() {
        String rawText = "This is expected to be sent back as part of response body.";

        given()
                .body(rawText)
                .contentType("text/plain")
                .when()
                .post("post")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawText));
    }

    @Test
    public void testPostFormData() {
        given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .post("post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }
}