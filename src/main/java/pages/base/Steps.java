package pages.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Steps extends BasePage {
    private final SelenideElement buttonNextLocator = $x("//button[text() = 'Далее']");
    private final SelenideElement divLoansLocator = $x("//div[contains(@class,'Loans_loans')]");
    private final SelenideElement inputPasswordSmsCodeLocator = $x("//input[contains(@type,'password')]");
    public final SelenideElement inputPhoneNumberLocator = $x("//input[contains(@name,'hone')]");
    public final SelenideElement checkBoxAcceptAllPolicyLocator = $x("//input[@type='checkbox'][@id='userPolicy']");

    // Сделать интерфейс для этих шагов
    @Step("Ввести номер телефона")
    public Steps enterPhoneNumber(String phoneNumber) {
        inputPhoneNumberLocator.setValue(phoneNumber).pressEnter();
        return this;
    }

    @Step("Ввести пароль")
    public Steps enterPassword(String password) {
        inputPasswordSmsCodeLocator.setValue(password).pressEnter();
        return this;
    }

    @Step("Ввести смс-код")
    public Steps enterSmsCode(String smsCode) {
        inputPasswordSmsCodeLocator.setValue(smsCode).pressEnter();
        return this;
    }

    @Step("Нажать на кнопку 'Далее'")
    public Steps clickNextButton() {
        buttonNextLocator.pressEnter();
        return this;
    }

    @Step("Произошел вход в Личный кабинет")
    public Steps isSigned() {
        divLoansLocator.shouldBe(visible);
        return this;
    }

    @Step("Принять соглашения")
    public Steps acceptAllPolicy() {
        checkBoxAcceptAllPolicyLocator.click();
        return this;
    }


}
