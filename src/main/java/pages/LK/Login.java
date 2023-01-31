package pages.LK;

import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static constants.Constant.URLS.USER_LOANS_PAGE;
import static constants.Locators.*;

public class Login extends BasePage {

    @Step("Ввести номер телефона")
    public Login enterPhoneNumber(String phoneNumber) {
        inputPhoneNumberLocator.shouldBe(visible).setValue(phoneNumber).pressEnter();
        return this;
    }

    @Step("Ввести пароль")
    public Login enterPassword(String password) {
        inputPasswordLocator.setValue(password).pressEnter();
        return this;
    }

    @Step("Ввести смс-код")
    public void enterSms(String code) {
        inputSmsCodeLocator.setValue(code).pressEnter();
    }

    @Step("Произошел вход в Личный кабинет")
    public void isSigned() {
        webdriver().shouldHave(url(USER_LOANS_PAGE));
    }
}
