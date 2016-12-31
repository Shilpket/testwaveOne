package testwave1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NaveBarPage;
import pages.UsersPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by shilp on 12/16/2016.
 */
public class inviteUsers {
    WebDriver driver;
    Faker faker;
    LoginPage login;
    UsersPage usersPage;
    NaveBarPage naveBarPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://www.testwave.qabidder.net");
        faker = new Faker();
        login = new LoginPage(driver);
        usersPage = new UsersPage(driver);
        naveBarPage = new NaveBarPage(driver);
        driver.manage().window().maximize();

            }
//    @BeforeTest  for some reason did not work
//    public void setLogin() throws InterruptedException {
//
//    }

    @Test(priority = 1)
    public void inviteUser() throws InterruptedException {
        login.Login("mask@mailinator.com", "123456");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        naveBarPage.Users().click(); // navebar users btn
        usersPage.InviteUser().click(); // invite user btn
        usersPage.emailField().clear();
        usersPage.emailField().sendKeys(faker.internet().emailAddress());
        usersPage.SendInvite().click();

        for(int i=0; i<2; i++){ inviteUser();}
    }



    @Test(priority = 2, enabled = false)
    public void resendInvitation(){
        usersPage.ResendInvitation().click(); //// this code will execute for the first user only -- need to learn to choose from multiple users
    }

    @Test(priority = 3)

    public void deleteUser(){
        usersPage.DeleteUser().click(); // this code will execute for the first user only -- need to learn to choose from multiple users.
    }

    @AfterClass
    public void breakdown() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
