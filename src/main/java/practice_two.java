import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class practice_two {
    protected static WebDriver driver;
    public static void openbrowser(){
        driver= new ChromeDriver();
        //Type url
        driver.get("https://demo.nopcommerce.com");
    }
    public static void clickonelement(By by){
        driver.findElement(by).click();
    }

    public static void typeText (By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFormElement(By by){
        return driver.findElement(by).getText();
    }
    public static String randomDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        Date date = new Date();
        return dateFormat. format(date);
    }

    public static void closeBrowser(){
        driver.close();

    }

    public static void main(String[] args) {

        openbrowser();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.manage().window().maximize();

        //click on register button
        clickonelement(By.className("ico-register"));
        //driver.findElement(By.className("ico-register")).click();

        //type firstname
        typeText(By.id("FirstName"), "Namrata");
        //driver.findElement(By.id("FirstName")).sendKeys("Namrata");

        //type lastname
        typeText(By.id("LastName"), "Parekh");
        // driver.findElement(By.name("LastName")).sendKeys("Parekh");

        //type email
        typeText(By.id("Email"), "harry" + randomDate() + "y@gmail.com");
        // driver.findElement(By.id("Email")).sendKeys("harry@gmail.com");

        //type password
        typeText(By.id("Password"), "Hariom22");
        //driver.findElement(By.id("Password")).sendKeys("Hariom22");

        //type confirmed password
        typeText(By.id("ConfirmPassword"), "Hariom22");
        //driver.findElement(By.id("ConfirmPassword")).sendKeys("Hariom22");

        //click on register submit button
        clickonelement(By.id("register-button"));
        //driver.findElement(By.name("register-button")).click();

        //verify correct registration message displayed
        String actualMsg = getTextFormElement(By.className("result"));
        // String actualMsg = driver.findElement(By.className("result")).getText();

        //initialization expected result
        String expectedMsg;
        expectedMsg = "Your regestration completed";
        String expectedRegisterMsg = actualMsg;

        if (actualMsg.equals(expectedRegisterMsg)) {
            System.out.println("Pass");

        } else {
            System.out.println("Failed");

        }

        closeBrowser();







    }

}
