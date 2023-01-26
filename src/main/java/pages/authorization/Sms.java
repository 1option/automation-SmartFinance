package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Sms extends BasePage {

    public final SelenideElement inputNameLocator = $(byName("userName"));
    private final SelenideElement divErrorMessageSms = $x("//div[contains(text(), 'неправильный СМС-код')]");

    @Step("Отобразилось поле 'Имя'")
    public Sms checkValidState() {
        inputNameLocator.shouldBe(visible);
        return this;
    }

    @Step("Отобразилась ошибка о том, что CМС-код не верный")
    public Sms checkInvalidState() {
        divErrorMessageSms.shouldBe(visible);
        return this;
    }
}
