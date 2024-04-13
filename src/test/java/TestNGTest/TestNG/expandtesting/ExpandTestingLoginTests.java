package TestNGTest.TestNG.expandtesting;

import TestNGTest.TestNG.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.expandTesting.Login;

import pages.expandTesting.Secure;


public class ExpandTestingLoginTests extends Tests {


    /**
     * Breakout task: 30 minute
     * PomPatternPomTests
     * <br/> - login by applying POM pattern -> <a href="https://practice.expandtesting.com/login">expandtesting</a>
     * <br/> - generate working allure report
     * <br/> - optional: read data from json file
     */


    @Test(description = "Successful Login")
    public void loginTest(){
        Login loginPage = new Login(driver,bot);
        loginPage.goTo();
        loginPage.successfulLogin("practice", "SuperSecretPassword!");

        // redirected to second page
        Secure securePage = new Secure(driver,bot);
        String actualText = securePage.readSuccessMessage();
        Assert.assertEquals(actualText, "You logged into a secure area!");
    }
}
