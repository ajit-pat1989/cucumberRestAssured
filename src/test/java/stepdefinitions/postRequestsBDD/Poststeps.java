package stepdefinitions.postRequestsBDD;

import cucumber.api.java.en.Given;
import stepdefinitions.baseBDDmethods.BDDStyleMethod;

public class Poststeps {
    @Given("^I perform POST operation on for \"([^\"]*)\" URI$")
    public void iPerformPOSTOperationOnForURI(String arg0) throws Throwable {
        BDDStyleMethod.simplePostRequestWithParameter();
    }
}
