package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CategoryPage;
import Utilities.DriverFactory;
import static org.testng.Assert.*;

public class JeansSteps {

    @When("user navigates to Men category and selects Jeans")
    public void user_navigates_to_men_category_and_selects_jeans() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickMenCategory();
        categoryPage.selectJeans();
    }

    @When("user adds jeans to cart")
    public void user_adds_jeans_to_cart() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.addFirstJeansToCart();
    }

    @Then("jeans added popup should be visible")
    public void jeans_added_popup_should_be_visible() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        assertTrue(categoryPage.isAddedPopupVisible());
    }

    @Then("user clicks on continue shopping")
    public void user_clicks_on_continue_shopping() {
        WebDriver driver = DriverFactory.getDriver();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickContinueShopping();
    }
}