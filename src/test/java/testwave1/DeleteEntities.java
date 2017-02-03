package testwave1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EntityPage;
import pages.LoginPage;
import pages.NaveBarPage;

/**
 * Created by shilp on 1/5/2017.
 */
public class DeleteEntities {
    WebDriver driver;
    LoginPage loginPage;
    NaveBarPage naveBarPage;
    EntityPage entityPage;


    @BeforeClass
    public void setUP(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        naveBarPage = new NaveBarPage(driver);
        entityPage = new EntityPage(driver);
        driver.manage().window().maximize();
    }

// This test will delete all the entities on the page.
    @Test
    public void DeleteAllEntities() throws InterruptedException {
        driver.get("http://www.testwave.qabidder.net");
        Thread.sleep(3000);
        loginPage.Login("leela@mailinator.com","123456");
        Thread.sleep(5000);

        naveBarPage.Entities().click();
        Thread.sleep(4000);
        entityPage.DeleteAllEntities(); // method call

    }

    @AfterClass
    public void breakdown() throws InterruptedException {
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
       // driver.quit();
    }
}
