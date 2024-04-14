import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class practicetestNg {
    public static WebDriver driver;
    @BeforeMethod
    public static void openbrowswer() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public static void closebrowser() {
        driver.close();
    }
    public static void clickonelement(By by) {
        driver.findElement(by).click();
    }

@Test
    public static void usershouldbeabletonevigatewishlistpage() {

        //click On Wishlist
        clickonelement(By.className("wishlist-label"));
    }
}
