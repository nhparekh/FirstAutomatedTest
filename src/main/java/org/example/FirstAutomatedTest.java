package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstAutomatedTest {

    protected static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //type the url
        driver.get("https://demo.nopcommerce.com");
        //click on register button
        driver.findElement(By.className("ico-register")).click();
        //type firstname
        driver.findElement(By.id("FirstName")).sendKeys("Namrata");
        //type lastname
        driver.findElement(By.name("LastName")).sendKeys("Parekh");
        //type email
        driver.findElement(By.id("Email")).sendKeys("harry@gmail.com");
        //type password
        driver.findElement(By.id("Password")).sendKeys("Hariom22");

        //type confirmed password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Hariom22");

        //click on register submit button
        driver.findElement(By.name("register-button")).click();

        //verify correct registration message displayed
        String actualMsg = driver.findElement(By.className("result")).getText();
        //initialization expected result
        String expectedRegisterMsg = actualMsg;

             if (actualMsg.equals(expectedRegisterMsg)) {
            System.out.println("Pass");

             } else {
            System.out.println("Failed");
            }
        //close browser
       driver.close();


    }

    }

