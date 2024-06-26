package JunitTest.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends Tests{
    /**
     * Breakout Activity: 20 minute
     * <br/> -navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * <br/> -uploading any file from your machine (make it small please)
     * <br/> -checking to see that the file was successfully uploaded
     */

    /**
     * breakout task (15) - write some logs in that 'FileUploadTest'
     * <br/> -Steps to implement logging:
     * <br/> -add the pom.xml dependency
     * <br/> -create the sample properties file
     * <br/> -create the logger configuration in your base test class
     * <br/> -use the logger object in your test class
     */
    @Test
    public void uploadFile(){
//        String url = "https://the-internet.herokuapp.com/upload";
//        logger.info("Navigating to: "+url);
//        driver.get(url);

        bot.navigate("https://the-internet.herokuapp.com/upload");

        By fileUploadInput = By.xpath("(//input[@type='file'])[1]");

        String fileUploadPath = "C:\\Users\\manar\\IdeaProjects\\testProject\\src\\test\\resources\\testData\\sample.json";
        logger.info("Uploading file: "+fileUploadPath);
        driver.findElement(fileUploadInput).sendKeys(fileUploadPath);
        //submit used when button inside form it wait until submit
        driver.findElement(fileUploadInput).submit();

        By uploadSuccessfullyLabel = By.tagName("h3");
        logger.info("Confirming that the file has been uploaded successfully");
        Assertions.assertEquals("File Uploaded!", driver.findElement(uploadSuccessfullyLabel).getText());
    }
}
