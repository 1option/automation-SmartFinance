package tests.logo;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;

@DisplayName("test_navbar_001")
@Tag("Smoke")
public class LogoLinkTest extends BaseTest {

    @DisplayName("Логотип перенаправляет на страницу лендинга")
    @Tag("Navigation")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест проверяет возможность перехода на страницу лендинга по нажатию на логотип")
    @Epic(value = "Страница авторизации/регистрации JoyMoney")
    @Feature(value = "Навигация")
    @Story(value = "Логотип")
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Severity(value = SeverityLevel.MINOR)
    @Test
    public void redirectToLanding() {
        logoLink.clickOnLogo().checkCurrentPageIsLanding();
    }
}
