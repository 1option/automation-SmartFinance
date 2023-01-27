package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.PASSWORD;
import static constants.Constant.UserData.REGISTRATION_PHONE_NUMBER;

@DisplayName("test_auth_004")
@Tag("Login")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Story("Соглашение с условиями")
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Severity(value = SeverityLevel.CRITICAL)
@Tag("Smoke")
public class CheckBoxPolicyTest extends BaseTest {

    @AfterAll
    @Step("Очистить куки")
    public void clearCookie() {
        clearBrowserCookieAndStorage();
    }

    @DisplayName("Открыть документы и проверить работу чекбоксов")
    @Description(value = "Тест на проверку работы чекбоксов и отображения документов")
    @Test
    public void checkBoxAndPolicyVerification() {
        login.enterPhoneNumber(REGISTRATION_PHONE_NUMBER).enterPassword(PASSWORD);
        checkboxPolicy.verifyAllCheckBoxes()
                .verifyDocumentCheckBoxes()
                .verifyDocuments();
    }
}
