package pages.LK;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Sidebar extends BasePage {

    private final SelenideElement bodyOfMenuItemLocator = $x("(//div[contains(@class, 'body')])[2]");

    @Step("Нажать на вкладку {0}")
    public Sidebar navigateToPage(String menuItemName) {
        $x(String.format("//span[text()='%s']", menuItemName)).shouldBe(visible).click();
        return this;
    }

    @Step("Вкладка успешно открыта")
    public Sidebar verifyCurrentPage() {
        bodyOfMenuItemLocator.shouldBe(visible);
        return this;
    }
}
