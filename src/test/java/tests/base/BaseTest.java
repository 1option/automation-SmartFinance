package tests.base;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LK.Sidebar;
import pages.authorization.*;
import pages.base.BasePage;
import pages.registration.TakeFirstLoan;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.CLEAR_REPORTS_DIR;
import static constants.Constant.URLS.AUTHORIZATION_PAGE;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected static BasePage basePage = new BasePage();
    protected static Login login = new Login();
    protected Sidebar sidebar = new Sidebar();
    protected Sms sms = new Sms();
    protected RecoveryLink recoveryLink = new RecoveryLink();
    protected LogoLink logoLink = new LogoLink();
    protected CheckBoxPolicy checkboxPolicy = new CheckBoxPolicy();
    protected Calculator calculator = new Calculator();
    protected TakeFirstLoan takeFirstLoan = new TakeFirstLoan();
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        LOGGER.info("START TIME:" + LocalTime.now());
        LOGGER.info("START clear reports dir: build/reports/");
        File allureResults = new File("target/allure-results/");
        if (allureResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }

        if (CLEAR_REPORTS_DIR) {
            File allureScreenshots = new File("build/reports/tests/");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }
    }

    @BeforeAll
    @Step("Открыть страницу авторизации")
    public void navigateToAuthPage() {
        basePage.goToUrl(AUTHORIZATION_PAGE);
    }

    // Неявная очистка cookies
//    @Step("Очистить cookie")
//    @AfterEach
//    public void clearCookies() {
//        if (!WebDriverRunner.url().equals(AUTHORIZATION_PAGE)) {
//            clearBrowserCookieAndStorage();
//            LOGGER.info("Error -> this page isn't auth page, clearing cookies...");
//        }
//    }
}
