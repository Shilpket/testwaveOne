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
    LoginPage loginPage;
    UsersPage usersPage;
    NaveBarPage naveBarPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        faker = new Faker();
        usersPage = new UsersPage(driver);
        naveBarPage = new NaveBarPage(driver);
        driver.manage().window().maximize();

            }
//    @BeforeTest  for some reason did not work
//    public void setLogin() throws InterruptedException {
//
//    }

    @Test
    public void inviteUser() throws InterruptedException {
        driver.get("http://www.testwave.qabidder.net");

        loginPage.Login("mask@mailinator.com", "123456");
        Thread.sleep(5000);
        naveBarPage.Users().click(); // navebar users btn
        usersPage.InviteUserBtn().click(); // invite user btn
        usersPage.InviteUsersEmailField().clear();
        usersPage.InviteUsersEmailField().sendKeys(faker.internet().emailAddress());
        usersPage.SendInviteBtn().click();

        for(int i=0; i<=2; i++){
            inviteUser();
        }

    }



    @AfterClass
    public void breakdown() throws InterruptedException {
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        driver.quit();

    }
}
