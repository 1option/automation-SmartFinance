package common;

public class Config {

    /**
     * Specify the browser and platform for test:
     * CHROME_LINUX
     * FIREFOX_LINUX
     * CHROME_WINDOWS
     */
    public static final String BROWSER_AND_PLATFORM = "CHROME_LINUX";

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

}
