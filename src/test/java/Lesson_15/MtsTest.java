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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}