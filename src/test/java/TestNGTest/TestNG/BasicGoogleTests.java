package TestNGTest.TestNG;

import engine.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.atomic.AtomicReference;

//@Listeners(CustomListener.class)
public class BasicGoogleTests extends Tests {

    /**
     * Breakout task: 40 minutes
     * <br/> - 1. recreate the base test class for junit with testng
     * <br/> - 2. copy the actionsbot to your project under `src/main/java/engine`
     * <br/> - 3. create a new tests.testng package
     * <br/> - 4. create a new class
     * <br/> - 5. do a quick google search and assert that result stats is not empty using testng
     */

    @Parameters({ "search-query" })
    @Test(groups = {"sanityCheck", "guiTests"})
    public void quickGoogleSearch(@Optional("Selenium WebDriver")String searchQuery){
        bot.navigate("https://www.google.com/");
        By searchInput = By.id("APjFqb");
        // bot.type(searchInput, "Selenium WebDriver" + Keys.RETURN);
        bot.type(searchInput,searchQuery+ Keys.RETURN);
       //var searchQuery1 = (String) testData.get("searchQuery");
        By resultStatsLabel = By.id("result-stats");
        //assert !" ".equals(driver.findElement(resultStatsLabel).getText()) : "Expected  resultStats to be empty ";
       // Assert.assertNotEquals(driver.findElement(resultStatsLabel).getText()," ") ;

        AtomicReference<String> actualText = new AtomicReference<>("");
        wait.until(f -> {
            actualText.set(driver.findElement(resultStatsLabel).getText());
            return true;
        });
        Assert.assertNotEquals(actualText, "");
    }

    @Test(testName = "Check Google Logo Exists", description = "Given I am on the Google homepage, Then the Google logo should be displayed")
    public void assertGoogleLogoExists(){
        bot.navigate("https://www.google.com/");
        By googleLogoImage = By.cssSelector("img[alt='Google']");
        Assert.assertTrue(driver.findElement(googleLogoImage).isDisplayed());

//        SoftAssert SoftAssert = new SoftAssert();
//        SoftAssert.assertTrue(driver.findElement(googleLogoImage).isDisplayed());
//        SoftAssert.assertTrue(driver.findElement(googleLogoImage).isDisplayed());
//        SoftAssert.assertTrue(driver.findElement(googleLogoImage).isDisplayed());
//        SoftAssert.assertAll();

    }
}
