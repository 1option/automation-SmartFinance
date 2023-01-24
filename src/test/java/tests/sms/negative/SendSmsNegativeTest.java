package tests.sms.negative;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.REGISTRATION_PHONE_NUMBER;

@DisplayName("test_auth_002")
@Tag("Smoke")
public class SendSmsNegativeTest extends BaseTest {

    @DisplayName("Проверка отправки СМС (негативный сценарий)")
    @Tag("Login")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест проверяет возможность отправки смс (негативный сценарий)")
    @Epic(value = "Страница авторизации/регистрации JoyMoney")
    @Story(value = "Отправка СМС")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Test
    public void checkSmsSendNegative() {
        steps.enterPhoneNumber(REGISTRATION_PHONE_NUMBER)
                .enterSmsCode("222222")
                .acceptAllPolicy();
        sms.checkInvalidState();
    }

}
