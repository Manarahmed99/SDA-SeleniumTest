package JunitTest.Junit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * breakout task:
 * <br/> -Use Google Chrome
 * <br/> -Navigate to <a href="https://www.google.com/">Google.com</a>
 * <br/> -Search for "Selenium"
 * <br/> -Check that results stats is not empty
 * <br/> -Change to using Firefox
 * <br/> -repeat the same task, but practice the different wait strategies
 */
public class SynchronizationTests {
    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeEach
    public void beforeEach(){
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        driver = new ChromeDriver(chromeOptions);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait = new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(5))
//                        .pollingEvery(Duration.ofMillis(100))
//                        .ignoring(NoSuchElementException.class);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        By searchBoxTextArea = By.id("APjFqb");
        driver.findElement(searchBoxTextArea).sendKeys("Selenium" + Keys.RETURN);
        // this should redirect me to the results page
        By resultStats = By.id("result-stats");
        // INSERT SYNC POINT HERE
//        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        wait.until(d -> driver.findElement(resultStats).isDisplayed());
        wait.until(d -> !driver.findElement(resultStats).getText().isEmpty());

        String actualText = driver.findElement(resultStats).getText();
        Assertions.assertNotEquals("", actualText);
    }
}
