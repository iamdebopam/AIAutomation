package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement jeansLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/category_products/6']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", jeansLink);
        jeansLink.click();
    }

    public void addFirstJeansToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement jeansBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]")));
        actions.moveToElement(jeansBlock).perform();

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div/a")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    public boolean isAddedPopupVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4")));
        return popup.isDisplayed();
    }

    public void clickContinueShopping() {
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
    }
    public void clickPoloBrand() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement poloBrand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/brand_products/Polo']")));
        poloBrand.click();
    }

    public void addFirstTopToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement topBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='productinfo text-center'])[1]")));
        actions.moveToElement(topBlock).perform();

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Add to cart')])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
    }

    public void clickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']")));
        viewCart.click();
    }
}