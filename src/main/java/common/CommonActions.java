package common;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constant.URLS.AUTHORIZATION_PAGE;

public class CommonActions {

    public static void clearBrowserCookieAndStorage() {
        open("chrome://settings/clearBrowserData");
        $x("//html").shouldBe(visible).sendKeys(Keys.chord(Keys.TAB, Keys.ENTER));
        open(AUTHORIZATION_PAGE);
    }
}
