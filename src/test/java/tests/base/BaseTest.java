package tests.base;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LK.Sidebar;
import pages.authorization.*;
import pages.base.BasePage;
import pages.draft.Draft;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static common.Config.CLEAR_REPORTS_DIR;
import static constants.Constant.URLS.AUTHORIZATION_PAGE;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected static BasePage basePage = new BasePage();
    protected static Login login = new Login();
    //    protected LogoLink logoLink = new LogoLink(driver);
//    protected Calculator calculator = new Calculator(driver);
    protected Sidebar sidebar = new Sidebar();
    protected Sms sms = new Sms();
    protected RecoveryLink recoveryLink = new RecoveryLink();
    protected LogoLink logoLink = new LogoLink();
    protected RecoveryPassword recoveryPassword = new RecoveryPassword();
    protected CheckBoxPolicy checkboxPolicy = new CheckBoxPolicy();
    protected Calculator calculator = new Calculator();
    protected TakeFirstLoan takeFirstLoan = new TakeFirstLoan();
    protected Draft draft = new Draft();

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

    @BeforeEach
    @Step("Перейти на страницу авторизации")
    public void navigateToAuthorizationPage() {
        basePage.goToUrl(AUTHORIZATION_PAGE);
        webdriver().shouldHave(url(AUTHORIZATION_PAGE));
    }

//    @AfterAll
//    public void clearCookiesAndLocalStorage() {
//        if (CLEAR_COOKIES) {
//            try {
//                open("chrome://settings/clearBrowserData");
//                $x("//html").shouldBe(visible).sendKeys(Keys.chord(Keys.TAB, Keys.ENTER));
//                CLEAR_COOKIES = !CLEAR_COOKIES;
//            } catch (Exception e) {
//                LOGGER.error("Fail on clearBrowserCookieAndStorage()" + e.getMessage());
//                CLEAR_COOKIES = !CLEAR_COOKIES;
//            }
//        }
//    }
}
