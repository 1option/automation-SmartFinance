package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static constants.Locators.inputNameLocator;

public class Sms extends BasePage {

    private final SelenideElement divErrorMessageSms = $x("//div[contains(text(), 'неправильный СМС-код')]");

    @Step("Отобразилось поле 'Имя'")
    public void checkValidState() {
        inputNameLocator.shouldBe(visible);
    }

    @Step("Отобразилась ошибка о том, что CМС-код не верный")
    public void checkInvalidState() {
        divErrorMessageSms.shouldBe(visible);
    }
}
