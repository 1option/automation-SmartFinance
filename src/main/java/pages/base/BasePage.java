package pages.base;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    /**
     * The method for navigating to a specific URL
     * @param url open url
     *
     */
    public void goToUrl(String url) {
        open(url);
    }

//    public void javaScriptExecutorClickOn(WebElement element) {
//        executor.executeScript("arguments[0].click();", element);
//    }
//
//    public BasePage showHiddenUlAndSelectFirst(final By locator) {
//        executor.executeScript("arguments[0].style='overflow:visible;visibility:visible;'", waitElementIsPresent(locator));
//        action.sendKeys(Keys.ENTER).build().perform();
//        return this;
//    }

}
