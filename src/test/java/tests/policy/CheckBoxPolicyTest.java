package tests.policy;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.PASSWORD;
import static constants.Constant.UserData.REGISTRATION_PHONE_NUMBER;

@DisplayName("test_auth_004")
@Tag("Smoke")
public class CheckBoxPolicyTest extends BaseTest {

    @BeforeAll
    public void enterPhoneNumberAndSms() {
        steps.enterPhoneNumber(REGISTRATION_PHONE_NUMBER).enterSmsCode(PASSWORD);
    }

    @DisplayName("Открыть документы и проверить работу чекбоксов")
    @Tag("Login")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест на проверку работы чекбоксов и отображения документов")
    @Epic(value = "Страница авторизации/регистрации JoyMoney")
    @Story("Соглашение с условиями")
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void checkBoxAndPolicyVerification() {
        checkboxPolicy.verifyAllCheckBoxes()
                .verifyDocumentCheckBoxes()
                .verifyDocuments();
    }
}
