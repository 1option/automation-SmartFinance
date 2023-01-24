package tests.base;

import common.CommonActions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LK.Sidebar;
import pages.authorization.*;
import pages.base.Base;
import pages.base.Steps;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;
import static constants.Constant.URLS.AUTHORIZATION_PAGE;
import static io.qameta.allure.Allure.step;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();
    protected Base base = new Base(driver);
    protected Login login = new Login(driver);
    protected LogoLink logoLink = new LogoLink(driver);
    protected Calculator calculator = new Calculator(driver);
    protected Sidebar sidebar = new Sidebar(driver);
    protected Sms sms = new Sms(driver);
    protected RecoveryLink recoveryLink = new RecoveryLink(driver);
    protected RecoveryPassword recoveryPassword = new RecoveryPassword(driver);
    protected CheckBoxPolicy checkboxPolicy = new CheckBoxPolicy(driver);
    protected TakeFirstLoan takeFirstLoan = new TakeFirstLoan(driver);
    protected Steps steps = new Steps(driver);

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
    public void navigateToAuthorizationPage() {
        step("Перейти на страницу авторизации", () ->
                base.goToUrl(AUTHORIZATION_PAGE)
        );
        Assertions.assertEquals(AUTHORIZATION_PAGE, driver.getCurrentUrl());
    }

    @AfterEach
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear();");
        }
    }

    @AfterAll
    void closeBrowser() {
        if (!HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }

}
