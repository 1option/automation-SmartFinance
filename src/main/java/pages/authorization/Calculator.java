package pages.authorization;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.base.Base;

public class Calculator extends Base {
    private String initialCashValue;
    private String initialDaysValue;
    private final By cashInitialValueLocator = By.xpath("(//span[contains(@class, 'Calculator_value')])[1]");
    private final By daysInitialValueLocator = By.xpath("(//span[contains(@class, 'Calculator_value')])[2]");
    private WebElement divCashHandler;
    private WebElement divDaysHandler;

    public Calculator(WebDriver driver) {
        super(driver);
    }

    public void findHandlerElements() {
        divCashHandler = driver.findElement(By.xpath("(//div[contains(@class, 'rc-slider-handle')])[1]"));
        divDaysHandler = driver.findElement(By.xpath("(//div[contains(@class, 'rc-slider-handle')])[2]"));
    }

    @Step("Сдвинуть хендлеры на {0} по оси X")
    public Calculator moveHandlers(int xOffset) {
        initialCashValue = driver.findElement(cashInitialValueLocator).getText();
        initialDaysValue = driver.findElement(daysInitialValueLocator).getText();
        action.dragAndDropBy(divCashHandler, xOffset, 0).perform();
        action.dragAndDropBy(divDaysHandler, xOffset, 0).perform();
        return this;
    }

    @Step("Значения хендлеров изменились")
    public Calculator checkValues() {
        String currentCashValue = driver.findElement(cashInitialValueLocator).getText();
        String currentDaysValue = driver.findElement(daysInitialValueLocator).getText();
        Assertions.assertNotEquals(currentCashValue, initialCashValue);
        Assertions.assertNotEquals(currentDaysValue, initialDaysValue);
        return this;
    }
}
