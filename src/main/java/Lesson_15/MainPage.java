package Lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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
}