package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static common.Config.BROWSER_AND_PLATFORM;
import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM) {
            case "CHROME_LINUX" -> {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
            }
            case "FIREFOX_LINUX" -> {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
            }
            case "CHROME_WINDOWS" -> {
                System.setProperty("webdriver.geckodriver.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
            default -> Assertions.fail("Incorrect browser name" + BROWSER_AND_PLATFORM);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
