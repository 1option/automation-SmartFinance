package pages.registration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import common.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.base.BasePage;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static constants.Constant.URLS.LK_PAGE;
import static constants.Constant.UserData.PAN_0;
import static constants.Constant.UserData.SMS;
import static constants.Locators.*;

public class TakeFirstLoan extends BasePage {

    private final SelenideElement inputSurnameLocator = $(byName("surname"));
    private final SelenideElement inputPatronymicLocator = $(byName("patronymic"));
    private final SelenideElement inputBirthdateLocator = $(byName("birthdate"));
    private final SelenideElement inputEmailLocator = $(byName("email"));
    private final SelenideElement inputPassportIdentifierLocator = $(byName("passportIdentifier"));
    private final SelenideElement inputPassportIssuerDateLocator = $(byName("passportIssueDate"));
    private final SelenideElement inputPassportIssuerCodeLocator = $(byName("passportIssuerCode"));
    private final SelenideElement liPassportIssuerNameValueLocator = $x("(//ul)[1]/li[1]");
    private final SelenideElement inputBirtPlaceLocator = $(byName("birthPlace"));
    private final SelenideElement inputUploadPassport = $(byName("uploadPassport"));
    private final SelenideElement inputSnilsLocator = $(byName("snils"));
    private final SelenideElement inputAddressRegCity = $(byName("addressRegCity"));
    private final SelenideElement inputAddressRegStreet = $(byName("addressRegStreet"));
    private final SelenideElement inputAddressRegHouse = $(byName("addressRegHouse"));
    private final SelenideElement inputAddressRegFlat = $(byName("addressRegFlat"));
    private final SelenideElement radioButtonAddressFactYesLocator = $x("(//span[contains(@class, 'radio')])[2]");
    private final SelenideElement ulAddressLocator = $x("(//ul)[3]");
    private final SelenideElement buttonSecondStageLocator = $x("(//button[text() = 'Далее'])[2]");
    private final SelenideElement inputJobTypeLocator = $(byName("jobType"));
    private final SelenideElement inputJobNameLocator = $(byName("jobCompanyName"));
    private final SelenideElement inputJobTitleLocator = $(byName("jobTitle"));
    private final SelenideElement inputSalaryLocator = $(byName("salary"));
    private final SelenideElement inputExpensesAmountLocator = $(byName("expensesAmount"));
    private final SelenideElement radioBankruptcyProcessedLocator = $x("(//span[contains(@class, 'radio')])[6]");
    private final SelenideElement inputFriendPhone = $(byName("friendPhone"));
    private final SelenideElement checkBoxAcceptAllFinalPolicy = $x("//input[@name='jobPolicy']");
    private final SelenideElement buttonAccept = $x("//button[text() = 'Подтвердить']");
    private final SelenideElement buttonAddCard = $x("//button[@id='add_card']");
    private final SelenideElement inputPaymentTools = $x("//input[@name='paymentTools']");
    private final SelenideElement iframePayment = $x("//iframe[@name='payment']");
    private final SelenideElement inputPan = $x("//input[@name='pan']");
    private final SelenideElement buttonGetMoney = $x("//button[@id='get_money']");
    private final SelenideElement inputAsp = $x("//input[@name='asp']");
    private final SelenideElement spanApplicationId = $x("//span[contains(@class, 'Numb')]");
    private final SelenideElement divCloseNotice = $x("//div[contains(@class,'close')]");
    private final SelenideElement spanCloseIframe = $x("//span[contains(@class, 'close')]");

    @Step("Ввести имя")
    public TakeFirstLoan enterUserName(String name) {
        inputNameLocator.shouldBe(visible).sendKeys(name);
        return this;
    }

    @Step("Ввести фамилию")
    public TakeFirstLoan enterSurname(String surname) {
        inputSurnameLocator.clear();
        inputSurnameLocator.shouldBe(visible).sendKeys(surname);
        return this;
    }

