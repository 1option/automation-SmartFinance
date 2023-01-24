package pages.base;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps extends Base{
    public Steps(WebDriver driver) {
        super(driver);
    }
    private final By buttonNextLocator = By.xpath("//button[text() = 'Далее']");
    private final By divLoansLocator = By.xpath("//div[contains(@class,'Loans_loans')]");
    private final By inputPasswordSmsCodeLocator = By.xpath("//input[contains(@type,'password')]");
    public final By inputPhoneNumberLocator = By.xpath("//input[contains(@name,'hone')]");
    public final By checkBoxAcceptAllPolicyLocator = By.xpath("//input[@type='checkbox'][@id='userPolicy']");

    // Сделать интерфейс для этих шагов
    @Step("Ввести номер телефона")
    public Steps enterPhoneNumber(String phoneNumber) {
        waitElementIsPresent(inputPhoneNumberLocator).sendKeys(phoneNumber);
        return this;
    }

    @Step("Ввести пароль")
    public Steps enterPassword(String password) {
        waitElementIsPresent(inputPasswordSmsCodeLocator).sendKeys(password);
        return this;
    }

    @Step("Ввести смс-код")
    public Steps enterSmsCode(String smsCode) {
        waitElementIsPresent(inputPasswordSmsCodeLocator).sendKeys(smsCode);
        return this;
    }

    @Step("Нажать на кнопку 'Далее'")
    public Steps clickNextButton() {
        waitElementIsPresent(buttonNextLocator).click();
        return this;
    }

    @Step("Произошел вход в Личный кабинет")
    public Steps isSigned() {
        Assertions.assertTrue(driver.findElement(divLoansLocator).isDisplayed());
        return this;
    }

    @Step("Принять соглашения")
    public Steps acceptAllPolicy() {
        WebElement checkBoxAcceptAllPolicy = waitElementIsPresent(checkBoxAcceptAllPolicyLocator);
        javaScriptExecutorClickOn(checkBoxAcceptAllPolicy);
        return this;
    }
}
