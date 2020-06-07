package stepdefinitions.baseBDDmethods;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class BDDStyleMethod {

    public static void SimpleGetRequest(String postNumber) {
        String url = String.format("%s%s", "http://localhost:3000/posts/",postNumber);
        System.out.println(url);
        given()
                .contentType(ContentType.JSON)

        .when()
                .get(url)
        .then()
                .statusCode(200)
                .assertThat()
                .body("author", equalTo("UFTTraining")).log().all();
    }

    public static void containingCollectionsGetRequest() {
        String url = String.format("%s%s", "http://localhost:3000/posts/","");
        System.out.println(url);
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(url)
        .then()
                .statusCode(200)
                .assertThat()
                .body("author", hasItems("Ajit Desai","typicode","Ajit Patil",null)).log().all();
    }

    public static void pathparameterGetRequest() {
        String url = String.format("%s%s", "http://localhost:3000/posts/","");
        System.out.println(url);
        given()
                .contentType(ContentType.JSON)
        .with()
                .pathParam("post",2)
        .when()
                .get(url+"{post}")
        .then()
                .statusCode(200)
                .assertThat()
                .body("author", containsString("Ajit Desai"));
    }

    public static void queryparameterGetRequest() {
        String url = String.format("%s%s", "http://localhost:3000/posts/","");
        System.out.println(url);
        given()
                .contentType(ContentType.JSON)
        .with()
                .queryParam("id",2)
        .when()
                .get(url)
        .then()
                .statusCode(200)
                .assertThat()
                .body("author", hasItem("Ajit Desai"));
    }

    public static void simplePostRequestWithParameter() {
        String url = String.format("%s%s", "http://localhost:3000/posts/","");
        System.out.println(url);
        HashMap<String, Object> postsparam = new HashMap<>();
        postsparam.put("id", 5);
        postsparam.put("title", "TestAutomationUFT");
        postsparam.put("author", "UFTTraining");

        given()
                .contentType(ContentType.JSON)
        .with()
                .body(postsparam)
        .when()
                .post(url)
                .then()
                .statusCode(201)
                .assertThat()
                .body("author", Is.is("UFTTraining"));
    }

}
