package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.TEST_PLAN;

@DisplayName("test_navbar_001")
@Tag("Navigation")
@Tag("Smoke")
@Issue("89")
@TmsLink("89")
@Epic("Страница авторизации/регистрации JoyMoney")
@Feature("Навигация")
@Story("Логотип")
@Owner("Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = TEST_PLAN)
public class LogoTest extends BaseTest {

    @DisplayName("Логотип перенаправляет на страницу лендинга")
    @Description(value = "Тест проверяет возможность перехода на страницу лендинга по нажатию на логотип")
    @Severity(value = SeverityLevel.MINOR)
    @Test
    public void redirectToLanding() {
        logo.clickOnLogo().checkCurrentPageIsLanding();
    }
}
