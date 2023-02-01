package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Logo extends BasePage {

    public final SelenideElement linkLogoLocator = $x("//a[contains(@class, 'logo')]");
    public final SelenideElement navHeaderMenuLocator = $x("//nav[contains(@class, 'header-menu')]");

    /**
     * Click on link "JoyMoney" (logo)
     */
    @Step("Нажать на логотип JoyMoney")
    public Logo clickOnLogo() {
        linkLogoLocator.shouldBe(visible).click();
        return this;
    }

    /**
     * Check that current page is landing by locator
     */
    @Step("Текущая страница - лендинг")
    public void checkCurrentPageIsLanding() {
        navHeaderMenuLocator.shouldBe(visible);
    }
}
