package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
glue = { "StepDefinition" }, 
tags = "@run", 
monochrome = true, 
plugin = { "pretty", "html:target/reports" }
)

public class TestRunner {
    
}
