    package testwave1;

    import com.sun.xml.internal.ws.org.objectweb.asm.ByteVector;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.Select;
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
    public class userOptions {
            WebDriver driver;
            LoginPage loginPage;
            UsersPage usersPage;
            NaveBarPage naveBarPage;
           /* public String Username = "kiley.herman@hotmail.com"; //User email;
           Each method has a string Username passed in it. Before running a test, please enter "username" in the TC.
           e.g. userpage.somebtn("abc@abc.com").
            */


        @BeforeClass
        public void setUp() throws InterruptedException {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            driver.get("http://www.testwave.qabidder.net");
            loginPage = new LoginPage(driver);
            usersPage = new UsersPage(driver);
            naveBarPage = new NaveBarPage(driver);
            driver.manage().window().maximize();

        }

        @Test (priority = 1, enabled = false)
        public void assignPermission() throws InterruptedException {
            driver.get("http://testwave.qabidder.net");
            loginPage.Login("mask@mailinator.com", "123456");

            Thread.sleep(5000);
            // users on navbar
            naveBarPage.Users().click();
            Thread.sleep(5000);
            // pass string "username" below in the method
            usersPage.AssignPermissionBtn("").findElement(By.xpath("./td[2]/button[1]")).click();
            Thread.sleep(3000);
                // selecting the role. Xpath is for dropdown element
            //new Select(driver.findElement(By.xpath("//td[2]/select"))).selectByVisibleText("Admin");
            new Select(usersPage.SelectRole()).selectByVisibleText("Regular User");

            usersPage.SaveBtn().click();
        }


        @Test(priority = 2, enabled= true)
        public void resendInvitation() throws InterruptedException {
            driver.get("http://www.testwave.qabidder.net");
            loginPage.Login("mask@mailinator.com", "123456");

            Thread.sleep(5000);
            naveBarPage.Users().click();
            Thread.sleep(3000);
            // pass string "username" in the method
            usersPage.ResendInvitationBtn("jessy.flatley@gmail.com");
            usersPage.ResendBtn().click();
        }


        @Test(priority = 3, enabled = false)
        public void deleteUser() throws InterruptedException {
            driver.get("http://www.testwave.qabidder.net");
            loginPage.Login("mask@mailinator.com", "123456");

            Thread.sleep(5000);
            naveBarPage.Users().click();
            Thread.sleep(3000);
            // pass string "username" in the method.  xpath is for the delete user btn on the page
            usersPage.DeleteUserBtn("");
            usersPage.DeleteBtn().click();
            usersPage.ConfirmDelete().click();
        }

        @AfterClass
        public void breakdown() throws InterruptedException {
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(5, SECONDS);
            driver.quit();}

    }


