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

    public UsersPage(WebDriver driver) {
        this.driver = driver;}

    By inviteUser = By.className("pull-right btn btn-info btn-sm"); // invite user btn
    By emailField = By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/form/div/input"); // email field on invite user btn
    By sendInvite = By.className("btn btn-primary mr"); // send invite btn - submit email
    By cancel = By.className("btn btn-default"); // cancel btn on invite user field
    By assignPermission = By.xpath(".//*[@div[3]/div/div/table/tbody/tr[1]/td[2]/button[1]]"); // permission btn
    By resendInvitation = By.xpath(".//*[@div[3]/div/div/table/tbody/tr[1]/td[2]/button[3]]"); // resend invite btn
    By deleteUser = By.xpath(".//*[@div[3]/div/div/table/tbody/tr[1]/td[2]/button[4]"); // delete user btn

    public WebElement emailField1() {
        return driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/form/div/input"));
    }

    public By getInviteUser() {
        return inviteUser;
    }
//
    public By getEmailField() {
        return emailField;
    }

    public By getSendInvite() {
        return sendInvite;
    }

    public By getCancel() {
        return cancel;
    }

    public By getAssignPermission() {
        return assignPermission;
    }

    public By getResendInvitation() {
        return resendInvitation;
    }

    public By getDeleteUser() {
        return deleteUser;
    }
}
