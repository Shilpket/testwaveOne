package Testwave1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UsersPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by shilp on 12/16/2016.
 */
public class   Users {
    WebDriver driver;
    Faker faker;
    LoginPage login;
    UsersPage usersPage;


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://www.testwave.qabidder.net");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        faker = new Faker();
        login = new LoginPage(driver);
        usersPage = new UsersPage(driver);
        driver.manage().window().maximize();


    }

    @Test(priority = 1)
    public void inviteUser() throws InterruptedException {
        Thread.sleep(5000);
        // Login
        login.Login("bongo@mailinator.com", "123456");
        Thread.sleep(5000);
        driver.findElement(usersPage.getInviteUser()).click();

        //emailField.clear();
        driver.findElement(By.id("emailField")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("sendInvite")).click();
    }


    @Test(priority = 2)

    public void assignPermission(){

    }

    @Test(priority = 3)

    public void deleteUser(){


    }



    @AfterClass
    public void brekdown() throws InterruptedException {
        Thread.sleep(5000);
        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
