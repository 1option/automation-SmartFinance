package tests.base;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LK.SideBar;
import pages.authorization.*;
import pages.base.BasePage;
import pages.registration.TakeFirstLoan;

import java.io.File;
import java.util.Objects;

import static common.Config.CLEAR_DOWNLOADS;
import static common.Config.CLEAR_SCREENSHOTS;
import static constants.Constant.URLS.AUTHORIZATION_PAGE;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected BasePage basePage = new BasePage();
    protected static Login login = new Login();
    protected SideBar sidebar = new SideBar();
    protected Sms sms = new Sms();
    protected RecoveryLink recoveryLink = new RecoveryLink();
    protected LogoLink logoLink = new LogoLink();
    protected CheckBoxPolicy checkboxPolicy = new CheckBoxPolicy();
    protected Calculator calculator = new Calculator();
    protected TakeFirstLoan takeFirstLoan = new TakeFirstLoan();

    static {
        if (CLEAR_SCREENSHOTS) {
            File allureScreenshots = new File("build/reports/tests/");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }

        if (CLEAR_DOWNLOADS) {
            File selenideDownloads = new File("build/downloads/");
            for (File item : Objects.requireNonNull(selenideDownloads.listFiles()))
                item.delete();
        }
    }

    @BeforeAll
    @Step("Открыть страницу авторизации")
    public void navigateToAuthPage() {
        basePage.goToUrl(AUTHORIZATION_PAGE);
    }
}
