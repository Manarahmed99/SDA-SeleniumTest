package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTest {

      /**
       *  HW02
       *  <br> - Invoke Chrome Driver
       *  <br> - Navigate to Facebook homepage URL: https://www.facebook.com/
       *  <br> - Verify expected URL equals to the actual URL.
       *  <br> - Verify  pagesource of FaceBook contains "Facebook" .
       */




    WebDriver driver;
    @Test
    public void TestFacebook() {

        driver.navigate().to("https://www.facebook.com/");


        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.facebook.com/", currentUrl);


        var pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("Facebook"));
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
