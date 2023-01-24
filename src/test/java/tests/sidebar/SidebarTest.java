package tests.sidebar;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.PASSWORD;
import static constants.Constant.UserData.LOGIN_PHONE_NUMBER;

@DisplayName("test_lk_sidebar_001")
@Tag("Smoke")
public class SidebarTest extends BaseTest {

    @BeforeAll
    public void login() {
        steps.enterPhoneNumber(LOGIN_PHONE_NUMBER)
                .enterPassword(PASSWORD)
                .clickNextButton()
                .isSigned();
    }

    @DisplayName("Навигация по разделам")
    @Tag("LK")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест проверяет возможность навигации по боковому меню в личном кабинете")
    @Epic(value = "Личный кабинет")
    @Feature(value = "Навигация")
    @Story(value = "Боковое меню")
    @Severity(value = SeverityLevel.MINOR)
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Test
    public void checkNavigationInSidebar() {
        sidebar.navigateToPage("Мои данные")
                .verifyCurrentPage()
                .navigateToPage("Услуги")
                .verifyCurrentPage()
                .navigateToPage("Мои карты")
                .verifyCurrentPage()
                .navigateToPage("Мои займы")
                .verifyCurrentPage();

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
