package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/checkout.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/checkout.html"},
        monochrome = true
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {}
