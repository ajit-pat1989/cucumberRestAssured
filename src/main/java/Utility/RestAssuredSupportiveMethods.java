package Utility;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredSupportiveMethods {
    public static RequestSpecification request;
    public RestAssuredSupportiveMethods() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.setBaseUri("http://localhost:3000");
        specBuilder.setContentType(ContentType.JSON);
        //specBuilder.setUrlEncodingEnabled(false);
        RequestSpecification req =  specBuilder.build();
        request = RestAssured.given().spec(req);
    }

    public static ResponseOptions<Response> getRequestWithParameters(String url, Map<String,String> params) {
        request.pathParams(params);
        return request.get(url);
    }

    public static ResponseOptions<Response> getRequest(String url) {
        try {
            return request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> postRequestWithBodyAndParameters(String url, Map<String,String> params, Map<String,String> body) {
        request.pathParams(params);
        request.body(body);
            return request.post(url);
    }

    public static ResponseOptions<Response> postRequestWithBody(String url, Map<String,Object> body) {
        request.body(body);
        return request.post(url);
    }
    public static ResponseOptions<Response> deleteRequestWithParameters(String url, Map<String,String> params) {
        request.pathParams(params);
        return request.delete(url);
    }


}
