package tests.pages.LK;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookiesAndStorage;
import static constants.Constant.URLS.TEST_PLAN;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;
@Epic("Личный кабинет")
@Feature("Авторизация")
@DisplayName("test_auth_001")
@Tag("Smoke")
@Tag("Login")
@Tag("Positive")
@Issue("89")
@TmsLink("89")
@Link(name = "Тест кейсы(Google Sheets)", url = TEST_PLAN)
@Owner("Максим Рожков")
public class LoginTest extends BaseTest {

    @AfterAll
    @Step("Очистить куки")
    void clearCookie() {
        clearBrowserCookiesAndStorage();
    }

    @Description("Тест проверяет возможность входа в личный кабинет")
    @DisplayName("Вход в ЛК")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void signInLK() {
        login.enterPhoneNumber(LOGIN_PHONE_NUMBER).enterPassword(PASSWORD);
    }
}

