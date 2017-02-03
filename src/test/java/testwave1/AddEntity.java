package testwave1;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import pages.EntityPage;
import pages.LoginPage;
import pages.NaveBarPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by shilp on 1/4/2017.
 */
public class AddEntity {
    WebDriver driver;
    LoginPage loginPage;
    EntityPage entityPage;
    NaveBarPage naveBarPage;
    Faker faker;


    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        naveBarPage = new NaveBarPage(driver);
        entityPage = new EntityPage(driver);
        faker = new Faker();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net");
        loginPage.Login("mask@mailinator.com", "123456");

    }
    @Test
    public void AddEntity() throws InterruptedException {
        // clicking on Entities btn on navigation bar
        naveBarPage.Entities().click();
        entityPage.AddEntityBtn().click();
        entityPage.EntityName().sendKeys(faker.company().name());
        new Select(entityPage.CountryField()).selectByVisibleText("United States");
        entityPage.Address1Field().sendKeys(faker.address().streetAddress());
        entityPage.Address2Field().sendKeys(faker.address().buildingNumber());
        entityPage.CityField().sendKeys("Los Altos");
        new Select(entityPage.StateField()).selectByVisibleText("California");
        entityPage.PostalCodeField().sendKeys("94024");
        entityPage.EmailField().sendKeys(faker.internet().emailAddress());
        entityPage.Phone().sendKeys(faker.phoneNumber().phoneNumber());
        entityPage.NotesField().sendKeys("fjowejewjfoiwjrfj2");
        entityPage.EntityLogoBtn().sendKeys("C://Users//shilp//OneDrive//Pictures");
        Thread.sleep(3000);
        entityPage.NextStepBtn().click();
        Thread.sleep(3000);
        entityPage.InviteRUField().sendKeys(faker.internet().emailAddress());
        entityPage.NextStepBtn().click();
        Thread.sleep(3000);
        entityPage.RUDoneBtn(+1).click();
        Thread.sleep(3000);
        entityPage.NextStepBtn().click();
        Thread.sleep(3000);
//        entityPage.InviteAdminEmail().sendKeys(faker.internet().emailAddress());
//        Thread.sleep(3000);
//        entityPage.AdminDoneBtn().click();
//        Thread.sleep(3000);
//        entityPage.NextStepBtn();
        entityPage.FinishBtn();

        for (int i=0; i<=3;i++){AddEntity();}
    }

    @AfterTest
    public void breakdown() throws InterruptedException {
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
       // driver.quit();
    }
}


