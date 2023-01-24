package pages.authorization;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.Base;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;

public class CheckBoxPolicy extends Base {
    public CheckBoxPolicy(WebDriver driver) {
        super(driver);
    }

    public WebElement checkBoxAcceptAllPolicy;
    private final By spanDocumentLocator = By.xpath("//span[contains(@class, 'list__link')]");
    private final By linkPolicyDocumentLocator = By.xpath("//a[contains(@class, 'list__link')]");
    private final By divDocumentContentLocator = By.xpath("//div[contains(@class, 'DocumentModal_body')]");
    private final By spanCloseDocumentLocator = By.xpath("//span[contains(@class, 'DocumentModal_btn')]");
    private final By h1PolicyPageLocator = By.xpath("//h1['Политика обработки персональных данных']");
    private final By labelDocumentCheckBoxesLocator = By.xpath("//*[contains(@class, 'list__link')]/preceding-sibling::label");
    private final By buttonNextLocator = By.xpath("//button[text() = 'Далее']");
    private final By checkBoxAcceptAllPolicyLocator = By.xpath("//input[@type='checkbox'][@id='userPolicy']");
    private final By allCheckBoxesLocator = By.xpath("//div[contains(@class, 'wrapper')]//input");

    @Step("Проверка документов")
    public CheckBoxPolicy verifyDocuments() {
        List<WebElement> documents = waitElementsIsPresent(spanDocumentLocator);
        WebElement linkPolicyDocument = waitElementIsPresent(linkPolicyDocumentLocator);

        for (WebElement document : documents) {
            // не понимаю почему document.click() не работает, скорее всего кликать нужно другой элемент
            javaScriptExecutorClickOn(document);

            step((String.format("Открыт документ '%s'", document.getText())), () -> {
                        Assertions.assertTrue(waitElementIsPresent(divDocumentContentLocator).isDisplayed());
                        javaScriptExecutorClickOn(waitElementIsPresent(spanCloseDocumentLocator));
                    }
            );
        }

        step(("Открылась страница 'Политика обработки персональных данных'"), () -> {
                    javaScriptExecutorClickOn(linkPolicyDocument);

                    // Фокус на новой вкладке
                    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                    driver.switchTo().window(tabs.get(1));
                    Assertions.assertTrue(waitElementIsPresent(h1PolicyPageLocator).isDisplayed());
                    driver.close();
                    driver.switchTo().window(tabs.get(0));
                }
        );

        return this;
    }

    @Step("Кликнуть по всем чекбоксам кроме первого")
    public CheckBoxPolicy verifyDocumentCheckBoxes() {
        selectDocumentCheckBoxes();

        step(("Все чекбоксы отмечены"), () ->
                Assertions.assertTrue(waitElementIsPresent(buttonNextLocator).isEnabled()));

        step(("Кнопка 'Далее' активна"), () ->
                Assertions.assertTrue(waitElementIsPresent(buttonNextLocator).isEnabled()));

        selectOrDeselectAllCheckboxes();

        return this;
    }

    @Step("Кликнуть на первый чекбокс")
    public CheckBoxPolicy verifyAllCheckBoxes() {
        List<WebElement> allCheckBoxes = waitElementsIsPresent(allCheckBoxesLocator);

        selectOrDeselectAllCheckboxes();

        step(("Все чекбоксы отмечены"), () -> {
            for (WebElement checkBox : allCheckBoxes)
                if (!checkBox.isSelected()) Assertions.fail("Не все чекбоксы отмечены!");
                else Assertions.assertTrue(true);
        });

        step(("Кнопка 'Далее' активна"), () ->
                Assertions.assertTrue(waitElementIsPresent(buttonNextLocator).isEnabled()));

        selectOrDeselectAllCheckboxes();

        return this;
    }

    private void selectDocumentCheckBoxes() {
        List<WebElement> documentsCheckBoxes = waitElementsIsPresent(labelDocumentCheckBoxesLocator);

        for (WebElement checkBox : documentsCheckBoxes) {
            javaScriptExecutorClickOn(checkBox);
        }
    }

    public void selectOrDeselectAllCheckboxes() {
        checkBoxAcceptAllPolicy = waitElementIsPresent(checkBoxAcceptAllPolicyLocator);
        javaScriptExecutorClickOn(checkBoxAcceptAllPolicy);
    }

}
