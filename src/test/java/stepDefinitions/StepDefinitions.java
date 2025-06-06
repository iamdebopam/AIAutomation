package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CategoryPage;
import pages.HomePage;
import utilities.*;
import java.util.Properties;
import static org.testng.Assert.*;

public class StepDefinitions {
    WebDriver driver;
    Properties prop;
    ConfigReader configReader;
    HomePage homePage;
    static CategoryPage categoryPage;

    @Given("user launches the browser")
    public void launchBrowser() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        driver = DriverFactory.init_driver(prop.getProperty("browser"));
        categoryPage = new CategoryPage(driver);
    }

    @When("user navigates to homepage")
    public void navigateToHomepage() {
        driver.get(prop.getProperty("baseUrl"));
        homePage = new HomePage(driver);
    }

    @Then("logo should be visible")
    public void checkLogo() {
        assertTrue(homePage.isLogoDisplayed());
    }

    @When("user navigates to Men category and selects Jeans")
    public void user_navigates_to_men_category_and_selects_jeans() {
        categoryPage.clickMenCategory();
        categoryPage.selectJeans();
    }

    @When("user adds jeans to cart")
    public void user_adds_jeans_to_cart() {
        categoryPage.addFirstJeansToCart();
    }

    @Then("added popup should be visible")
    public void added_popup_should_be_visible() {
        assertTrue(categoryPage.isAddedPopupVisible());
    }

    @Then("user clicks on continue shopping")
    public void user_clicks_on_continue_shopping() {
        categoryPage.clickContinueShopping();
    }
    @When("user clicks on Polo brand")
    public void user_clicks_on_polo_brand() {
        categoryPage.clickPoloBrand();
    }

    @When("user adds top to cart")
    public void user_adds_top_to_cart() {
        categoryPage.addFirstTopToCart();
    }

    @Then("user clicks on View Cart")
    public void user_clicks_on_view_cart() {
        categoryPage.clickViewCart();
    }
}