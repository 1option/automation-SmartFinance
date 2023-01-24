package pages.authorization;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.Base;

public class Sms extends Base {

    public Sms(WebDriver driver) {
        super(driver);
    }

    public final By inputNameLocator = By.name("userName");
    private final By divErrorMessageSms = By.xpath("//div[contains(text(), 'неправильный СМС-код')]");

    @Step("Отобразилось поле 'Имя'")
    public Sms checkValidState() {
        Assertions.assertTrue(waitElementIsPresent(inputNameLocator).isDisplayed());
        return this;
    }

    @Step("Отобразилась ошибка о том, что CМС-код не верный")
    public Sms checkInvalidState() {
        Assertions.assertTrue(waitElementIsPresent(divErrorMessageSms).isDisplayed());
        return this;
    }
}
