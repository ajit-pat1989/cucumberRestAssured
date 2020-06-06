package steps;

import io.restassured.http.ContentType;

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
                .body("author", equalTo("Ajit Desai"));
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
                .body("author", containsInAnyOrder("Ajit Desai","typicode","Ajit Patil",null));
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

}
