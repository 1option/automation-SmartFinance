package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryLink extends BasePage {

    public final SelenideElement linkLogoLocator = $x("//a[contains(text(),'Я не помню пароль')]");
    public final SelenideElement h2RecoveryTitleLocator = $x("//h2[contains(text(), 'Восстановление доступа')]");

    @Step("Нажать на ссылку 'Ввести пароль'")
    public RecoveryLink clickOnRecoveryLink() {
        linkLogoLocator.shouldBe(visible).click();
        return this;
    }

    /**
     * Check that current page is recovery page
     */
    @Step("Текущая страница - восстановление пароля")
    public void checkCurrentPageIsRecoveryPage() {
        h2RecoveryTitleLocator.shouldBe(visible);
    }

}
