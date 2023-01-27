package tests.pages.LK;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;

@DisplayName("test_lk_sidebar_001")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Owner("Максим Рожков")
public class SideBarTest extends BaseTest {

    @BeforeAll
    @Step("Войти в ЛК")
    static void signIn(){
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
    @DisplayName("Навигация по боковому меню")
    @Severity(SeverityLevel.MINOR)
    @Issue("89")
    @TmsLink("89")
    @Tag("Navigation")
    @Test()
    public void test_lk_sidebar_001() {
        sidebar.navigateToPage("Мои данные")
                .verifyCurrentPage()
                .navigateToPage("Услуги")
                .verifyCurrentPage()
                .navigateToPage("Мои карты")
                .verifyCurrentPage()
                .navigateToPage("Мои займы")
                .verifyCurrentPage();
    }
}