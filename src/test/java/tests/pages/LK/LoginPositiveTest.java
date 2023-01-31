package tests.pages.LK;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;

@DisplayName("test_auth_001")
@Tag("Smoke")
@Tag("Login")
@Tag("Positive")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Feature(value = "Авторизация")
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Severity(value = SeverityLevel.CRITICAL)
public class LoginPositiveTest extends BaseTest {

    @AfterAll
    @Step("Очистить куки")
    public void clearCookie() {
        clearBrowserCookieAndStorage();
    }

    @DisplayName("Вход в Личный кабинет")
    @Description(value = "Тест проверяет возможность входа в личный кабинет")
    @Test
    public void signInLK() {
        login.enterPhoneNumber(LOGIN_PHONE_NUMBER).enterPasswordOrSms(PASSWORD).isSigned();
    }

}