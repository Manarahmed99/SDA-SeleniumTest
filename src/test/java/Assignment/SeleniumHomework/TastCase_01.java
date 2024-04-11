package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TastCase_01 {

    /**
     *  TastCase_01
     *  <br> - Invoke Chrome Browser
     *  <br> - Navigate to URL: <a href="https://www.w3schools.com/">w3schools</a>
     *  <br> - Navigate to URL: <a href="https://stackoverflow.com/">stackoverflow</a>
     *  <br> - Come back to the w3schools using the back command.
     *  <br> - Again go back to the stackoverflow website using forward command
     *  <br> - Refresh the Browser using refresh command.
     *  <br> - Close the Browser.
     * */


    WebDriver driver;
    @Test
    public void testing(){
        driver.navigate().to("https://www.w3schools.com/");
        driver.navigate().to("https://stackoverflow.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
