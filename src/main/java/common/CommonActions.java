package common;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constant.URLS.AUTHORIZATION_PAGE;

public class CommonActions {

    /**
     * Create one instance and reuse
     */
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    /**
     * Send POST http request to approve application
     * @param applicationId
     * @throws IOException
     * @throws InterruptedException
     */
    public static void httpPostApproveAgreement(String applicationId) throws IOException, InterruptedException {

        // Format JSON
        String json = "{" +
                "\"applicationId\":\"" + applicationId + "\"," +
                "\"approvedMoney\":\"10000\"," +
                "\"approvedDays\":\"15\"" +
                "}";

        // Create http post request with parameters
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://api-preprod.joy.money:9012/jd-api/application/approve")) // не надо https
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Content-Type", "application/json")
                .build();

//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Clear cookies and local storage
     */
    public static void clearBrowserCookieAndStorage() {
        Selenide.clearBrowserLocalStorage();
        open("chrome://settings/clearBrowserData");
        $x("//html").shouldBe(visible).sendKeys(Keys.chord(Keys.TAB, Keys.ENTER));
        open(AUTHORIZATION_PAGE);
    }
}
