package pages.authorization;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base.Base;

public class TakeFirstLoan extends Base {

    public TakeFirstLoan(WebDriver driver) {
        super(driver);
    }

    private final By inputNameLocator = By.name("userName");
    private final By inputSurnameLocator = By.name("surname");
    private final By inputPatronymicLocator = By.name("patronymic");
    private final By inputBirthdateLocator = By.name("birthdate");
    private final By inputEmailLocator = By.name("email");
    private final By inputPassportIdentifierLocator = By.name("passportIdentifier");
    private final By inputPassportIssuerDateLocator = By.name("passportIssueDate");
    private final By inputPassportIssuerCodeLocator = By.name("passportIssuerCode");
    private final By liPassportIssuerNameValueLocator = By.xpath("(//ul)[1]/li[1]");
    private final By inputBirtPlaceLocator = By.name("birthPlace");
    private final By inputUploadPassport = By.name("uploadPassport");
    private final By inputSnilsLocator = By.name("snils");
    private final By inputAddressRegCity = By.name("addressRegCity");
    private final By inputAddressRegStreet = By.name("addressRegStreet");
    private final By inputAddressRegHouse = By.name("addressRegHouse");
    private final By inputAddressRegFlat = By.name("addressRegFlat");
    private final By radioButtonAddressFactYesLocator = By.xpath("(//span[contains(@class, 'radio')])[2]");
    private final By ulAddressLocator = By.xpath("(//ul)[3]");
    private final By buttonSecondStageLocator = By.xpath("(//button[text() = 'Далее'])[2]");
    private final By inputJobTypeLocator = By.name("jobType");
    private final By inputJobNameLocator = By.name("jobCompanyName");
    private final By inputJobTitleLocator = By.name("jobTitle");
    private final By inputSalaryLocator = By.name("salary");
    private final By inputExpensesAmountLocator = By.name("expensesAmount");
    private final By radioBankruptcyProcessedLocator = By.xpath("(//span[contains(@class, 'radio')])[6]");
    private final By inputFriendPhone = By.name("friendPhone");
    private final By checkBoxAcceptAllPolicy = By.xpath("//input[@name='jobPolicy']");
    private final By buttonAccept = By.xpath("//button[text() = 'Подтвердить']");


    @Step("Ввести имя")
    public TakeFirstLoan enterUserName(String name) {
        waitElementIsPresent(inputNameLocator).sendKeys(name);
        return this;
    }

    @Step("Ввести фамилию")
    public TakeFirstLoan enterSurname(String surname) {
        waitElementIsPresent(inputSurnameLocator).sendKeys(surname);
        return this;
    }

    @Step("Ввести отчество")
    public TakeFirstLoan enterPatronymic(String patronymic) {
        waitElementIsPresent(inputPatronymicLocator).sendKeys(patronymic);
        return this;
    }

    @Step("Ввести дату рождения")
    public TakeFirstLoan enterBirthdate(String birthDate) {
        waitElementIsPresent(inputBirthdateLocator).sendKeys(birthDate);
        return this;
    }

    @Step("Ввести email")
    public TakeFirstLoan enterEmail(String email) {
        waitElementIsPresent(inputEmailLocator).sendKeys(email);
        return this;
    }

    @Step("Ввести серию и номер паспорта")
    public TakeFirstLoan enterPassportIdentifier(String passportIdentifier) {
        waitElementIsPresent(inputPassportIdentifierLocator).sendKeys(passportIdentifier);
        return this;
    }

    @Step("Ввести дату выдачи паспорта")
    public TakeFirstLoan enterPassportIssuerDate(String passportIssuerDate) {
        waitElementIsPresent(inputPassportIssuerDateLocator).sendKeys(passportIssuerDate);
        return this;
    }

    @Step("Ввести код подразделения")
    public TakeFirstLoan enterPassportIssuerCode(String passportIssuerCode) {
        waitElementIsPresent(inputPassportIssuerCodeLocator).sendKeys(passportIssuerCode);
        return this;
    }

    @Step("Ввести название подразделения")
    public TakeFirstLoan enterPassportIssuerName(String passportIssuerName) {
        waitElementIsPresent(liPassportIssuerNameValueLocator).click();
        return this;
    }

