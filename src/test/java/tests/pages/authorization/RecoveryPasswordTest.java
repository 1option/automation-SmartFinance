package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.RECOVERY_PHONE_NUMBER;
import static constants.Constant.UserData.RECOVERY_SMS;

@DisplayName("test_recovery_002")
@Tag("Login")
@Tag("Recovery")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Feature(value = "Навигация")
@Story(value = "Восстановление")
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Tag("Smoke")
public class RecoveryPasswordTest extends BaseTest {

    @DisplayName("Проверить работу восстановления пароля")
    @Description(value = "Тест проверяет возможность восстановления пароля")
    @Test
    public void recoveryPassword() {
        login.enterPhoneNumber(RECOVERY_PHONE_NUMBER);
        recoveryLink.clickOnRecoveryLink().checkCurrentPageIsRecoveryPage();
        login.enterPhoneNumber(RECOVERY_PHONE_NUMBER)
                .enterPassword(RECOVERY_SMS);
    }
}
