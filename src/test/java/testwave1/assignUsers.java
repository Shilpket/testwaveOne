    package testwave1;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
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
    public class assignUsers {
            WebDriver driver;
            LoginPage login;
            UsersPage usersPage;
            NaveBarPage naveBarPage;
            public String Username = "marlin.lowe@yahoo.com"; //User email;
            public String Rights = "Regular User";

        @BeforeClass
        public void setUp(){
            driver = new ChromeDriver();
            driver.get("http://www.testwave.qabidder.net");
            login = new LoginPage(driver);
            usersPage = new UsersPage(driver);
            naveBarPage = new NaveBarPage(driver);
            driver.manage().window().maximize();

        }

        @Test
        public void assignPermission() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            // users on navbar
            naveBarPage.Users().click();
            Thread.sleep(5000);


            usersPage.SaveBtn().click();
        }

        private String row() {

            String key = Username;
            // grab the table
            WebElement table = driver.findElement(By.className("table table-bordered"));
            // getting all tr elements, all the rows
            List<WebElement> allRows = driver.findElements(By.tagName("tr"));
            //getting cell data from rows

            String cells = null;
            for (WebElement row : allRows) {
                cells = String.valueOf(row.findElements(By.xpath(".//table/div/tr/a.ng-href")));
            }

            if (cells.equals(Username)) {
                cells = key;
            }
            return key;
        }




        @AfterClass
        public void breakdown() throws InterruptedException {
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            driver.quit();}

    }
