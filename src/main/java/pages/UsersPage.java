package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by shilp on 12/16/2016.
 */
public class UsersPage {
    WebDriver driver;
    WebElement element;
    public String UserEmailID;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserEmailID() { driver.findElement(By.xpath("//div[text()]"));
        return UserEmailID;
    } // location for useremail ID in the table

    public WebElement emailField() {
        return driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/form/div/input"));
    } // for invite users TC DO NOT DELETE

    // method did not work
    /*public WebElement InviteUser(){driver.findElement(By.xpath("html/body/div[2]/section/div/div/h3/button")); return element;} // invite user btn*/
    public WebElement InviteUser() {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/h3/button"));
    }

    public WebElement SendInvite() {
        return driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/form/button[1]"));
    } // send invite btn

    public WebElement Cancel() {
        return driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/form/button[2]"));
    }//cancel btn on invite user field--need to learn to choose from multiple users.. this code will work with first user only

    public WebElement AssignPermission(String strusername) {
        return driver.findElement(By.xpath("//div[3]/table/tbody/tr/td[2]/button[1]"));
    } // assign permission btn-- need to learn to choose from multiple users.. this code will work with first user only

    public WebElement ResendInvitation(){
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[3]/div/div/table/tbody/tr[1]/td[2]/button[3]"));
    } // resend invitation to the same user -- need to learn to choose from multiple users.. this code will work with first user only

    public WebElement DeleteUser() {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[3]/div/div/table/tbody/tr[1]/td[2]/button[4]"));
    } // delete user btn --need to learn to choose from multiple users.. this code will work with first user only

    public WebElement SelectRole() {
        return driver.findElement(By.xpath(".//*[@id='ngdialog5']/div[2]/div[1]/div/table/tbody/tr/td[2]/select"));
    } // select role dropdown -- need to learn to choose from multiple users.. this code will work with first user only

    public WebElement SaveBtn() {
        return driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/div/table/tbody/tr/td[3]/button[1]"));
    } // save the role selection --need to learn to choose from multiple users.. this code will work with first user only

    public WebElement DeleteRole() {
        return driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/div/table/tbody/tr/td[3]/button[2]"));
    } // delete the role selection-- need to learn to choose from multiple users.. this code will work with first user only


    public WebElement UserEmailID(String strUsername){return driver.findElement(By.xpath("//div[3]//table/tbody/tr/td[1]//a"));}
                // email id under the table on userpage Unique ID without any row specification



}