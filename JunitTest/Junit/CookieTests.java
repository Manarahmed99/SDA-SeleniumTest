package JunitTest.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class CookieTests extends Tests{
    /**
     * Breakout task: 15 minutes
     * <br/> -Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
     * <br/> -print the total number of cookies
     * <br/> -add a new "fruit=apple" cookie
     * <br/> -edit the "protein" cookie to have the value "meat"
     * <br/> -delete the "vegetable" cookie
     * <br/> -print all cookies
     * <br/> -delete all cookies
     */
    @Test
    public void cookies(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        System.out.println("Initial size:" + driver.manage().getCookies().size());
        System.out.println("Initial list of cookies:");
        //        cookies.forEach(cookie -> {System.out.println(cookie);});
        driver.manage().getCookies().forEach(System.out::println);

        driver.manage().addCookie(new Cookie("fruit","apple"));
        driver.manage().addCookie(new Cookie("protein","meat"));
        driver.manage().deleteCookieNamed("vegetable");

        System.out.println("Updated list of cookies:");
        driver.manage().getCookies().forEach(System.out::println);

        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size());
    }
}
