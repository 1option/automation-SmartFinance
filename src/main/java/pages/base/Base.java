package pages.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static constants.Constant.TimeoutVariables.EXPLICIT_WAIT;

public class Base {

    public WebDriver driver;
    public JavascriptExecutor executor;
    public Actions action;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
    }

    /**
     * The method for navigating to a specific URL
     *
     * @param url open url
     * @return base obj
     */
    public Base goToUrl(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Wait for visibility element in DOM model
     *
     * @param locator element to search
     * @return located element from DOM
     */
    public WebElement waitElementIsPresent(final By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait for visibility elements in DOM model
     *
     * @param locator elements to search
     * @return located elements from DOM
     */
    public List<WebElement> waitElementsIsPresent(final By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public WebElement waitElementIsClickable(final By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Base javaScriptExecutorClickOn(WebElement element) {
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public Base showHiddenUlAndSelectFirst(final By locator) {
        executor.executeScript("arguments[0].style='overflow:visible;visibility:visible;'", waitElementIsPresent(locator));
        action.sendKeys(Keys.ENTER).build().perform();
        return this;
    }

}
