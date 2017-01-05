package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shilp on 12/23/2016.
 */
public class NaveBarPage {
    WebDriver driver;
    WebElement element;

        // constructor
        public NaveBarPage(WebDriver driver){
            this.driver = driver;
        }

        public WebElement Entities(){element=driver.findElement(By.xpath("//*/ul/li[2]/a"));
        return element;}

        public WebElement Users(){element= driver.findElement(By.xpath("/html/body/div[2]/aside[1]/div/nav/ul/li[3]"));
        return element;}

        public WebElement AddReport(){element= driver.findElement(By.xpath("//*/ul/li[4]/a"));
        return element;}

        public WebElement Reports(){element= driver.findElement(By.xpath("//*/ul/li[5]/a"));
        return element;}

   /*      public By Users(){ driver.findElement(By.xpath(".//*[@nav/ul/li[3]/a/span]"));
            return Users();
         }*/
}
