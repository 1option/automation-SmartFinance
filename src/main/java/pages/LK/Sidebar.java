package pages.LK;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.Base;

public class Sidebar extends Base {
    public Sidebar(WebDriver driver) {
        super(driver);
    }

    private final By bodyOfMenuItemLocator = By.xpath("(//div[contains(@class, 'body')])[2]");
    ////div[contains(@class,'content')]//div[contains(@class, 'body')]

    @Step("Нажать на вкладку {0}")
    public Sidebar navigateToPage(String menuItemName) {
        WebElement myDataLocator = driver.findElement(By.xpath(String.format("//span[text()='%s']", menuItemName)));
        myDataLocator.click();
        return this;
    }

    @Step("Вкладка успешно открыта")
    public Sidebar verifyCurrentPage() {
        Assertions.assertTrue(waitElementIsPresent(bodyOfMenuItemLocator).isDisplayed());
        return this;
    }
}
