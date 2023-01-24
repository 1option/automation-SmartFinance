package pages.authorization;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.Base;

public class RecoveryLink extends Base {
    public RecoveryLink(WebDriver driver) {
        super(driver);
    }

    public final By linkLogoLocator = By.xpath("//a[contains(text(),'Я не помню пароль')]");
    public final By h2RecoveryTitleLocator = By.xpath("//h2[contains(text(), 'Восстановление доступа')]");

    @Step("Нажать на ссылку 'Ввести пароль'")
    public RecoveryLink clickOnRecoveryLink() {
        driver.findElement(linkLogoLocator).click();
        return this;
    }

    /**
     * Check that current page is recovery page
     */
    @Step("Текущая страница - восстановление пароля")
    public void checkCurrentPageIsRecoveryPage() {
        Assertions.assertTrue(waitElementIsPresent(h2RecoveryTitleLocator).isDisplayed());
    }

}
