package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CategoryPage;
import utilities.DriverFactory;
import static org.testng.Assert.*;

public class TopSteps {

    @When("user clicks on Polo brand")
    public void user_clicks_on_polo_brand() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickPoloBrand();
    }

    @When("user adds top to cart")
    public void user_adds_top_to_cart() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.addFirstTopToCart();
    }

    @Then("top added popup should be visible")
    public void top_added_popup_should_be_visible() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        assertTrue(categoryPage.isAddedPopupVisible());
    }

    @Then("user clicks on View Cart")
    public void user_clicks_on_view_cart() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickViewCart();
    }
}