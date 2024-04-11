package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    /**
     * HW07
     * <br> - navigate to this url <a href="http://demo.automationtesting.in/Alerts.html">Alerts</a>
     * <br> - Click "Alert with OK" and click 'click the button to display an alert box:’
     * <br> - Accept Alert(I am an alert box!) and print alert on console.
     * <br> - Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
     * <br> - Cancel Alert (Press a Button !)
     * <br> - Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
     * <br> - And then sendKeys «Bootcamp» (Please enter your name)
     * <br> - Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
     */

    WebDriver driver;
    Wait<WebDriver> wait;



    @Test
    public void AlertwithOKTest (){
        By AlertwithOKButton = By.xpath("//a[@href='#OKTab']");
        driver.findElement(AlertwithOKButton ).click();

        By ClickAlertBox = By.cssSelector("button[onclick='alertbox()']");
        driver.findElement(ClickAlertBox).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert text in a variable
        String AlertwithOKText = alert.getText();

        //Press the OK button
        alert.accept();

        //Assertions
        Assertions.assertEquals("I am an alert box!", AlertwithOKText);
        System.out.println("Alert 1: "+AlertwithOKText);
    }

    @Test
    public void AlertwithOKAndCancelTest (){
        By AlertwithOKAndCancelButton = By.xpath("//a[@href='#CancelTab']");
        driver.findElement(AlertwithOKAndCancelButton ).click();

        By ClickAlertBox = By.cssSelector("button[onclick='confirmbox()']");
        driver.findElement(ClickAlertBox).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());


        String AlertwithOKAndCancelText = alert.getText();

        //Press the Cancel button
        alert.dismiss();

        By result = By.xpath("//p[@id='demo']");
        String actualText =  driver.findElement(result).getText();
        Assertions.assertEquals("You Pressed Cancel", actualText);
        System.out.println(actualText);

        Assertions.assertEquals("Press a Button !", AlertwithOKAndCancelText);
        System.out.println("Alert 2: "+AlertwithOKAndCancelText);

    }

    @Test
    public void AlertwithTextBoxTest (){

        By AlertwithTextboxButton = By.xpath("//a[@href='#Textbox']");
        driver.findElement(AlertwithTextboxButton ).click();

        By ClickAlertBox = By.cssSelector("button[onclick='promptbox()']");
        driver.findElement(ClickAlertBox).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //sendkey
        alert.sendKeys("Bootcamp");

        //Press the Ok button
        alert.accept();

        By result = By.xpath("//p[@id='demo1']");
        String actualText =  driver.findElement(result).getText();


        Assertions.assertEquals("Hello Bootcamp How are you today", actualText);
        System.out.println("Alert 3: "+actualText);

    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeoptions);
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}
