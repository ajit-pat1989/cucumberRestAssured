package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetPost {

    @Given("^I perform GET operation on for \"([^\"]*)\"$")
    public void iPerformGETOperationOnFor(String url) throws Throwable {

    }

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String postNumber) throws Throwable {
        BDDStyleMethod.SimpleGetRequest(postNumber);
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {

    }

    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() {
        BDDStyleMethod.containingCollectionsGetRequest();
    }

    @Then("^I should verify the GET parameter$")
    public void iShouldVerifyTheGETParameter() {
        BDDStyleMethod.pathparameterGetRequest();
    }

    @Then("^I should verify the GET query parameter$")
    public void iShouldVerifyTheGETQueryParameter() {
        BDDStyleMethod.queryparameterGetRequest();
    }
}



















//    @Given("^I perform GET operation on for \"([^\"]*)\"$")
//    public void iPerformGETOperationOnFor(String url) throws Throwable {
//        given().contentType(ContentType.JSON);
//    }
//
//    @And("^I perform GET for the post number \"([^\"]*)\"$")
//    public void iPerformGETForThePostNumber(String postNumber) throws Throwable {
//        String url = String.format("%s%s", "http://localhost:3000/posts/",postNumber);
//        System.out.println(url);
//        when().get(url).then().statusCode(200).assertThat().body("author", equalTo("Ajit Desai"));
//    }
//
//    @Then("^I should see the author name as \"([^\"]*)\"$")
//    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {
//
//    }

