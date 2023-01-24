package pages.authorization;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.Base;

public class LogoLink extends Base {

    public LogoLink(WebDriver driver) {
        super(driver);
    }

    public final By linkLogoLocator = By.xpath("//a[contains(@class, 'logo')]");
    public final By navHeaderMenuLocator = By.xpath("//nav[contains(@class, 'header-menu')]");

    /**
     * Click on link "JoyMoney" (logo)
     */
    @Step("Нажать на логотип JoyMoney")
    public LogoLink clickOnLogo() {
        driver.findElement(linkLogoLocator).click();
        return this;
    }

    /**
     * Check that current page is landing by locator
     */
    @Step("Текущая страница - лендинг")
    public void checkCurrentPageIsLanding() {
        Assertions.assertTrue(waitElementIsPresent(navHeaderMenuLocator).isDisplayed());
    }
}
