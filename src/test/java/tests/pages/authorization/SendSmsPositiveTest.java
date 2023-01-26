package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.REGISTRATION_PHONE_NUMBER;

@DisplayName("test_auth_003")
@Tag("Login")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Story(value = "Отправка СМС")
@Severity(value = SeverityLevel.CRITICAL)
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Tag("Smoke")
public class SendSmsPositiveTest extends BaseTest {

    @AfterAll
    @Step("Очистить куки")
    public void clearCookie() {
        clearBrowserCookieAndStorage();
    }

    @DisplayName("Проверка отправки СМС (позитивный сценарий)")
    @Description(value = "Тест проверяет возможность отправки смс (позитивный сценарий)")
    @Test
    public void checkSmsSendPositive() {
        login.enterPhoneNumber(REGISTRATION_PHONE_NUMBER)
                .enterPasswordOrSms("123456");
        takeFirstLoan.acceptAllPolicy().clickNextButton();
        sms.checkValidState();
    }
}
