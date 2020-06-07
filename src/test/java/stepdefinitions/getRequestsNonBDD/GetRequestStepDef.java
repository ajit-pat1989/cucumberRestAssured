package stepdefinitions.getRequestsNonBDD;

import Utility.RestAssuredSupportiveMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class GetRequestStepDef {
    private static ResponseOptions<Response> response;
    @Given("^I perform GET operation on for \"([^\"]*)\" URI\\.$")
    public void iPerformGETOperationOnForURI(String url) throws Throwable {
        response = RestAssuredSupportiveMethods.getRequest(url);
    }

    @Then("^I should see the author name as \"([^\"]*)\" in actual result$")
    public void iShouldSeeTheAuthorNameAsInActualResult(String authorName) throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
    }
}
