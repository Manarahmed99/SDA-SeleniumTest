package TestNGTest.TestNG.sauceDemo;


import TestNGTest.TestNG.Tests;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.sauceDemo.Login;

public class SauceDemoLoginTests extends Tests {
    /**
     * Breakout task: 40 minute
     *  <br/> - login page object model class
     *  <br/> - one test method that uses this class
     *  <br/> - optional: read data from json file
     *  <br/> - optional: create two more test methods
     */
    @Test(testName = "Successful Login Test", description = "Given I am on the login page, When I input valid credentials, Then I am redirected to the Products page.")
    public void successfulLoginTest(){
        Login loginPage = new Login(driver, bot);
        loginPage.goTo();
//        loginPage.login("standard_user", "secret_sauce");

        JSONObject testCaseData = (JSONObject) testData.get("SauceDemoLoginData");
        loginPage.login((String)testCaseData.get("usernameTextArea"), (String)testCaseData.get("passwordTextArea"));


        By product_label = By.className("product_label");
        Assert.assertEquals(driver.findElement(product_label).getText(),"Products");
    }

    @Test(testName = "Unsuccessful Login Test", description = "Given I am on the login page, When I input invalid credentials, Then show error message.")
    public void UnsuccessfulLoginTest(){
        Login loginPage = new Login(driver, bot);
        loginPage.goTo();
        loginPage.login("locked_out_user", "secret_sauce");

        By errorMessageLabel = By.xpath("//h3[@data-test='error']");
        Assert.assertEquals(driver.findElement(errorMessageLabel).getText(),"Epic sadface: Sorry, this user has been locked out.");

    }
}