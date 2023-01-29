package tests.pages.LK;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;

@DisplayName("test_lk_sidebar_001")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Owner("Максим Рожков")
public class MenuTest extends BaseTest {

    @BeforeAll
    @Step("Войти в ЛК")
    void signIn() {
        login.enterPhoneNumber(LOGIN_PHONE_NUMBER).enterPassword(PASSWORD).isSigned();
    }

    @AfterAll
    @Step("Очистить куки")
    void clearCookie() {
        clearBrowserCookieAndStorage();
    }

    @Description("Тест проверяет возможность навигации по боковому меню в личном кабинете")
    @Epic("Личный кабинет")
    @Feature("Навигация")
    @Story("Боковое меню")
    @DisplayName("Нажать на вкладку ")
    @Severity(SeverityLevel.MINOR)
    @Issue("89")
    @TmsLink("89")
    @Tag("Navigation")
    @ParameterizedTest(name = "{0}")
    @Execution(ExecutionMode.SAME_THREAD) // В одном потоке. Каждый вызов теста - новый инстанс
    @ValueSource(strings = {"Мои данные", "Услуги", "Мои карты", "Мои займы"})
    public void moveInSidebar(String menuItemName) {
        menu.navigateToPage(menuItemName).verifyCurrentPage();
    }
}