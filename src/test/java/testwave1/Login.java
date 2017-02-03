package testwave1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by shilp on 12/21/2016.
 * NO need for this TC. Login method is compiled in LoginPage
 */
  // @Deprecated
        public class Login {
    WebDriver driver;
    LoginPage loginPage;



    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }

    @Test
   /*public void Login(String s, String s1){
        driver.findElement(By.id("username")).sendKeys("mask@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("loginBtn")).click();

    }*/

    public void Login() throws InterruptedException {
        driver.get("http://www.testwave.qabidder.net");
        Thread.sleep(3000);
        loginPage.Login("leela@mailinator.com", "123456");
    }
    @AfterClass
    public void breakdown() throws InterruptedException {
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);
        driver.quit();
    }
}