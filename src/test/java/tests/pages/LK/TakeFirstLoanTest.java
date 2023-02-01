package tests.pages.LK;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static constants.Constant.URLS.TEST_PLAN;
import static constants.Constant.UserData.*;


@Disabled
@Epic("Страница авторизации/регистрации JoyMoney")
@Story("Оформить займ")
@DisplayName("test_auth_005")
@Tag("Loan")
@Tag("Smoke")
@Tag("Login")
@Owner("Максим Рожков")
@Link(name = "Тест кейсы(Google Sheets)", url = TEST_PLAN)
public class TakeFirstLoanTest extends BaseTest {

    private static final String randomPhoneNumber;
    private static final String randomEmail;
    private static final String anotherRandomEmail;
    private static final String accountId;
    private static final BufferedWriter accountsLogFileBuffer;
    private static final FileWriter accountFileWriter;
    private static final Faker userData = new Faker();

//    @AfterAll
//    @Step("Очистить куки")
//    public static void clearCookie() {
//        clearBrowserCookiesAndStorage();
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
        anotherRandomEmail = userData.internet().emailAddress();
        randomPhoneNumber = userData.numerify("79########0");
        saveAccountInfo();
    }

    // Значения хендлеров не меняем, по умолчанию будет: 10тыс, 15 дней
    @DisplayName("Оформить займ")
    @Description("Тест проверяет возможность оформить займа")
    @Issue("89")
    @TmsLink("89")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void takeLoan() throws IOException, InterruptedException {

        takeFirstLoan
                .enterPhoneNumber(randomPhoneNumber)
                .enterSms(PASSWORD)
                .acceptAllPolicy()
                .clickNextButton()
                .enterUserName("Терминатор")
                .clickNextButton()
                .enterSurname("Тэтысяча")
                .enterPatronymic("Машина")
                .enterBirthdate("01.01.2000")
                .enterEmail(randomEmail)
                .clickNextButton()
                .enterPassportIdentifier("0000100000")
                .enterPassportIssuerDate("01012020")
                .enterPassportIssuerCode("123456")
                .enterPassportIssuerName()
                .enterBirtPlace("г Москва город Москва")
                .uploadPassport(PASSPORT_FILE)
                .enterSnils("012-345-678 19")
                .enterAddressRegCity("гор Москва")
                .enterAddressRegStreet("Лени")
                .enterAddressRegHouse("1")
                .enterAddressRegFlat("1")
                .selectRadioButtonFactAddressYes()
                .clickOnSecondNextButton()
                .selectTypeJob()
                .inputJobName("Скайнет")
                .inputJobTitle("Агент")
                .inputSalaryLocator("350000")
                .inputExpensesAmount("300000")
                .selectBankruptcyProcessed()
                .inputFriendNumber("79999999999")
                .acceptAllFinalPolicy()
                .clickOnAcceptButton()
                .enterASP(ASP_CODE)
                .fillPersonalDataAgainOrNot(anotherRandomEmail)
                .approveApplication()
                .addCard()
                .getHealthService()
                .getInsuranceService()
                .getCreditService()
                .clickOnGetMoneyButton()
                .enterASP(ASP_CODE);
    }

    private static void saveAccountInfo() {
        if (ACCOUNTS_LOG_DIR.isDirectory()) {
            try {
                String logData = String.format("\n[Test Account %s]\nPhone number:\n\t%s\n", accountId, randomPhoneNumber);
                accountsLogFileBuffer.write(logData);
                accountsLogFileBuffer.close();
                accountFileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
