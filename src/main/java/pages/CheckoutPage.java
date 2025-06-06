package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CheckoutPage {

    WebDriver driver;
    String originalWindow;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By proceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    By loginRegisterPopup = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[1]");
    By loginRegisterLink = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u");
    By loginForm = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"); // Adjust locator according to actual login page

    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement proceedCheckout = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        proceedCheckout.click();

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
