package tests.takeloan;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static constants.Constant.URLS.JIRA_PAGE;
import static constants.Constant.UserData.ACCOUNTS_LOG_DIR;
import static constants.Constant.UserData.ACCOUNTS_LOG_FILE;

@DisplayName("test_auth_005")
@Tag("Smoke")
public class TakeFirstLoanTest extends BaseTest {

    private static final String randomPhoneNumber;
    private static final String randomEmail;
    public static final String accountId;
    private static final File passport;
    private static final BufferedWriter accountsLogFileBuffer;
    public static final FileWriter accountFileWriter;
    private static final Faker userData = new Faker();

    static {
        try {
            accountFileWriter = new FileWriter(ACCOUNTS_LOG_FILE, true);
            accountsLogFileBuffer = new BufferedWriter(accountFileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        accountId = userData.numerify("@id:######");
        passport = new File("src/test/files/passport.jpg");
        randomEmail = userData.internet().emailAddress();
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
    public void takeLoan() {
        //Значения хендлеров не меняем, по умолчанию будет: 10тыс, 15 дней
        steps.enterPhoneNumber(randomPhoneNumber) // Случайный телефон (0 - автоодобрение)
                .enterSmsCode("123456")
                .acceptAllPolicy() // Принять все соглашения
                .clickNextButton(); // Кнопка 'Далее'
        sms.checkValidState(); // Проверить что введен правильный смс-код и отобразилась кнопка 'Далее'
        takeFirstLoan.enterUserName("Терминатор");
        steps.clickNextButton(); // Кнопка 'Далее'
        takeFirstLoan.enterSurname("Тэтысяча")
                .enterPatronymic("Машина")
                .enterBirthdate("01.01.2000")
                .enterEmail(randomEmail); // Случайный email
        steps.clickNextButton(); // Кнопка 'Далее'
        takeFirstLoan.enterPassportIdentifier("0000100000")
                .enterPassportIssuerDate("01012020")
                .enterPassportIssuerCode("123456")
                .enterPassportIssuerName("тест0 тест0 тест0")
                .enterBirtPlace("гор Москва")
                .uploadPassport(passport.getAbsolutePath()) // Загрузить паспорт
                .enterSnils("012-345-678 19")
                .enterAddressRegCity("гор Москва")
                .enterAddressRegStreet("Арбат")
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
                .acceptAllPolicy() // Принять все соглашения
                .clickOnAcceptButton(); // Кнопка 'Подтвердить'
        steps.enterSmsCode("1234");
        driver.navigate().refresh(); // Перезагружаем страницу для автоодобрения
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
