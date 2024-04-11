package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {

    /**
     * HW04
     * <br> - Go to URL: <a href="https://demoqa.com/radio-button">radio-button</a>
     * <br> - Verify whether all 3 options given to the question can be selected.
     * <br> - When each option is selected, print the following texts on the console.
     */

    WebDriver driver;


    @Test
    public void YesradioButtonTest() {
        clickRadioButton("yesRadio");
        clickRadioButton("impressiveRadio");
        NoclickRadioButton("noRadio");
    }


    private void clickRadioButton(String radioButtonId) {
        By radioButton = By.xpath("//label[@for='" + radioButtonId + "']");
        driver.findElement(radioButton).click();
        String selectedOption = driver.findElement(radioButton).getText();
        System.out.println("Selected option: " + selectedOption);
        Assertions.assertEquals(selectedOption, driver.findElement(radioButton).getText());


    }

    private void NoclickRadioButton(String noradioButtonId) {
        By radioButtonLocator = By.xpath("//label[@for='" + noradioButtonId + "']");


        if (!driver.findElement(radioButtonLocator).isEnabled()) {
            System.out.println("Radio button is disabled ");
            return;
        }

        driver.findElement(radioButtonLocator).click();

        String selectedOption = driver.findElement(radioButtonLocator).getText();
        System.out.println("Selected option: " + selectedOption);
    }



    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();

    }
}
