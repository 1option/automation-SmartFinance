package tests.pages.LK;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junitpioneer.jupiter.DisableIfTestFails;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookiesAndStorage;
import static constants.Constant.URLS.TEST_PLAN;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;

@Epic("Личный кабинет")
@Feature("Навигация")
@Story("Боковое меню")
@DisplayName("test_lk_sidebar_001")
@Link(name = "Тест кейсы(Google Sheets)", url = TEST_PLAN)
@Tag("Navigation")
@Tag("Smoke")
@Tag("Login")
@Tag("Positive")
@Owner("Максим Рожков")
@Issue("89")
@TmsLink("89")
@DisableIfTestFails
public class MenuTest extends BaseTest {

    @BeforeEach
    @Step("Войти в личный кабинет")
    void signIn() {
        login.enterPhoneNumber(LOGIN_PHONE_NUMBER).enterPassword(PASSWORD).isSigned();
    }

    @AfterAll
    @Step("Очистить куки")
    void clearCookie() {
        clearBrowserCookiesAndStorage();
    }

        @Description("Тест проверяет возможность навигации по боковому меню в личном кабинете")
        @DisplayName("Нажать на вкладку ")
        @Severity(SeverityLevel.MINOR)
        @Test
        public void moveInSidebar() {
            menu.navigateToPage("Мои данные").verifyCurrentPage()
                    .navigateToPage("Услуги").verifyCurrentPage()
                    .navigateToPage("Мои карты").verifyCurrentPage()
                    .navigateToPage("Мои займы").verifyCurrentPage();
        }
}