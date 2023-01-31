package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.TEST_PLAN;
import static constants.Constant.UserData.MOCK_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;

@DisplayName("test_auth_004")
@Tag("Login")
@Issue("89")
@TmsLink("89")
@Epic("Страница авторизации/регистрации JoyMoney")
@Story("Соглашение с условиями")
@Owner("Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = TEST_PLAN)
@Severity(SeverityLevel.CRITICAL)
@Tag("Smoke")
public class CheckBoxPolicyTest extends BaseTest {
    @AfterAll
    @Step("Очистить куки")
    void clearCookie() {
        clearBrowserCookieAndStorage();
    }

    @DisplayName("Открыть документы и проверить работу чекбоксов")
    @Description(value = "Тест на проверку работы чекбоксов и отображения документов")
    @Test
    public void checkBoxAndPolicyVerification() {
        login.enterPhoneNumber(MOCK_PHONE_NUMBER).enterPassword(PASSWORD);
        checkboxPolicy.verifyAllCheckBoxes()
                .verifyDocumentCheckBoxes()
                .verifyDocuments();
    }
}
