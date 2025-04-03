package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BingPage {
    private WebDriver driver;

    public BingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.bing.com");
    }

    public void handleCookiesPopup() {
        try {
            WebElement acceptButton = driver.findElement(By.xpath("//button[contains(text(),'Aceitar')]"));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Pop-up de cookies não apareceu.");
        }
    }

    public void search(String query) {
        handleCookiesPopup();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    public boolean resultsAreDisplayed() {
        return driver.findElement(By.id("b_results")).isDisplayed();
    }

    public void openImagesTab() {
        driver.findElement(By.id("b-scopeListItem-images")).click();
    }

    public void openVideosTab() {
        driver.findElement(By.id("b-scopeListItem-video")).click();
    }

    public boolean suggestionsAreDisplayed() {
        return driver.findElement(By.id("sa_5003")).isDisplayed();
    }
}
