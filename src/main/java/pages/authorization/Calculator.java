package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class Calculator extends BasePage {
    private String initialCashValue;
    private String initialDaysValue;
    private final SelenideElement cashInitialValue;
    private final SelenideElement daysInitialValue;
    private final SelenideElement divCashHandler;
    private final SelenideElement divDaysHandler;



    // Двигать будем одновременно два хэндлера, по три раза
    public Calculator() {
        divCashHandler = $x("(//div[contains(@class, 'rc-slider-handle')])[1]");
        divDaysHandler = $x("(//div[contains(@class, 'rc-slider-handle')])[2]");
        cashInitialValue = $x("(//span[contains(@class, 'Calculator_value')])[1]");
        daysInitialValue = $x("(//span[contains(@class, 'Calculator_value')])[2]");
    }

    /**
     *
     * @param xOffset pixels to move on X axis
     * @return this obj
     */
    @Step("Изменить положения хэндлеров на {0} по оси X")
    public Calculator moveHandlers(int xOffset) {
        initialCashValue = cashInitialValue.shouldBe(visible).getText();
        initialDaysValue = daysInitialValue.shouldBe(visible).getText();
        actions().dragAndDropBy(divCashHandler, xOffset, 0).perform();
        actions().dragAndDropBy(divDaysHandler, xOffset, 0).perform();
        return this;
    }

    /**
     *
     */
    @Step("Значения хендлеров изменились")
    public void checkValues() {
        String currentCashValue = cashInitialValue.shouldBe(visible).getText();
        String currentDaysValue = daysInitialValue.shouldBe(visible).getText();
        Assertions.assertNotEquals(currentCashValue, initialCashValue);
        Assertions.assertNotEquals(currentDaysValue, initialDaysValue);
    }
}
