package common;

import com.codeborne.selenide.Configuration;

public class Config {

    /**
     * Specify the browser and platform for test:
     * chrome
     * ie
     * internet explorer
     * edge
     * firefox
     * safari
     */
    public static final String BROWSER_NAME = "chrome";

    /**
     * Clear the directory with screenshots before starting tests
     * */
    public static final Boolean CLEAR_SCREENSHOTS = true;

    public static final Boolean CLEAR_DOWNLOADS = true;

    static {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = BROWSER_NAME;
        Configuration.screenshots = false; // Attach to Allure via Listener class
        Configuration.savePageSource = false;
        Configuration.timeout = 10000; // Default: 4000ms
    }

}
