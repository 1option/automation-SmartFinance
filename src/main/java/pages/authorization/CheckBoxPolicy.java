package pages.authorization;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static constants.Locators.buttonNextLocator;
import static io.qameta.allure.Allure.step;

public class CheckBoxPolicy extends BasePage {

    private final ElementsCollection spanDocumentLocator = $$("span[class*=list__link]");
    private final SelenideElement linkPolicyDocumentLocator = $x("//a[contains(@class, 'list__link')]");
    private final SelenideElement divDocumentContentLocator = $x("//div[contains(@class, 'DocumentModal_body')]");
    private final SelenideElement spanCloseDocumentLocator = $x("//span[contains(@class, 'DocumentModal_btn')]");
    private final SelenideElement h1PolicyPageLocator = $x("//h1[text()='Политика обработки персональных данных']");
    private final ElementsCollection labelDocumentCheckBoxesLocator = $$x("//*[contains(@class, 'list__link')]/preceding-sibling::label");
    private final SelenideElement checkBoxAcceptAllPolicyLocator = $x("//input[@type='checkbox'][@id='userPolicy']"); // m
    private final ElementsCollection allCheckBoxesLocator = $$x("//div[contains(@class, 'wrapper')]//input");

    @Step("Проверка документов")
    public void verifyDocuments() {
        SelenideElement linkPolicyDocument = linkPolicyDocumentLocator.shouldBe(visible);

        for (SelenideElement document : spanDocumentLocator) {
            // не понимаю почему document.click() не работает, скорее всего кликать нужно другой элемент
            javaScriptClickOn(document);

            step((String.format("Открыт документ '%s'", document.getText())), () -> {
                        divDocumentContentLocator.shouldBe(visible);
                        spanCloseDocumentLocator.shouldBe(visible);
                    }
            );
        }

        step(("Открылась страница 'Политика обработки персональных данных'"), () -> {
                    javaScriptClickOn(linkPolicyDocument);
                    switchTo().window(1);
                    h1PolicyPageLocator.shouldBe(visible);
                    closeWindow();
                    switchTo().window(0);
                }
        );

    }

    @Step("Кликнуть по всем чекбоксам кроме первого")
    public CheckBoxPolicy verifyDocumentCheckBoxes() {
        selectDocumentCheckBoxes();

        step(("Все чекбоксы отмечены"), () ->
                buttonNextLocator.shouldBe(visible)
        );

        step(("Кнопка 'Далее' активна"), () ->
                buttonNextLocator.shouldBe(enabled)
        );

        selectOrDeselectAllCheckboxes();

        return this;
    }

    @Step("Кликнуть на первый чекбокс")
    public CheckBoxPolicy verifyAllCheckBoxes() {
        ElementsCollection allCheckBoxes = allCheckBoxesLocator;

        selectOrDeselectAllCheckboxes();

        step(("Все чекбоксы отмечены"), () -> {
            for (SelenideElement checkBox : allCheckBoxes)
                if (!checkBox.isSelected()) Assertions.fail("Не все чекбоксы отмечены!");
                else Assertions.assertTrue(true);
        });

        step(("Кнопка 'Далее' активна"), () ->
                buttonNextLocator.shouldBe(enabled)
        );

        selectOrDeselectAllCheckboxes();

        return this;
    }

    private void selectDocumentCheckBoxes() {

        for (SelenideElement checkBox : labelDocumentCheckBoxesLocator) {
            javaScriptClickOn(checkBox);
        }
    }

    private void selectOrDeselectAllCheckboxes() {
        javaScriptClickOn(checkBoxAcceptAllPolicyLocator);
    }

}
