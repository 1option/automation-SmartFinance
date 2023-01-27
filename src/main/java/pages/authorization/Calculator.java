package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class Calculator extends BasePage {
    private String initialCashValue;
    private String initialDaysValue;
    private final SelenideElement cashInitialValueLocator = $x("(//span[contains(@class, 'Calculator_value')])[1]");
    private final SelenideElement daysInitialValueLocator = $x("(//span[contains(@class, 'Calculator_value')])[2]");
    private WebElement divCashHandler;
    private WebElement divDaysHandler;

    /**
     *
     */
    public void findHandlerElements() {
        divCashHandler = $x("(//div[contains(@class, 'rc-slider-handle')])[1]");
        divDaysHandler = $x("(//div[contains(@class, 'rc-slider-handle')])[2]");
    }

    /**
     *
     * @param xOffset
     * @return
     */
    @Step("Сдвинуть хендлеры на {0} по оси X")
    public Calculator moveHandlers(int xOffset) {
        initialCashValue = cashInitialValueLocator.shouldBe(visible).getText();
        initialDaysValue = daysInitialValueLocator.shouldBe(visible).getText();
        actions().dragAndDropBy(divCashHandler, xOffset, 0).perform();
        actions().dragAndDropBy(divDaysHandler, xOffset, 0).perform();
        return this;
    }

    /**
     *
     * @return
     */
    @Step("Значения хендлеров изменились")
    public Calculator checkValues() {
        String currentCashValue = cashInitialValueLocator.shouldBe(visible).getText();
        String currentDaysValue = daysInitialValueLocator.shouldBe(visible).getText();
        Assertions.assertNotEquals(currentCashValue, initialCashValue);
        Assertions.assertNotEquals(currentDaysValue, initialDaysValue);
        return this;
    }
}
