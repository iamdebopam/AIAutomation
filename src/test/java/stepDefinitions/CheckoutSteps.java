package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import utilities.DriverFactory;

import static org.testng.Assert.assertTrue;

public class CheckoutSteps {

    WebDriver driver;
    CheckoutPage checkoutPage;

    public CheckoutSteps() {
        this.driver = DriverFactory.getDriver();
        this.checkoutPage = new CheckoutPage(driver);
    }

    @When("user clicks on Proceed to Checkout button")
    public void user_clicks_on_proceed_to_checkout_button() {
        checkoutPage.clickProceedToCheckout();
    }

    @Then("user should see the login & register popup")
    public void user_should_see_the_login_register_popup() {
        assertTrue(checkoutPage.isLoginRegisterPopupVisible(), "Login/Register popup is not visible");
    }

    @Then("user clicks on Login or Register link from popup")
    public void user_clicks_on_login_or_register_link_from_popup() {
        checkoutPage.clickLoginOrRegister();
    }

    @Then("new window should open for login or registration")
    public void new_window_should_open_for_login_or_registration() {
        checkoutPage.switchToNewWindow();
        assertTrue(checkoutPage.isLoginPageVisible(), "Login page is not visible in new window");
    }
}
