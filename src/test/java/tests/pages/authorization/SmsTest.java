package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

import java.util.Objects;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.MOCK_PHONE_NUMBER;

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
public class SmsTest extends BaseTest {

    @AfterEach
    @Step("Очистить куки")
    void clearCookie() {
        clearBrowserCookieAndStorage();
    }

    @DisplayName("Проверка отправки СМС -> ")
    @Description(value = "Тест проверяет возможность отправки смс (позитивный сценарий)")
    @ParameterizedTest(name = "{0}")
    @Execution(ExecutionMode.SAME_THREAD) // В одном потоке. Каждый вызов теста - новый инстанс
    @ValueSource(strings = {"123456", "222222"})
    public void checkSmsSend(String smsCode) {
        login.enterPhoneNumber(MOCK_PHONE_NUMBER).enterSms(smsCode);
        takeFirstLoan.acceptAllPolicy().clickNextButton();

        if (Objects.equals(smsCode, "123456")) {
            sms.checkValidState();
        } else {
            sms.checkInvalidState();
        }
    }
}
