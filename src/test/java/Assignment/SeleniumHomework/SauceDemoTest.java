package Assignment.SeleniumHomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {
    /**
     * HW05
     * <br> - navigate to this url <a href="https://www.saucedemo.com/v1/inventory.html">inventory</a>
     * <br> - add the first item you find to your cart
     * <br> - open your cart
     * <br> - assert that the item name is correct inside the cart
     */
    WebDriver driver;



    @Test
    public void checkThatTheFirstItemIsDisplayedCorrectly(){
        login("standard_user", "secret_sauce");
        addItemToCart(1);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        Assertions.assertEquals("Sauce Labs Backpack", getCartItemName(1));
    }


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    private void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    private void addItemToCart(int itemNumber){
        By AddItemToCartButton = By.xpath("(//button[contains(@class,'btn_inventory')])["+itemNumber+"]");
        driver.findElement(AddItemToCartButton).click();
    }

    private String getCartItemName(int cartItemNumber){
        By cartItemName = By.xpath("(//div[@class='inventory_item_name'])["+cartItemNumber+"]");
        return driver.findElement(cartItemName).getText();
    }
}
