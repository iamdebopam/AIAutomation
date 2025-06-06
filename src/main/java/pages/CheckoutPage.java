package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CheckoutPage {

    WebDriver driver;
    String originalWindow;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    By loginRegisterPopup = By.xpath("//div[contains(@class,'modal-content') and contains(., 'Login')]");
    By loginRegisterLink = By.xpath("//a[contains(text(),'Register / Login')]");
    By loginForm = By.id("form"); // Adjust locator according to actual login page

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public boolean isLoginRegisterPopupVisible() {
        return driver.findElement(loginRegisterPopup).isDisplayed();
    }

    public void clickLoginOrRegister() {
        originalWindow = driver.getWindowHandle();
        driver.findElement(loginRegisterLink).click();
    }

    public void switchToNewWindow() {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public boolean isLoginPageVisible() {
        return driver.findElement(loginForm).isDisplayed();
    }
}
