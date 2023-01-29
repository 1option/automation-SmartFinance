package pages.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;

public class BasePage {
    public void javaScriptClickOn(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click();", element);
    }

    public void showHiddenUlAndSelectFirstLi(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].style='overflow:visible;visibility:visible;arguments[0].click()'", element.shouldBe(visible));
        actions().sendKeys(Keys.ENTER).build().perform();
    }
}
