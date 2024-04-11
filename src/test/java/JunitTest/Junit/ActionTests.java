package JunitTest.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionTests extends Tests {

    /**
     * Breakout task: 15 minutes
     * <br/> -Navigate to <a href="https://the-internet.herokuapp.com/javascript_alerts">Alerts</a>
     * <br/> -click on "Click for JS Confirm"
     * <br/> -Press OK
     * <br/> -Check that "You clicked: Ok" is displayed
     */

    /**
     * Breakout task:
     * <br/> -Navigate to <a href="https://www.selenium.dev/selenium/web/click_frames.html">click_frames</a>
     * <br/> -assert the value of the h1 element
     */


    @Test
    public void Breakout_task_alertTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        By button = By.cssSelector("button[onclick='jsConfirm()']");
        driver.findElement(button).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert text in a variable
        String text = alert.getText();

        //Press the OK button
        alert.accept();

        By result = By.id("result");
        Assertions.assertEquals("You clicked: Ok", driver.findElement(result).getText());
    }
    @Test
    public void alertTest(){
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        By button = By.cssSelector("button[onclick='alertbox()']");
        driver.findElement(button).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert text in a variable
        String text = alert.getText();

        //Press the OK button
        alert.accept();
        Assertions.assertEquals("I am an alert box!", text);
    }

    @Test
    public void basicAuthTest(){
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        By message = By.tagName("p");
        var actualMessage = driver.findElement(message).getText();
        Assertions.assertEquals("Congratulations! You must have the proper credentials.", actualMessage);
    }

    @Test
    public void iFrame(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
        WebElement iframe = driver.findElement(By.xpath("//frame[@name='source']"));
        driver.switchTo().frame(iframe);
        var headerText = driver.findElement(By.tagName("h1")).getText();
        driver.switchTo().defaultContent();
        Assertions.assertEquals("Testing Clicks", headerText);
    }



}
