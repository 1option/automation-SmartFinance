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
     * Clear cookies after each iteration
     */
    public static final Boolean CLEAR_COOKIES = true;

    /**
     * To keep the browser open after all tests
     */
    public static final Boolean HOLD_BROWSER_OPEN = false;

    /**
     * Clear the directory with screenshots before starting tests
     */
    public static final Boolean CLEAR_REPORTS_DIR = true;

    static {
        Configuration.holdBrowserOpen = HOLD_BROWSER_OPEN;
        Configuration.browserSize = "1920x1080";
        Configuration.reportsFolder = "build/reports/tests";
        Configuration.browser = BROWSER_NAME;
    }

}
