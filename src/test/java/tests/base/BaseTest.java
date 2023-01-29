package tests.base;

import common.Listener;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.LK.Login;
import pages.LK.Menu;
import pages.authorization.Calculator;
import pages.authorization.CheckBoxPolicy;
import pages.authorization.LogoLink;
import pages.authorization.Sms;
import pages.registration.TakeFirstLoan;

import java.io.File;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static common.Config.CLEAR_DOWNLOADS;
import static common.Config.CLEAR_SCREENSHOTS;
import static constants.Constant.URLS.AUTHORIZATION_PAGE;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(Listener.class)
public class BaseTest {

    protected Login login = new Login();
    protected Menu menu = new Menu();
    protected Sms sms = new Sms();
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
    void navigateToAuthPage() {
        open(AUTHORIZATION_PAGE);
        webdriver().shouldHave(url(AUTHORIZATION_PAGE));
    }
}
