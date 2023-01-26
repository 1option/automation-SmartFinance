package common;

import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static common.Config.CLEAR_COOKIES;

public class CommonActions {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonActions.class);

    public static void clearBrowserCookieAndStorage() {
        if (CLEAR_COOKIES) {
            try {
//                Selenide.clearBrowserCookies();
//                Selenide.clearBrowserLocalStorage();
//                Selenide.executeJavaScript("window.sessionStorage.clear()");
                open("chrome://settings/clearBrowserData");
                $x("//html").shouldBe(visible).sendKeys(Keys.chord(Keys.TAB, Keys.ENTER));
            } catch (Exception e) {
                LOGGER.error("Fail on clearBrowserCookieAndStorage()" + e.getMessage());
            }
        }
    }
}
