package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shilp on 1/4/2017.
 */
public class EntityPage {
    WebDriver driver;

    public EntityPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement AddEntityBtn(){return driver.findElement(By.xpath("//h3/button"));}// btn to create entity
    public WebElement EntityName(){return driver.findElement(By.xpath("//form//div[1]/div/input"));}
    public WebElement Phone(){return driver.findElement(By.name("phone"));}
    public WebElement EmailField(){return driver.findElement(By.xpath("//form/div[1]/div[3]//input"));}
    public WebElement EntityLogoBtn(){return driver.findElement(By.xpath("//form//div[2]/button[1]"));}
    public WebElement DeleteLogoBtn(){return driver.findElement(By.xpath("//form//div[2]/button[2]"));}
    public WebElement CountryField(){return  driver.findElement(By.name("country"));}
    public WebElement Address1Field(){return driver.findElement(By.name("address1"));}
    public WebElement Address2Field(){return driver.findElement(By.xpath("//form//div[4]/input"));}
    public WebElement CityField(){return driver.findElement(By.name("city"));}
    public WebElement StateField(){return driver.findElement(By.name("state"));}
    public WebElement PostalCodeField(){return driver.findElement(By.name("zip"));}
    public WebElement NotesField(){return driver.findElement(By.xpath("//div/textarea"));}
    public WebElement PreviousStepBtn(){return driver.findElement(By.xpath("//section/div/div/div[2]/button[1]"));}
    public WebElement NextStepBtn(){return driver.findElement(By.xpath("//section/div/div/div[2]/button[2]"));}
    public WebElement InviteRUField(){return driver.findElement(By.xpath("//section//form/div[1]/div/input"));}

    /*Below btn had ngdialog no which is different on each row. ngdialog1, ngdialog2 on each row
     So to dismiss an element not found error, we add text and mention it in the method "+text+"*/
    public WebElement RUDoneBtn(int i){return driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]/div[2]/div/button"));}

    public WebElement FinishBtn(){return driver.findElement(By.xpath("//section/div/div/div[2]/button[2]"));}
    public WebElement InviteAdminEmail(){return driver.findElement(By.xpath("//section//div[3]/form//input"));}

    // Below btn has ngdialog So to dismiss an element not found error, we add text and mention it in the method. "+text+"
    public WebElement AdminDoneBtn(int Adminumber){return driver.findElement(By.xpath("//*[@id=\"ngdialog"+Adminumber+"\"]/div[2]/div/button"));}


    public WebElement DeleteEntityBtn(){return driver.findElement(By.cssSelector(".fa.fa-trash"));}
    // Below btn has different ngdialog no., so we add a text and mention it as an integer in the method. When using loop, just i+1 in the method.
    public WebElement ConfirmDeleteEntityBtn(int deleteNumber){return driver.findElement(By.xpath("//*[@id=\"ngdialog"+deleteNumber+"\"]/div[2]/div/button[1]"));}

    // clean up the page
    public void DeleteAllEntities() throws InterruptedException {
        /*List<WebElement> rows1 = (driver.findElements(By.tagName("tr"))); // list of rows.
        14 rows and 12 btns - used breakpoint at loop to find out so tr won't work easily. Btn logic is easy to use.*/

        //  List<WebElement> btn = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".fa.fa-trash"))); // array list of delete btns.
        List<WebElement> btn = (driver.findElements(By.cssSelector(".fa.fa-trash"))); // list of btns works perfectly as well
        for (int i =0; i<btn.size();i++ ){
            Thread.sleep(3000);
            //DeleteEntityBtn().click(); does not work
            btn.get(i).click();
            Thread.sleep(3000);
            ConfirmDeleteEntityBtn(i+1).click();

        }

//        List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".fa.fa-trash")));
//        for (int i = 0; i<list.size();i++)
//        {
//           Thread.sleep(2000);
//            list.get(i).click();
//            Thread.sleep(2000);
//            ConfirmDeleteEntityBtn(i+1).click();
//        }
    }

}
