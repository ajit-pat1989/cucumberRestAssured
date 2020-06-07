package stepdefinitions.smokertest;

import Utility.RestAssuredSupportiveMethods;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SmokeTest {
    public static ResponseOptions<Response> response;
    @Given("^I perform POST operation for \"([^\"]*)\" with the body as below$")
    public void iPerformPOSTOperationForWithTheBodyAsBelow(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        HashMap<String,Object> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));
        response = RestAssuredSupportiveMethods.postRequestWithBody(url,body);
        response.getBody().prettyPrint().toString();
    }

    @And("^I perform DELETE operation for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        HashMap<String,String> param = new HashMap<>();
        param.put("postid", data.get(1).get(0));
        response = RestAssuredSupportiveMethods.deleteRequestWithParameters(url,param);
        response.getBody().prettyPrint().toString();
    }

    @And("^I perform GET operation with path parameter as \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterAs(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        HashMap<String,String> param = new HashMap<>();
        param.put("postid", data.get(1).get(0));
        response = RestAssuredSupportiveMethods.getRequestWithParameters(url,param);
        response.getBody().prettyPrint().toString();
    }

    @Then("^I should not see the body title as \"([^\"]*)\"$")
    public void iShouldNotSeeTheBodyTitleAs(String username) throws Throwable {
        assertThat(response.getBody().jsonPath().get("title"), IsNot.not(username));
    }
}
