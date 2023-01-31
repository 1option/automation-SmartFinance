package tests.pages.authorization;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.TEST_PLAN;

@DisplayName("test_navbar_001")
@Tag("Navigation")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Страница авторизации/регистрации JoyMoney")
@Feature(value = "Навигация")
@Story(value = "Логотип")
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = TEST_PLAN)
@Severity(value = SeverityLevel.MINOR)
@Tag("Smoke")
public class LogoLinkTest extends BaseTest {

    @DisplayName("Логотип перенаправляет на страницу лендинга")
    @Description(value = "Тест проверяет возможность перехода на страницу лендинга по нажатию на логотип")
    @Test
    public void redirectToLanding() {
        logoLink.clickOnLogo().checkCurrentPageIsLanding();
    }
}
