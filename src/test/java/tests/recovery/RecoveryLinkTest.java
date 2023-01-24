package tests.recovery;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.RECOVERY_PHONE_NUMBER;

@DisplayName("test_recovery_001")
@Tag("Smoke")
public class RecoveryLinkTest extends BaseTest {

    @DisplayName("Ссылка 'Я не помню пароль' перенаправляет на страницу лендинга")
    @Tag("Login")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест проверяет возможность перехода на страницу восстановления пароля")
    @Epic(value = "Страница авторизации/регистрации JoyMoney")
    @Feature(value = "Навигация")
    @Story(value = "Восстановление пароля")
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Test
    public void moveHandlersAndCheckValues() {
        steps.enterPhoneNumber(RECOVERY_PHONE_NUMBER);
        recoveryLink.clickOnRecoveryLink().checkCurrentPageIsRecoveryPage();
    }
}
