package tests.login.positive;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.PASSWORD;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;

@DisplayName("test_auth_001")
@Tag("Smoke")
public class LoginPositiveTest extends BaseTest {

    @DisplayName("Вход в Личный кабинет")
    @Tag("Login")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест проверяет возможность входа в личный кабинет")
    @Epic(value = "Страница авторизации/регистрации JoyMoney")
    @Feature(value = "Авторизация")
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void login() {
        steps.enterPhoneNumber(LOGIN_PHONE_NUMBER)
                .enterPassword(PASSWORD)
                .clickNextButton()
                .isSigned();
    }
}
