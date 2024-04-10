package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHerokuApp {

    /**
     * HW03
     * <br> - Navigate to website  https://testpages.herokuapp.com/styled/index.html
     * <br> - Under the Examples
     * <br> - Click on Locators - Find By Playground Test Page
     * <br> - Under the Examples
     * <br> - Print the URL
     * <br> - Navigate back
     * <br> - Print the URL
     * <br> - Click on WebDriver Example Page
     * <br> - Print the URL
     * <br> - Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
     * <br> - And then verify ‘two, zero’ message is displayed on page
     * <br> - Close driver.

     */

    WebDriver driver;
    @Test
    public void HerokuAppTest() {

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");


        By findByPlaygroundTestPage = By.xpath("//a[contains(@id, 'findbytest')]");
        driver.findElement(findByPlaygroundTestPage).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());


        driver.navigate().back();
        System.out.println("Current URL after navigating back: " + driver.getCurrentUrl());


        By webDriverExamplePage = By.xpath("//a[contains(@id,'webdriverexamplepage')]");
        driver.findElement(webDriverExamplePage).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());


        By textInput = By.id("numentry");
        driver.findElement(textInput).sendKeys("20");


        By submitButton = By.id("submit-to-server");
        driver.findElement(submitButton).click();


        By messageElement = By.xpath("//p[@id='message']");
        var checkMessageText = driver.findElement(messageElement).getText();
        Assertions.assertEquals("two, zero", checkMessageText);
    }

    @BeforeEach
    public void beforeEach() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
