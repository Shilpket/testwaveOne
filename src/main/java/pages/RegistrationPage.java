package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by shilp on 1/18/2017.
 */
public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage (WebDriver driver){this.driver=driver;}
    // registration fields
    public WebElement registerName(){return driver.findElement(By.xpath("//form/div[1]/input"));}
    public WebElement registerEmail(){return driver.findElement(By.name("account_email"));}
    public WebElement registerPassword(){return driver.findElement(By.xpath(".//*[@id='id-password']"));}
    public WebElement registerRetypePassword(){return driver.findElement(By.name("account_password_confirm"));}
    public WebElement registerBtn(){return driver.findElement(By.xpath("//form/button"));}

   // company registration
    public WebElement companyName(){return driver.findElement(By.name("name"));}
    public WebElement contactPhone(){return driver.findElement(By.name("phone"));}
    public WebElement contactEmail(){return driver.findElement(By.name("email"));}
    public WebElement country(){return driver.findElement(By.name("country"));}
    public WebElement address1(){return driver.findElement(By.name("address1"));}
    public WebElement address2(){return driver.findElement(By.xpath("//div[1]/div[4]/input"));}
    public WebElement city(){return driver.findElement(By.name("city"));}
    public WebElement state(){return driver.findElement(By.name("state"));}
    public WebElement zip(){return driver.findElement(By.name("zip"));}
    public WebElement finishRegistration(){return driver.findElement(By.id("registerConfirm"));}

  /*  public void CompanyRegistration(){

    companyName().sendKeys();
    contactPhone().sendKeys();
    contactEmail().sendKeys();
    new Select(country()).selectByVisibleText("");


    }*/


}
