package testwave1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by shilp on 1/18/2017.
 */
public class Registration {
    WebDriver driver;
    LoginPage loginPage;
    RegistrationPage regPage;
    Faker faker;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver=new ChromeDriver();
        loginPage = new LoginPage(driver);
        regPage = new RegistrationPage(driver);
        faker = new Faker();
        driver.get("http://www.testwave.qabidder.net");
        driver.manage().window().maximize();
     //   loginPage.Login("leela@mailinator.com","123456");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void registerUser()throws InterruptedException{
        Thread.sleep(3000);
        loginPage.register().click();
        Thread.sleep(3000);
        regPage.registerName().sendKeys(faker.name().firstName());
        Thread.sleep(2000);
        regPage.registerEmail().sendKeys(faker.internet().emailAddress());
        regPage.registerPassword().sendKeys("123456");
        regPage.registerRetypePassword().sendKeys("123456");
        Thread.sleep(3000);
        regPage.registerBtn().click();

    }

    @Test (priority =2, enabled = true)
    public void registerCompany() throws InterruptedException {
        Thread.sleep(3000);
        regPage.companyName().sendKeys(faker.company().name());
        regPage.contactEmail().sendKeys(faker.internet().emailAddress());
        regPage.contactPhone().sendKeys(faker.phoneNumber().phoneNumber());
        regPage.address1().sendKeys(faker.address().streetAddress());
        new Select(regPage.country()).selectByVisibleText("United States");
        regPage.city().sendKeys(faker.address().city());
        new Select(regPage.city()).selectByVisibleText("California");
        Thread.sleep(3000);
        regPage.finishRegistration().click();

    }


    @AfterClass
    public void breakdown(){
        driver.manage().deleteAllCookies();
       // driver.quit();
    }

}
