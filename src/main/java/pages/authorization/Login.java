package pages.authorization;

import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static constants.Constant.URLS.LK_PAGE;
import static constants.Locators.inputPasswordLocator;
import static constants.Locators.inputPhoneNumberLocator;

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

    @Step("Произошел вход в Личный кабинет")
    public Login isSigned() {
        webdriver().shouldHave(url(LK_PAGE));
        return this;
    }
}
