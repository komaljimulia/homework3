package automationpractice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInTest {
    WebDriver driver;//to declare as globally
    @Before
    public void setUp(){
        String baseUrl="http://automationpractice.com/index.php";

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");//learn by heart
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it will wait to load browser
        driver.get(baseUrl);
    }
    @Test
    public void veryfyUserSignIn() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expectedErrorMessage = "There is 2 error";
        WebElement errorMessageIs = driver.findElement(By.xpath("//p[text()='There is 1 error']"));

        String actualErrorMessage = errorMessageIs.getText();
        Assert.assertEquals( "There is 1 error",expectedErrorMessage,actualErrorMessage );

    }
    @After
    public void tearDown(){
        driver.quit();
    }







    }




//Homework - 3
//Open url : http://automationpractice.com/index.php
//Click on Sign In
//Enter correct Email in Email field
//Enter wrong Password in Password field
//Click on Sign In button.
//Expected Result:
//Error Message “There is 1 error”