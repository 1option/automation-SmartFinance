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
     */
    public static final Boolean CLEAR_REPORTS_DIR = true;

    static {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.reportsFolder = "build/reports/tests";
        Configuration.browser = BROWSER_NAME;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.timeout = 20000;
    }

}
