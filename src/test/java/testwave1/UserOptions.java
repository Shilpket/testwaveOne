    package testwave1;

    import com.sun.xml.internal.ws.org.objectweb.asm.ByteVector;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.Select;
    import org.testng.Assert;
    import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Test;
    import pages.LoginPage;
    import pages.NaveBarPage;
    import pages.UsersPage;

    import java.util.List;

    import static java.util.concurrent.TimeUnit.SECONDS;

    /**
     * Created by shilp on 12/25/2016.
     */
    public class UserOptions {
            WebDriver driver;
            LoginPage loginPage;
            UsersPage usersPage;
            NaveBarPage naveBarPage;


        @BeforeClass
        public void setUp() throws InterruptedException {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            loginPage = new LoginPage(driver);
            usersPage = new UsersPage(driver);
            naveBarPage = new NaveBarPage(driver);
            driver.manage().window().maximize();
            driver.get("http://testwave.qabidder.net");
            loginPage.Login("leela@mailinator.com", "123456");

        }

        @Test (priority = 1, enabled = false)
        public void assignPermission() throws InterruptedException {
            String expectedResult = "Admin";


                 // users on navbar
            naveBarPage.Users().click();
            Thread.sleep(5000);
            // pass string "username" below in the method. Relative xpath is for the btn to click.
            usersPage.AssignPermission("terrence.bartell@gmail.com").findElement(By.xpath("./td[2]/button[1]")).click();// method call
            Thread.sleep(3000);
                // selecting the role. Xpath is for dropdown element
            //new Select(driver.findElement(By.xpath("//td[2]/select"))).selectByVisibleText("Admin");
            new Select(usersPage.SelectRole()).selectByVisibleText("Admin");

            usersPage.SaveBtn().click();

            //dismiss the window
            driver.switchTo().frame(1);
            //click on the user
            usersPage.AssignPermission("terrence.bartell@gmail.com").click();
            //Assert.assertEquals(actualResult, expectedResult);
            Assert.assertTrue(usersPage.SaveBtn().findElement(By.xpath("//button[@class='btn btn-sm mr-sm']")).isDisplayed());
        }


        @Test(priority = 2, enabled= false)
        public void resendInvitation() throws InterruptedException {
            naveBarPage.Users().click();
            Thread.sleep(3000);
            // pass string "username" in the method. Xpath for btn to click.
            usersPage.ResendInvitation("").findElement(By.xpath("./td[2]/button[3]")).click();

        }


        @Test(priority = 3, enabled = true)
        public void deleteUser() throws InterruptedException {

            naveBarPage.Users().click();
            Thread.sleep(3000);
            // pass string "username" in the method.  xpath is for the delete user btn on the user page
            usersPage.DeleteUser("jessy.flatley@gmail.com").findElement(By.xpath("./td[2]/button[4]"));

            usersPage.ConfirmDelete().click();
        }

        @AfterClass
        public void breakdown() throws InterruptedException {
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(5, SECONDS);
            driver.quit();
        }

    }


