package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Login extends BasePage {

    public final SelenideElement buttonNextLocator = $x("//button[text() = 'Далее']");
    public final SelenideElement divLoansLocator = $x("//div[contains(@class,'Loans_loans')]");
    public final SelenideElement inputPasswordSmsCodeLocator = $x("//input[contains(@type,'password')]");
    public final SelenideElement inputPhoneNumberLocator = $x("//input[contains(@name,'hone')]");
    public final SelenideElement checkBoxAcceptAllPolicyLocator = $x("//input[@type='checkbox'][@id='userPolicy']");

    @Step("Ввести номер телефона")
    public Login enterPhoneNumber(String phoneNumber) {
        inputPhoneNumberLocator.shouldBe(visible).setValue(phoneNumber).pressEnter();
        return this;
    }

    @Step("Ввести пароль")
    public Login enterPasswordOrSms(String password) {
        inputPasswordSmsCodeLocator.shouldBe(visible).setValue(password).pressEnter();
        return this;
    }

    @Step("Произошел вход в Личный кабинет")
    public Login isSigned() {
        divLoansLocator.shouldBe(visible);
        return this;
    }
}
