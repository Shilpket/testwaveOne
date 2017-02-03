package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by shilp on 12/16/2016.
 */
public class UsersPage {
    WebDriver driver;
    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement InviteUserBtn() {
        return driver.findElement(By.xpath("//h3/button"));
    }// Btn on Users page

    public WebElement InviteUsersEmailField() {
        return driver.findElement(By.xpath("//form/div/input"));} // for invite users TC DO NOT DELETE -- field is on invite users btn


    public WebElement SendInviteBtn() {return driver.findElement(By.xpath("//form/button[1]"));} // send invite btn on invite user btn

    public WebElement CancelBtn() {return driver.findElement(By.xpath("//form/button[2]"));}//on invite user btn to cancel the invitation

    public WebElement SelectRole() {return driver.findElement(By.xpath("//td[2]/select"));} // select role dropdown

    public WebElement SaveBtn() {return driver.findElement(By.xpath("//tr/td[3]/button[1]"));} // save the role selection

    public WebElement DeleteRole() {return driver.findElement(By.xpath("//td[3]/button[2]"));} // delete the role selection


    public WebElement ConfirmDelete(){return driver.findElement(By.xpath("//*[@class=\"btn btn-danger mr\"]"));}//confirm delete user

    public WebElement CancelDelete(){return driver.findElement(By.xpath("//*[@id=ngdialog1]/div[2]/div/button[2]"));}//delete user pop up


    public WebElement NextPageBtn(){return driver.findElement(By.xpath("//dir-pagination-controls/ul/li[4]/a"));} // Next page arrow btn


    // Method.
    public WebElement AssignPermission(String Username) throws InterruptedException {

            do {
                List<WebElement> allRows = driver.findElements(By.tagName("tr"));
                for (WebElement cell: allRows) {

                    if (cell.getText().contains(Username)) {
                        System.out.println(Username);
                        return cell;
                    }
                }
                NextPageBtn().click();
                Thread.sleep(5000);

            } while (NextPageBtn().isEnabled());
        return null;
    }

    // Method. Will need above btn in TC
    public WebElement ResendInvitation(String Username) throws InterruptedException {

        do {
            List<WebElement> rows= driver.findElements(By.tagName("tr"));
             for (WebElement cell : rows) {

                if (cell.getText().contains(Username)) {
                    return cell;
                }
            }
            NextPageBtn().click();
            Thread.sleep(5000);
        }
        while (NextPageBtn().isEnabled()) ;

         return AssignPermission(Username);
    }// resend invitation to the same user


    // Method. Will need above btn in TC
    public WebElement DeleteUser(String Username) throws InterruptedException {

        do {
            List<WebElement> rows = driver.findElements(By.tagName("tr"));
            for (WebElement cell: rows){

                if (cell.getText().contains(Username)){
                    return cell;

                }
            }
            NextPageBtn().click();
            Thread.sleep(5000);
        } while (NextPageBtn().isEnabled());
        return null;
    }


    // method did not work
    /*public WebElement InviteUser(){driver.findElement(By.xpath("html/body/div[2]/section/div/div/h3/button")); return element;} // invite user btn*/


}