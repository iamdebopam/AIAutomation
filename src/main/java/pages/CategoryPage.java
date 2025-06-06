package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenCategory() {
        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a/span/i")).click();
    }

    public void selectJeans() {
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div/div[1]/div[2]/div[2]/div/ul/li[2]/a")).click();
    }

    public void addFirstJeansToCart() {
        Actions actions = new Actions(driver);
        WebElement jeansBlock = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]"));
        actions.moveToElement(jeansBlock).perform();

        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
        addToCartButton.click();
    }

    public boolean isAddedPopupVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4")));
        return popup.isDisplayed();
    }

    public void clickContinueShopping() {
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
    }
}