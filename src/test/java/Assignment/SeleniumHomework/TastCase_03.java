package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TastCase_03 {

    /**
     *  TastCase_03
     *  <br> - Expected Title
     *  <br> - Set Path of the Chrome driver
     *  <br> - Launch Chrome browser
     *  <br> - Open URL of Website
     *  <br> - Maximize Window
     *  <br> - Get Title of current Page
     *  <br> - Validate/Compare Page Title
     *  <br> - Close the Browser.
     * */


    WebDriver driver;
    @Test
    public void testing(){
        var ExpectedTitle=driver.getTitle();
        Assertions.assertEquals("Google", ExpectedTitle);
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
