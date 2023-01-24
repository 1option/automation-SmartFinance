package common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static common.CommonActions.clearBrowserCookieAndStorage;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class Listener implements TestWatcher, BeforeAllCallback, AfterEachCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonActions.class);

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        extensionContext.getRoot().getStore(GLOBAL).put(true, this);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        clearBrowserCookieAndStorage();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} - FAILED", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName()
                + String.valueOf(System.currentTimeMillis()).substring(9, 13);
        LOGGER.info("Trying to take screenshot...");
        Selenide.screenshot(screenshotName);
        attachScreenShotToAllure();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenShotToAllure() {
        if (WebDriverRunner.hasWebDriverStarted())
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        else return null;
    }
}
