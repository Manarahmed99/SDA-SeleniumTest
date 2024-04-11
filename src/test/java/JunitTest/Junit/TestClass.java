package JunitTest.Junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    @Test
    public void TestMethodDay1(){
        // we will follow the official user guide
        // https://www.selenium.dev/documentation/webdriver/getting_started/first_script/

        // 1. Start the session
        // Selenium Manager will download the driver for you, and it will also download the entire browser if you don't have it installed on your machine.
        // It will download it to a temporary directory, to be used in isolation, and only for your selenium tests.
        WebDriver driver = new ChromeDriver();

        // 2. Take action on browser
        //you can either use driver.get or driver.navigate.to to navigate to any url
        //driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

        // 3. Request browser information
        var title = driver.getTitle();
        driver.quit();
    }

    @Test
    public void TestMethodDay2(){
        // initializing the session
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // initial navigation
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

        // test steps
        driver.navigate().to("https://duckduckgo.com/");

        //checkpoint
        var title = driver.getTitle();
        Assertions.assertEquals("DuckDuckGo — Privacy, simplified.", title);

        //checkpoint
        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://duckduckgo.com/", currentUrl);

        //terminating the session
        driver.quit();
    }


    @Test
    public void testMethodDay2_2(){
        // we will follow the official user guide
        // https://www.selenium.dev/documentation/webdriver/getting_started/first_script/

        // 1. Start the session
        // Selenium Manager will download the driver for you, and it will also download the entire browser if you don't have it installed on your machine.
        // It will download it to a temporary directory, to be used in isolation, and only for your selenium tests.
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        // 2. Take action on browser
        //you can either use driver.get or driver.navigate.to to navigate to any url
//        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        driver.navigate().refresh();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        driver.navigate().to("https://duckduckgo.com/");
        driver.navigate().back();
        driver.navigate().forward();

        // 3. Request browser information
        var title = driver.getTitle();
        Assertions.assertEquals("DuckDuckGo — Privacy, simplified.", title);
//        Assertions.assertEquals("DuckDuckGo", title);

        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://duckduckgo.com/", currentUrl);

        driver.quit();
    }


    /**
     * breakout task:
     * <br/> -  create a webdriver session.
     * <br/> -  open chrome/firefox/edge browser. (any one you want to practice on).
     * <br/> -  navigate to facebook website.
     * <br/> -  navigate to google website.
     * <br/> -  create a checkpoint for the page title.
     * <br/> -  create a checkpoint for the page url.
     * <br/> -  navigate to facebook website.
     * <br/> -  end the driver session.
     */

    @Test
    public void Task_1() {

        // initializing the session
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // initial navigation
        driver.navigate().to("https://www.facebook.com/");

        // test steps
        driver.navigate().to("https://www.google.com/");

        //checkpoint
        var title = driver.getTitle();
        Assertions.assertEquals("Google", title);

        //checkpoint
        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.google.com/", currentUrl);

        //terminating the session
        driver.quit();
    }

}
