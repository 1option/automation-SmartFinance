package pages.LK;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.base.BasePage;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static constants.Constant.URLS.*;

public class Menu extends BasePage {

    private String menuItem;
    private final SelenideElement bodyOfMenuItemLocator = $x("(//*[contains(@class, 'User_body')])[2]");

    @Step("Нажать на вкладку {0}")
    public Menu navigateToPage(String menuItemName) {
        menuItem = menuItemName;
        $x(String.format("//span[text()='%s']", menuItemName)).shouldBe(visible).click();
        return this;
    }

    @Step("Вкладка успешно открыта")
    public Menu verifyCurrentPage() {
        bodyOfMenuItemLocator.shouldBe(visible);

        if (Objects.equals(menuItem, "Мои данные")) {
            bodyOfMenuItemLocator.shouldHave(text(menuItem));
            webdriver().shouldHave(url(USER_PERSONAL_DATA_PAGE));
        }

        if (Objects.equals(menuItem, "Услуги")) {
            bodyOfMenuItemLocator.shouldHave(text(menuItem));
            webdriver().shouldHave(url(USER_SERVICES_PAGE));
        }

        if (Objects.equals(menuItem, "Мои карты")) {
            bodyOfMenuItemLocator.shouldHave(text(menuItem));
            webdriver().shouldHave(url(USER_CARDS_PAGE));
        }

        if (Objects.equals(menuItem, "Мои займы")) {
            bodyOfMenuItemLocator.shouldHave(text("Займ №"));
            webdriver().shouldHave(url(USER_LOANS_PAGE));
        }

        return this;
    }
}
