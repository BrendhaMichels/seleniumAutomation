package tests;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.BingPage;

public class BingTest {
    public static void main(String[] args) {
        WebDriver driver = DriverManager.getDriver();

        BingPage bingPage = new BingPage(driver);
        bingPage.open();
        bingPage.search("Selenium WebDriver");

        // Fecha o navegador no final
        DriverManager.closeDriver();
    }
}
