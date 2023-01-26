package pages.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {


    /**
     * The method for navigating to a specific URL
     *
     * @param url open url
     */
    public BasePage goToUrl(String url) {
        open(url);
        return this;
    }

    public BasePage javaScriptExecutorClickOn(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click();", element);
        return this;
    }

    public BasePage showHiddenUlAndSelectFirst(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].style='overflow:visible;visibility:visible;'", element.shouldBe(visible));
        actions().sendKeys(Keys.ENTER).perform();
        return this;
    }
}
