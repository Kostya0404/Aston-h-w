package Lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
    }

    @Test
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение\n" + "без комиссии";
        String actualTitle = mainPage.getBlockTitle();
        assertEquals(expectedTitle, actualTitle, "Название блока не совпадает!");
    }

    @Test
    public void testPaymentLogos() {
        assertTrue(mainPage.isVisaLogoDisplayed(), "Логотип Visa не отображается!");
        assertTrue(mainPage.isVerifiedByVisaLogoDisplayed(), "Логотип Verified By Visa не отображается!");
        assertTrue(mainPage.isMastercardLogoDisplayed(), "Логотип Mastercard не отображается!");
        assertTrue(mainPage.isMasterCardSecureCodeDisplayed(), "Логотип MasterCard Secure Code не отображается!");
        assertTrue(mainPage.isBelkartLogoDisplayed(), "Логотип Белкарт не отображается!");
    }

    @Test
    public void testDetailsLink() {
        mainPage.clickDetailsLink();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"), "Ссылка не работает!");
    }

    @Test
    public void testContinueButton() {
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterAmount("10");
        mainPage.clickContinueButton();
        assertTrue(mainPage.isContinueButtonEnabled(), "Кнопка 'Продолжить' недоступна для клика!");
    }

    @Test
    public void testPlaceholders() {
        assertEquals("Номер телефона", mainPage.getPhoneNumberFieldPlaceholder(), "Плейсхолдер поля 'Номер телефона' не совпадает!");
        assertEquals("Сумма", mainPage.getAmountPlaceholder(), "Плейсхолдер поля 'Сумма' не совпадает!");
        assertEquals("E-mail для отправки чека", mainPage.getEmailPlaceholder(), "Плейсхолдер поля 'E-mail для отправки чека' не совпадает!");

        mainPage.clickMenuButton();
        mainPage.clickHomeInternetButton();
        assertEquals("Номер абонента", mainPage.getPhoneInternetPlaceholder(), "Плейсхолдер поля 'Номер абонента' (Домашний интернет) не совпадает!");
        assertEquals("Сумма", mainPage.getAmountInternetPlaceholder(), "Плейсхолдер поля 'Сумма' (Домашний интернет) не совпадает!");
        assertEquals("E-mail для отправки чека", mainPage.getEmailInternetPlaceholder(), "Плейсхолдер поля 'E-mail для отправки чека' (Домашний интернет) не совпадает!");

        mainPage.clickMenuButton();
        mainPage.clickInstalmentButton();
        assertEquals("Номер счета на 44", mainPage.getNumber44FieldPlaceholder(), "Плейсхолдер поля 'Номер счета на 44' не совпадает!");
        assertEquals("Сумма", mainPage.getAmount44FieldPlaceholder(), "Плейсхолдер поля 'Сумма' (Рассрочка) не совпадает!");
        assertEquals("E-mail для отправки чека", mainPage.getEmail44FieldPlaceholder(), "Плейсхолдер поля 'E-mail для отправки чека' (Рассрочка) не совпадает!");

        mainPage.clickMenuButton();
        mainPage.clickDebtButton();
        assertEquals("Номер счета на 2073", mainPage.getNumber2073FieldPlaceholder(), "Плейсхолдер поля 'Номер счета на 2073' не совпадает!");
        assertEquals("Сумма", mainPage.getAmount2073FieldPlaceholder(), "Плейсхолдер поля 'Сумма' (Задолженность) не совпадает!");
        assertEquals("E-mail для отправки чека", mainPage.getEmail2073FieldPlaceholder(), "Плейсхолдер поля 'E-mail для отправки чека' (Задолженность) не совпадает!");
    }

    @Test
    public void testIframe() {
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterAmount("10");
        mainPage.clickContinueButton();
        assertTrue(mainPage.isContinueButtonEnabled(), "Кнопка 'Продолжить' недоступна для клика!");
        mainPage.clickContinueButton();
        mainPage.switchToIframe(driver);
        assertEquals("Оплата: Услуги связи Номер:375297777777", mainPage.getPhoneText());
        assertEquals("10.00 BYN", mainPage.getSumText());
        assertEquals("Оплатить 10.00 BYN", mainPage.getPay10Text());

        assertEquals("Номер карты", mainPage.getCardNumberText());
        assertEquals("Срок действия", mainPage.getDateText());
        assertEquals("CVC", mainPage.getCvcText());
        assertEquals("Имя держателя (как на карте)", mainPage.getNameText());

        assertTrue(mainPage.isPaymentIconsVisible());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}