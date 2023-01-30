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
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Owner("Максим Рожков")
public class LoginTest extends BaseTest {

    @AfterAll
    @Step("Очистить куки")
    void clearCookie() {
        clearBrowserCookieAndStorage();
    }

    @Description("Тест проверяет возможность входа в личный кабинет")
    @Epic("Личный кабинет")
    @Feature("Авторизация")
    @DisplayName("Вход в ЛК")
    @Severity(value = SeverityLevel.CRITICAL)
    @Issue("89")
    @TmsLink("89")
    @Test
    public void signInLK() {
        login.enterPhoneNumber(LOGIN_PHONE_NUMBER).enterPassword(PASSWORD).isSigned();
    }
}

