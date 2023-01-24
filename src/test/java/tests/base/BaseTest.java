package tests.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.authorization.Login;
import pages.base.BasePage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.CLEAR_REPORTS_DIR;

public class BaseTest {

    protected BasePage basePage = new BasePage();
    protected Login login = new Login();
//    protected LogoLink logoLink = new LogoLink(driver);
//    protected Calculator calculator = new Calculator(driver);
//    protected Sidebar sidebar = new Sidebar(driver);
//    protected Sms sms = new Sms(driver);
//    protected RecoveryLink recoveryLink = new RecoveryLink(driver);
//    protected RecoveryPassword recoveryPassword = new RecoveryPassword(driver);
//    protected CheckBoxPolicy checkboxPolicy = new CheckBoxPolicy(driver);
//    protected TakeFirstLoan takeFirstLoan = new TakeFirstLoan(driver);
//    protected Steps steps = new Steps(driver);

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

//    @BeforeAll
//    public void navigateToAuthorizationPage() {
//        step("Перейти на страницу авторизации", () ->
//                basePage.goToUrl(AUTHORIZATION_PAGE)
//        );
//        Assertions.assertEquals(AUTHORIZATION_PAGE, driver.getCurrentUrl());
//    }

}
