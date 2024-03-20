package com.qa.techtorialwork.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //It will run your Cucumber test scenarios with Junit
@CucumberOptions(//It is an annotation that has some special keywords
        features = "src/test/resources/features", //the location of your feature files(we provide features folder)(Content)
        glue = "com/qa/techtorialwork/stepdefinitions", //the location of step definitions(source)
        dryRun = false,//It is a way to get snips without executing the steps (true)
        tags = "@regression",//it is a way to filter your test cases(scenario)
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class Runner {
}
