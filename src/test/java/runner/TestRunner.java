package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty" },
                features = "src//test//java//features",
                glue = {"stepdefinitions" },
               // tags = { "@smokeTest" },
                plugin = {"html:output/html-report"},
                monochrome = true)
public class TestRunner {

}