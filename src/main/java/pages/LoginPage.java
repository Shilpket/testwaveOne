package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shilp on 12/21/2016.
 */
public class LoginPage {
    WebDriver driver;
    LoginPage loginPage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    By username = By.id("exampleInputEmail1");
    By password = By.id("exampleInputPassword1");
    By loginBtn = By.xpath("html/body/div[2]/div/div/div[1]/div[2]/form/button");
    By register = By.className("btn btn-block btn-default");
    By forgotPassword = By.className("text-muted");
    By titleText = By.className("ng-binding");


    public void Login(String strUsername, String strPassword){
        driver.findElement(username).sendKeys(strUsername);
        driver.findElement(password).sendKeys(strPassword);
        driver.findElement(loginBtn).click();
    }





}
