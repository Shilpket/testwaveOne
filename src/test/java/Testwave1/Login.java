package Testwave1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by shilp on 12/21/2016.
 */
        public class Login {
    WebDriver driver;
    Faker faker;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://www.testwave.qabidder.net");
        Faker faker = new Faker();

    }

    @Test
    public void Login(String s, String s1){
        driver.findElement(By.id("username")).sendKeys("bongo@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("loginBtn")).click();

    }


    @AfterClass
    public void breakdown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}