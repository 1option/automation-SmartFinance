package tests.pages.LK;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import tests.base.BaseTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.*;

@DisplayName("test_auth_005")
@Tag("Loan")
@Tag("Smoke")
public class TakeFirstLoanTest extends BaseTest {

    private static final String randomPhoneNumber;
    private static String randomEmail;
    private static final String anotherEmail;
    public static final String accountId;
    private static final BufferedWriter accountsLogFileBuffer;
    public static final FileWriter accountFileWriter;
    private static final Faker userData = new Faker();

//    @AfterAll
//    @Step("Очистить куки")
//    public void clearCookie() {
//        clearBrowserCookieAndStorage();
//    }


    static {
        try {
            accountFileWriter = new FileWriter(ACCOUNTS_LOG_FILE, true);
            accountsLogFileBuffer = new BufferedWriter(accountFileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        accountId = userData.numerify("@id:######");
        randomEmail = userData.internet().emailAddress();
        anotherEmail = userData.internet().emailAddress();
        randomPhoneNumber = userData.numerify("79########0");
        saveAccountInfo();
    }

    @DisplayName("Оформить займ")
    @Tag("Login")
    @Issue(value = "89")
    @TmsLink(value = "89")
    @Description(value = "Тест проверяет возможность оформить займа")
    @Epic(value = "Страница авторизации/регистрации JoyMoney")
    @Story(value = "Оформить займ")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Максим Рожков")
    @Link(name = "Тест кейсы(Google Sheets)", url = JIRA_PAGE)
    @Test
    public void takeLoan() throws IOException, InterruptedException {
        // Значения хендлеров не меняем, по умолчанию будет: 10тыс, 15 дней
        login.enterPhoneNumber(randomPhoneNumber).enterPassword(PASSWORD);

        takeFirstLoan.acceptAllPolicy()
                .clickNextButton()
                .enterUserName("Терминатор")
                .clickNextButton();

        personalInformation();

        if (WebDriverRunner.url().equals("https://my-preprod.joy.money/profile/job")) {
            Selenide.refresh();
            actions().sendKeys(Keys.PAGE_UP).perform();
            $x("(//span[text()='Изменить'])[1]").shouldBe(Condition.visible).click();
            randomEmail = anotherEmail;
            takeFirstLoan.enterEmail(randomEmail)
                    .clickNextButton();
            takeFirstLoan.enterPassportIdentifier("0000100000").enterPassportIssuerDate("01012020");
            actions().sendKeys(Keys.PAGE_DOWN).perform();
            takeFirstLoan.enterAddressRegFlat("1")
                    .clickOnSecondStageButton();
            actions().sendKeys(Keys.PAGE_DOWN).perform();
            takeFirstLoan.acceptAllFinalPolicy()
                    .clickOnAcceptButton();
//            login.enterPasswordOrSms("1234");
        }
        takeFirstLoan.addCard();
    }

    @Step
    public void personalInformation() {
        takeFirstLoan.enterSurname("Тэтысяча")
                .enterPatronymic("Машина")
                .enterBirthdate("01.01.2000")
                .enterEmail(randomEmail) // Случайный email
                .clickNextButton() // Кнопка 'Далее'
                .enterPassportIdentifier("0000100000")
                .enterPassportIssuerDate("01012020")
                .enterPassportIssuerCode("123456")
                .enterPassportIssuerName()
                .enterBirtPlace("г Москва город Москва")
                .uploadPassport(PASSPORT_FILE) // Загрузить паспорт
                .enterSnils("012-345-678 19")
                .enterAddressRegCity("гор Москва")
                .enterAddressRegStreet("Лени")
                .enterAddressRegHouse("1")
                .enterAddressRegFlat("1")
                .selectRadioButtonFactAddressYes() // Совпадает с местом прописки
                .clickOnSecondStageButton() // Кнопка 'Далее'
                .selectTypeJob() // Полная
                .inputJobName("Скайнет")
                .inputJobTitle("Агент")
                .inputSalaryLocator("350000")
                .inputExpensesAmount("300000")
                .selectBankruptcyProcessed() // Не банкрот
                .inputFriendNumber("79999999999")
                .acceptAllFinalPolicy() // Принять все соглашения
                .clickOnAcceptButton(); // Кнопка 'Подтвердить'
        login.enterPassword("1234");
    }

    private static void saveAccountInfo() {
        if (ACCOUNTS_LOG_DIR.isDirectory()) {
            try {
                accountsLogFileBuffer.write(String.format("[Test Account %s]\nPhone number:\n\t%s\n",
                        accountId, randomPhoneNumber));
                accountsLogFileBuffer.close();
                accountFileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
