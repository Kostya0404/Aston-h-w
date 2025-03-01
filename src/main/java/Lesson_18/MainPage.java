package Lesson_18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//h2[text()='Онлайн пополнение ']")
    public WebElement blockTitle;

    @FindBy(xpath = "//img[@alt='Visa']")
    public WebElement visaLogo;

    @FindBy(xpath = "//img[@alt='Verified By Visa']")
    public WebElement verifiedByVisaLogo;

    @FindBy(xpath = "//img[@alt='MasterCard']")
    public WebElement masterCardLogo;

    @FindBy(xpath = "//img[@alt='MasterCard Secure Code']")
    public WebElement masterCardSecureCodeLogo;

    @FindBy(xpath = "//img[@alt='Белкарт']")
    public WebElement belkartLogo;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    public WebElement detailsLink;

    @FindBy(xpath = "//input[@id='connection-phone']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    public WebElement amountField;

    @FindBy(xpath = "//form[@id='pay-connection']//button[text()='Продолжить']")
    public WebElement continueButton;

    @FindBy(xpath = "//button[text()='Принять']")
    public WebElement continueCookiesButton;

    @FindBy(xpath = "//input[@id='arrears-email']")
    public WebElement emailField;

    @FindBy(xpath = "//button[@class='select__header']")
    public WebElement menuButton;

    @FindBy(xpath = "//p[text()='Домашний интернет']")
    public WebElement homeInternetButton;

    @FindBy(xpath = "//input[@placeholder='Номер абонента']")
    public WebElement homeInternetPhoneButton;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    public WebElement homeInternetAmountButton;

    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    public WebElement homeInternetEmailButton;

    @FindBy(xpath = "//p[text()='Рассрочка']")
    public WebElement instalmentButton;

    @FindBy(xpath = "//input[@placeholder='Номер счета на 44']")
    public WebElement number44Field;

    @FindBy(xpath = "//input[@id='instalment-sum']")
    public WebElement amount44Field;

    @FindBy(xpath = "//input[@id='instalment-email']")
    public WebElement email44Field;

    @FindBy(xpath = "//p[text()='Задолженность']")
    public WebElement debtButton;

    @FindBy(xpath = "//input[@placeholder='Номер счета на 2073']")
    public WebElement number2073Field;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    public WebElement amount2073Field;

    @FindBy(xpath = "//input[@id='arrears-email']")
    public WebElement email2073Field;

    @FindBy(xpath = "//span[text()='10.00 BYN']")
    public WebElement sumField;

    @FindBy(xpath = "//span[contains(text(), '375297777777')]")
    public WebElement phoneField;

    @FindBy(xpath = "//button[contains(text(), '10.00')]")
    public WebElement pay10Button;

    @FindBy(xpath = "//label[@class='ng-tns-c46-1 ng-star-inserted']")
    public WebElement cardNumberField;

    @FindBy(xpath = "//label[@class='ng-tns-c46-4 ng-star-inserted']")
    public WebElement dateField;

    @FindBy(xpath = "//label[@class='ng-tns-c46-5 ng-star-inserted']")
    public WebElement cvcField;

    @FindBy(xpath = "//label[@class='ng-tns-c46-3 ng-star-inserted']")
    public WebElement nameField;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(continueCookiesButton)).click();
        } catch (Exception e) {
            System.out.println("Окно с принятием куки не найдено");
        }
    }

    public String getBlockTitle() {
        return blockTitle.getText();
    }

    public boolean isVisaLogoDisplayed() {
        return visaLogo.isDisplayed();
    }

    public boolean isVerifiedByVisaLogoDisplayed() {
        return verifiedByVisaLogo.isDisplayed();
    }

    public boolean isMastercardLogoDisplayed() {
        return masterCardLogo.isDisplayed();
    }

    public boolean isMasterCardSecureCodeDisplayed() {
        return masterCardSecureCodeLogo.isDisplayed();
    }

    public boolean isBelkartLogoDisplayed() {
        return belkartLogo.isDisplayed();
    }

    public void clickDetailsLink() {
        detailsLink.click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        amountField.sendKeys(amount);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickHomeInternetButton() {
        homeInternetButton.click();
    }

    public String getPhoneInternetPlaceholder() {
        return homeInternetPhoneButton.getAttribute("placeholder");
    }

    public String getAmountInternetPlaceholder() {
        return homeInternetAmountButton.getAttribute("placeholder");
    }

    public String getEmailInternetPlaceholder() {
        return homeInternetEmailButton.getAttribute("placeholder");
    }

    public String getPhoneNumberFieldPlaceholder() {
        return phoneNumberField.getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return amountField.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return emailField.getAttribute("placeholder");
    }

    public void clickInstalmentButton() {
        instalmentButton.click();
    }

    public String getNumber44FieldPlaceholder() {
        return number44Field.getAttribute("placeholder");
    }

    public String getAmount44FieldPlaceholder() {
        return amount44Field.getAttribute("placeholder");
    }

    public String getEmail44FieldPlaceholder() {
        return email44Field.getAttribute("placeholder");
    }

    public void clickDebtButton() {
        debtButton.click();
    }

    public String getNumber2073FieldPlaceholder() {
        return number2073Field.getAttribute("placeholder");
    }

    public String getAmount2073FieldPlaceholder() {
        return amount2073Field.getAttribute("placeholder");
    }

    public String getEmail2073FieldPlaceholder() {
        return email2073Field.getAttribute("placeholder");
    }

    public void switchToIframe(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
    }

    public String getPhoneText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(phoneField)).getText();
    }

    public String getSumText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return sumField.getText();
    }

    public String getPay10Text() {
        return pay10Button.getText();
    }

    public String getCardNumberText() {
        return cardNumberField.getText();
    }

    public String getDateText() {
        return dateField.getText();
    }

    public String getCvcText() {
        return cvcField.getText();
    }

    public String getNameText() {
        return nameField.getText();
    }

    public boolean isPaymentIconsVisible() {
        List<WebElement> paymentIcons = driver.findElements(By.xpath("//img[contains(@class, 'ng-tns-c61-0')]"));
        int expectedPaymentLogoCount = 5;
        return !paymentIcons.isEmpty() && paymentIcons.size() == expectedPaymentLogoCount;
    }
}