package tests.recovery;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.*;

@DisplayName("test_recovery_002")
@Tag("Smoke")
public class RecoveryPasswordTest extends BaseTest {


    @Disabled
    @DisplayName("Проверить работу восстановления пароля")
    @Tag("Login")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест проверяет возможность восстановления пароля")
    @Epic(value = "Страница авторизации/регистрации JoyMoney")
    @Feature(value = "Навигация")
    @Story(value = "Восстановление")
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Test
    public void recoveryPassword() {
        steps.enterPhoneNumber(RECOVERY_PHONE_NUMBER);
        recoveryLink.clickOnRecoveryLink().checkCurrentPageIsRecoveryPage();
        steps.enterPhoneNumber(RECOVERY_PHONE_NUMBER)
                .clickNextButton()
                .enterPassword(RECOVERY_SMS)
                .clickNextButton();
    }
}
