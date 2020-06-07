package stepdefinitions.init;

import Utility.RestAssuredSupportiveMethods;
import cucumber.api.java.Before;

public class InitRest {

    @Before
    public void initialSetup(){

        RestAssuredSupportiveMethods restInit = new RestAssuredSupportiveMethods();
    }

}
