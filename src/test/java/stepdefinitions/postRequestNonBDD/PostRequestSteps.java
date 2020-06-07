package stepdefinitions.postRequestNonBDD;

import Utility.RestAssuredSupportiveMethods;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestSteps {
    private static ResponseOptions<Response> response;
    @Given("^I perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) throws Throwable {

        List<List<String>> data = table.raw();
        //Setting body
        HashMap<String,String> body = new HashMap<>();
        body.put("name", data.get(1).get(0));
        //Setting body
        HashMap<String,String> param = new HashMap<>();
        param.put("profileNo", data.get(1).get(1));
        response = RestAssuredSupportiveMethods.postRequestWithBodyAndParameters(url,param,body);
    }

    @Then("^I should be able to verify response body for \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyResponseBodyFor(String username) throws Throwable {
        assertThat(response.statusCode(),equalTo(201));
        assertThat(response.getBody().jsonPath().get("name"),equalTo(username));
    }
}