    @Step("Ввести место рождения")
    public TakeFirstLoan enterBirtPlace(String birtPlace) {
        waitElementIsPresent(inputBirtPlaceLocator).sendKeys(birtPlace);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        return this;
    }

    @Step("Загрузить фото паспорта")
    public TakeFirstLoan uploadPassport(String passportPhoto) {
        waitElementIsPresent(inputUploadPassport).sendKeys(passportPhoto);
        return this;
    }

    @Step("Ввести снилс")
    public TakeFirstLoan enterSnils(String snils) {
        waitElementIsPresent(inputSnilsLocator).sendKeys(snils);
        return this;
    }

    @Step("Ввести населенный пункт")
    public TakeFirstLoan enterAddressRegCity(String addressRegCity) {
        waitElementIsPresent(inputAddressRegCity).sendKeys(addressRegCity);
        showHiddenUlAndSelectFirst(ulAddressLocator);
        return this;
    }

    @Step("Ввести улицу")
    public TakeFirstLoan enterAddressRegStreet(String addressRegStreet) {
        waitElementIsPresent(inputAddressRegStreet).sendKeys(addressRegStreet);
        showHiddenUlAndSelectFirst(ulAddressLocator);
        return this;
    }

    @Step("Ввести дом")
    public TakeFirstLoan enterAddressRegHouse(String addressRegHouse) {
        waitElementIsPresent(inputAddressRegHouse).sendKeys(addressRegHouse);
        showHiddenUlAndSelectFirst(ulAddressLocator);
        return this;
    }

    @Step("Ввести квартиру")
    public TakeFirstLoan enterAddressRegFlat(String addressRegFlat) {
        waitElementIsPresent(inputAddressRegFlat).sendKeys(addressRegFlat);
        return this;
    }

    @Step("Проживаете по месту регистрации? Да")
    public TakeFirstLoan selectRadioButtonFactAddressYes() {
        waitElementIsPresent(radioButtonAddressFactYesLocator).click();
        return this;
    }

    @Step("Выберите тип занятости")
    public TakeFirstLoan selectTypeJob() {
        waitElementIsPresent(inputJobTypeLocator).click();
        showHiddenUlAndSelectFirst(inputJobTypeLocator);
        return this;
    }

    @Step("Укажите название организации")
    public TakeFirstLoan inputJobName(String jobName) {
        waitElementIsPresent(inputJobNameLocator).sendKeys(jobName);
        return this;
    }

    @Step("Укажите должность")
    public TakeFirstLoan inputJobTitle(String jobTitle) {
        waitElementIsPresent(inputJobTitleLocator).sendKeys(jobTitle);
        return this;
    }

    @Step("Укажите доход в месяц")
    public TakeFirstLoan inputSalaryLocator(String salary) {
        waitElementIsPresent(inputSalaryLocator).sendKeys(salary);
        return this;
    }

    @Step("Укажите расходы в месяц")
    public TakeFirstLoan inputExpensesAmount(String expensesAmount) {
        waitElementIsPresent(inputExpensesAmountLocator).sendKeys(expensesAmount);
        return this;
    }

    @Step("Банкротство за последние 3 года? Нет")
    public TakeFirstLoan selectBankruptcyProcessed() {
        waitElementIsPresent(radioBankruptcyProcessedLocator).click();
        return this;
    }

    @Step("Дополнительный контактный телефон")
    public TakeFirstLoan inputFriendNumber(String friendPhone) {
        waitElementIsPresent(inputFriendPhone).sendKeys(friendPhone);
        return this;
    }

    @Step("Принять соглашения")
    public TakeFirstLoan acceptAllPolicy() {
        javaScriptExecutorClickOn(waitElementIsPresent(checkBoxAcceptAllPolicy));
        return this;
    }

    @Step("Нажать Подтвердить")
    public TakeFirstLoan clickOnAcceptButton(){
        waitElementIsPresent(buttonAccept).click();
        return this;
    }

    public TakeFirstLoan clickOnSecondStageButton() {
        waitElementIsPresent(buttonSecondStageLocator).click();
        return this;
    }


}
