package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.*;
import java.util.Properties;
import static org.testng.Assert.*;

public class CommonSteps {
    WebDriver driver;
    Properties prop;
    ConfigReader configReader;

    @Given("user launches the browser")
    public void launchBrowser() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        driver = DriverFactory.init_driver(prop.getProperty("browser"));
    }

    @When("user navigates to homepage")
    public void navigateToHomepage() {
        driver = DriverFactory.getDriver();
        driver.get(configReader.init_prop().getProperty("baseUrl"));
    }

    @Then("logo should be visible")
    public void checkLogo() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        assertTrue(homePage.isLogoDisplayed());
    }
}