    @Step("Ввести отчество")
    public TakeFirstLoan enterPatronymic(String patronymic) {
        inputPatronymicLocator.clear();
        inputPatronymicLocator.shouldBe(visible).sendKeys(patronymic);
        return this;
    }

    @Step("Ввести дату рождения")
    public TakeFirstLoan enterBirthdate(String birthDate) {
        inputBirthdateLocator.clear();
        inputBirthdateLocator.shouldBe(visible).sendKeys(birthDate);
        return this;
    }

    @Step("Ввести email")
    public TakeFirstLoan enterEmail(String email) {
        inputEmailLocator.sendKeys(Keys.CONTROL + "A");
        inputEmailLocator.sendKeys(Keys.BACK_SPACE);
        inputEmailLocator.shouldBe(visible).sendKeys(email);
        return this;
    }

    @Step("Ввести серию и номер паспорта")
    public TakeFirstLoan enterPassportIdentifier(String passportIdentifier) {
        inputPassportIdentifierLocator.clear();
        inputPassportIdentifierLocator.shouldBe(visible).sendKeys(passportIdentifier);
        return this;
    }

    @Step("Ввести дату выдачи паспорта")
    public TakeFirstLoan enterPassportIssuerDate(String passportIssuerDate) {
        inputPassportIssuerDateLocator.clear();
        inputPassportIssuerDateLocator.shouldBe(visible).sendKeys(passportIssuerDate);
        return this;
    }

    @Step("Ввести код подразделения")
    public TakeFirstLoan enterPassportIssuerCode(String passportIssuerCode) {
        inputPassportIssuerCodeLocator.clear();
        inputPassportIssuerCodeLocator.shouldBe(visible).sendKeys(passportIssuerCode);
        return this;
    }

    @Step("Ввести название подразделения")
    public TakeFirstLoan enterPassportIssuerName() {
        showHiddenUlAndSelectFirstLi(liPassportIssuerNameValueLocator);
        liPassportIssuerNameValueLocator.shouldBe(visible);
        return this;
    }

    @Step("Ввести место рождения")
    public TakeFirstLoan enterBirtPlace(String birtPlace) {
        inputBirtPlaceLocator.shouldBe(visible).sendKeys(birtPlace);
        actions().sendKeys(Keys.PAGE_DOWN).perform();
        return this;
    }

    @Step("Загрузить фото паспорта")
    public TakeFirstLoan uploadPassport(File passportPhoto) {
        inputUploadPassport.uploadFile(passportPhoto);
        return this;
    }

    @Step("Ввести снилс")
    public TakeFirstLoan enterSnils(String snils) {
        inputSnilsLocator.shouldBe(visible).sendKeys(snils);
        return this;
    }

    @Step("Ввести населенный пункт")
    public TakeFirstLoan enterAddressRegCity(String addressRegCity) {
        inputAddressRegCity.shouldBe(visible).sendKeys(addressRegCity);
        showHiddenUlAndSelectFirstLi(ulAddressLocator);
        return this;
    }

    @Step("Ввести улицу")
    public TakeFirstLoan enterAddressRegStreet(String addressRegStreet) {
        inputAddressRegStreet.shouldBe(visible).sendKeys(addressRegStreet);
        showHiddenUlAndSelectFirstLi(ulAddressLocator);
        return this;
    }

    @Step("Ввести дом")
    public TakeFirstLoan enterAddressRegHouse(String addressRegHouse) {
        inputAddressRegHouse.clear();
        inputAddressRegHouse.shouldBe(visible).sendKeys(addressRegHouse);
        showHiddenUlAndSelectFirstLi(ulAddressLocator);
        return this;
    }

    @Step("Ввести квартиру")
    public TakeFirstLoan enterAddressRegFlat(String addressRegFlat) {
        inputAddressRegFlat.clear();
        inputAddressRegFlat.shouldBe(visible).sendKeys(addressRegFlat);
        return this;
    }

