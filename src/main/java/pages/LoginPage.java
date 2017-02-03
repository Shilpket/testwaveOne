package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shilp on 12/21/2016.
 */
public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement register(){return driver.findElement(By.xpath("//div[2]/a"));}
    public WebElement forgotPassword(){return driver.findElement(By.xpath("//form/div[3]/div/a"));}

    public WebElement username(){return driver.findElement(By.id("exampleInputEmail1"));}
    public WebElement password(){return driver.findElement(By.id("exampleInputPassword1"));}
    public WebElement loginBtn(){return driver.findElement(By.xpath("//form/button"));}


    public void Login(String s, String s1) throws InterruptedException {
        username().sendKeys(s);
        password().sendKeys(s1);
        Thread.sleep(3000);
        loginBtn().click();
    }


}
