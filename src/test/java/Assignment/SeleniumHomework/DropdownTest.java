package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class DropdownTest {
    /**
     * HW06
     * <br> - navigate to this url <a href="https://demoqa.com/select-menu">select-menu</a>
     * <br> - Get all the options of the dropdown
     * <br> - Options size
     * <br> - Print all test
     * <br> - Verify the dropdown has option "Black"
     * <br> - Print FirstSelectedOptionTest
     * <br> - Select option "Yellow"
     */

    WebDriver driver;

    @Test
    public void SelectMenuTest(){

        driver.navigate().to("https://demoqa.com/select-menu");
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        //Options size
        System.out.println("Options size: " + options.size());
        //Get all the options of the dropdown
        System.out.println("All options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        //Verify the dropdown has option "Black"
        System.out.println("The have Black color :"+dropdown.getText().contains("Black"));
        // Print the first selected option
        System.out.println("First selected option: " + select.getFirstSelectedOption().getText());
        // Select option "Yellow"
        select.selectByVisibleText("Yellow");
        System.out.println("New selected option: " + select.getFirstSelectedOption().getText());



    }


    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeoptions);


    }

    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}
