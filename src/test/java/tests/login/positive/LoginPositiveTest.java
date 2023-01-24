package tests.login.positive;

import common.Listener;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.base.BaseTest;

import static constants.Constant.URLS.AUTHORIZATION_PAGE;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;

@DisplayName("test_auth_001(positive)")
@Tag("Smoke")
@Tag("Login")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Feature(value = "Авторизация")
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Severity(value = SeverityLevel.CRITICAL)
@ExtendWith(Listener.class)
public class LoginPositiveTest extends BaseTest {

    @DisplayName("Вход в Личный кабинет")
    @Description(value = "Тест проверяет возможность входа в личный кабинет")
    @Test
    public void login() {
        basePage.goToUrl(AUTHORIZATION_PAGE);
        login.enterPhoneNumber(LOGIN_PHONE_NUMBER).enterPassword(PASSWORD).isSigned();
    }
}