    @Step("Проживаете по месту регистрации? Да")
    public TakeFirstLoan selectRadioButtonFactAddressYes() {
        radioButtonAddressFactYesLocator.shouldBe(visible).click();
        return this;
    }

    @Step("Выберите тип занятости")
    public TakeFirstLoan selectTypeJob() {
        inputJobTypeLocator.shouldBe(visible).click();
        showHiddenUlAndSelectFirstLi(inputJobTypeLocator);
        return this;
    }

    @Step("Укажите название организации")
    public TakeFirstLoan inputJobName(String jobName) {
        inputJobNameLocator.clear();
        inputJobNameLocator.shouldBe(visible).sendKeys(jobName);
        return this;
    }

    @Step("Укажите должность")
    public TakeFirstLoan inputJobTitle(String jobTitle) {
        inputJobTitleLocator.clear();
        inputJobTitleLocator.shouldBe(visible).sendKeys(jobTitle);
        return this;
    }

    @Step("Укажите доход в месяц")
    public TakeFirstLoan inputSalaryLocator(String salary) {
        inputSalaryLocator.shouldBe(visible).sendKeys(salary);
        return this;
    }

    @Step("Укажите расходы в месяц")
    public TakeFirstLoan inputExpensesAmount(String expensesAmount) {
        inputExpensesAmountLocator.shouldBe(visible).sendKeys(expensesAmount);
        return this;
    }

    @Step("Банкротство за последние 3 года? Нет")
    public TakeFirstLoan selectBankruptcyProcessed() {
        radioBankruptcyProcessedLocator.shouldBe(visible).click();
        return this;
    }

    @Step("Дополнительный контактный телефон")
    public TakeFirstLoan inputFriendNumber(String friendPhone) {
        inputFriendPhone.shouldBe(visible).sendKeys(friendPhone);
        return this;
    }

    @Step("Принять соглашения (в начале)")
    public TakeFirstLoan acceptAllPolicy() {
        javaScriptClickOn(checkBoxAcceptAllPolicyLocator);
        return this;
    }

    @Step("Принять соглашения(в конце)")
    public TakeFirstLoan acceptAllFinalPolicy() {
        javaScriptClickOn(checkBoxAcceptAllFinalPolicy);
        return this;
    }

    @Step("Нажать Подтвердить")
    public void clickOnAcceptButton() {
        buttonAccept.shouldBe(visible).click();
    }

    public TakeFirstLoan clickOnSecondStageButton() {
        buttonSecondStageLocator.shouldBe(visible).click();
        return this;
    }

    public TakeFirstLoan clickNextButton() {
        buttonNextLocator.shouldBe(visible).click();
        return this;
    }

    public void addCard() throws IOException, InterruptedException {
        webdriver().shouldHave(url(LK_PAGE));
        approveApplication();
        Selenide.refresh();
        divCloseNotice.shouldBe(visible).click();
        buttonAddCard.shouldBe(visible).click();
        showHiddenUlAndSelectFirstLi(inputPaymentTools.shouldBe(visible));
        actions().sendKeys(Keys.chord(Keys.TAB, Keys.ENTER)).build().perform();
        Selenide.switchTo().frame(iframePayment);
        inputPan.shouldBe(visible).clear();
        inputPan.shouldBe(visible).sendKeys(PAN_0);
        inputPan.shouldBe(visible).pressEnter();
        Selenide.switchTo().parentFrame();
        javaScriptClickOn(spanCloseIframe);
        iframePayment.shouldBe(disappear);
        actions().sendKeys(Keys.PAGE_DOWN).perform();
        buttonGetMoney.shouldBe(visible).click();
        inputAsp.shouldBe(visible).sendKeys(SMS);
    }

    public void approveApplication() throws IOException, InterruptedException {
        // Отправка http request POST
        String applicationId = spanApplicationId.shouldBe(visible).getText();
        applicationId = applicationId.replaceAll("[^0-9]", "");
        CommonActions.httpPostApproveAgreement(applicationId);
    }

}
