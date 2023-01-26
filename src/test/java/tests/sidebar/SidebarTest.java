package tests.sidebar;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;
import static constants.Constant.UserData.PASSWORD;

@DisplayName("test_lk_sidebar_001")
@Tag("LK")
@Issue(value = "89")
@TmsLink(value = "89")
@Epic(value = "Личный кабинет")
@Feature(value = "Навигация")
@Story(value = "Боковое меню")
@Severity(value = SeverityLevel.MINOR)
@Owner(value = "Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
@Tag("Smoke")
public class SidebarTest extends BaseTest {

    @DisplayName("Навигация по разделам")
    @Description(value = "Тест проверяет возможность навигации по боковому меню в личном кабинете")
    @Test
    public void checkNavigationInSidebar() {
        login.enterPhoneNumber(LOGIN_PHONE_NUMBER)
                .enterPasswordOrSms(PASSWORD)
                .isSigned();

        sidebar.navigateToPage("Мои данные")
                .verifyCurrentPage()
                .navigateToPage("Услуги")
                .verifyCurrentPage()
                .navigateToPage("Мои карты")
                .verifyCurrentPage()
                .navigateToPage("Мои займы")
                .verifyCurrentPage();
        clearBrowserCookieAndStorage();


        /*
         * Существуют аккаунты без вкладки "Услуги" в боковом меню
         */
//        sidebar.navigateToPage("Мои данные")
//                .verifyCurrentPage()
//                .navigateToPage("Мои карты")
//                .verifyCurrentPage();

        // Почему то вкладка Услуги не появляется как все остальны, приходится явно открывать страницу
//        try {
//            base.goToUrl(SERVICES_PAGE);
//            sidebar.navigateToPage("Услуги")
//                    .verifyCurrentPage();
//        } catch (Exception ignore) {
//        } finally {
//            sidebar.navigateToPage("Мои займы")
//                    .verifyCurrentPage();
//        }
    }
}
