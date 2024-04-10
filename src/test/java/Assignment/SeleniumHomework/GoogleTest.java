package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    /**
     *  HW01
     *  <br> - Create main method
     *  <br> - Open google home page: https://www.google.com
     *  <br> - Print Title on page
     *  <br> - Print Current URL on page
     *  <br> - Close/Quit the browser
     */


    WebDriver driver;

    @Test
    public void TestGoogle() {

        driver.navigate().to("https://www.google.com");

        System.out.print("Title: " + driver.getTitle() + "\n");

        System.out.print("Current URL: " + driver.getCurrentUrl() + "\n");
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


