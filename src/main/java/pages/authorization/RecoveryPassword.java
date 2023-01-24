package pages.authorization;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.Base;

public class RecoveryPassword extends Base {
    public RecoveryPassword(WebDriver driver) {
        super(driver);
    }

    private final By inputPhoneNumberRecoveryLocator = By.name("phone");


}
