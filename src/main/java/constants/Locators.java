package constants;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class Locators {

    public static final SelenideElement buttonNextLocator = $x("//button[text() = 'Далее']");
    public static final SelenideElement inputPasswordLocator = $x("//input[contains(@type,'password')]");
    public static final SelenideElement inputSmsCodeLocator = $x("//input[contains(@type,'password')]");
    public static final SelenideElement inputPhoneNumberLocator = $x("//input[contains(@name,'hone')]");

}
