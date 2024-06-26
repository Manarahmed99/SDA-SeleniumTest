package JunitTest.Junit;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManipulationTests extends Tests {
    static Path downloadedFilePath = Paths.get(System.getProperty("user.home") + "/Downloads/importData.csv");

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        By usernameInput = By.name("username");
        By passwordInput = By.name("password");
        By loginButton = By.tagName("button");

//        wait.until(f -> {
//           driver.findElement(usernameInput).sendKeys("Admin");
//            return true;
//        });
//        driver.findElement(passwordInput).sendKeys("admin123");
//        driver.findElement(loginButton).click();

        bot.type(usernameInput,"Admin");
        bot.type(passwordInput,"admin123");
        bot.click(loginButton);

        By pimButton = By.xpath("//a[contains(@href,'viewPimModule')]");
//        wait.until(f -> {
//            driver.findElement(pimButton).click();
//            return true;
//        });
        bot.click(pimButton);

        By configurationButton = By.xpath("//li[contains(.,'Configuration')]");
        By dataImportButton = By.xpath("//a[text()='Data Import']");
//        wait.until(f -> {
//            driver.findElement(configurationButton).click();
//            return true;
//        });
//        wait.until(f -> {
//            driver.findElement(dataImportButton).click();
//            return true;
//        });
        bot.click(configurationButton);
        bot.click(dataImportButton);

        By downloadSampleCSVfileButton = By.xpath("//a[text()='Download']");
//        wait.until(f -> {
//            driver.findElement(downloadSampleCSVfileButton).click();
//            return true;
//        });
        bot.click(downloadSampleCSVfileButton);

        Thread.sleep(5000);
        Assertions.assertTrue(Files.exists(downloadedFilePath));
    }

    @AfterAll
    // static : Run after the class has finished running
    public static void afterAll() throws IOException {
        Files.delete(downloadedFilePath);
    }
}
