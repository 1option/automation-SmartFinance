package pages.authorization;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckBoxPolicy extends BasePage {

    private final ElementsCollection spanDocumentLocator = $$("span[class*=list__link]");
    private final SelenideElement linkPolicyDocumentLocator = $x("//a[contains(@class, 'list__link')]");
    private final SelenideElement divDocumentContentLocator = $x("//div[contains(@class, 'DocumentModal_body')]");
    private final SelenideElement spanCloseDocumentLocator = $x("//span[contains(@class, 'DocumentModal_btn')]");
    private final SelenideElement h1PolicyPageLocator = $x("//h1['Политика обработки персональных данных']");
    private final ElementsCollection labelDocumentCheckBoxesLocator = $$x("//*[contains(@class, 'list__link')]/preceding-sibling::label");
    private final SelenideElement buttonNextLocator = $x("//button[text() = 'Далее']");
    private final SelenideElement checkBoxAcceptAllPolicyLocator = $x("//input[@type='checkbox'][@id='userPolicy']");
    private final ElementsCollection allCheckBoxesLocator = $$x("//div[contains(@class, 'wrapper')]//input");

    @Step("Проверка документов")
    public CheckBoxPolicy verifyDocuments() {
        ElementsCollection documents = spanDocumentLocator;
        SelenideElement linkPolicyDocument = linkPolicyDocumentLocator.shouldBe(visible);

        for (SelenideElement document : documents) {
            // не понимаю почему document.click() не работает, скорее всего кликать нужно другой элемент
            javaScriptExecutorClickOn(document);

            step((String.format("Открыт документ '%s'", document.getText())), () -> {
                        divDocumentContentLocator.shouldBe(visible);
                        spanCloseDocumentLocator.shouldBe(visible);
                    }
            );
        }

        step(("Открылась страница 'Политика обработки персональных данных'"), () -> {
                    javaScriptExecutorClickOn(linkPolicyDocument);

                    // Фокус на новой вкладке
//                    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//                    driver.switchTo().window(tabs.get(1));
//                    Assertions.assertTrue(waitElementIsPresent(h1PolicyPageLocator).isDisplayed());
//                    driver.close();
//                    driver.switchTo().window(tabs.get(0));
                    switchTo().window(1);
                    h1PolicyPageLocator.shouldBe(visible);
                    closeWindow();
                    switchTo().window(0);
                }
        );

        return this;
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
        ElementsCollection documentsCheckBoxes = labelDocumentCheckBoxesLocator;

        for (SelenideElement checkBox : documentsCheckBoxes) {
            javaScriptExecutorClickOn(checkBox);
        }
    }

    public CheckBoxPolicy selectOrDeselectAllCheckboxes() {
        javaScriptExecutorClickOn(checkBoxAcceptAllPolicyLocator);
        return this;
    }

}
