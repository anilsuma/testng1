package Pom.BASE;

import Pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
  /*  protected WebDriverWait waitlong;
    protected WebDriverWait waitshort;*///we can use 5 sec or 10 sec like
                                      // short or long wait stergies
                                     //if we thoroughly know that particular elements dont take more than that time
    public  BasePage(WebDriver driver){

        this.driver=driver;
        wait =new WebDriverWait(driver,Duration.ofSeconds(15));
       // waitshort=new WebDriverWait(driver,Duration.ofSeconds(5));

    }
    public void load(String endpoint){

        driver.get(ConfigLoader.getinstance().getBaseurl()+endpoint);;
    }
    public void waitOverlaysToDisappear(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("overlay size" + overlays.size());
        if (overlays.size() > 0) {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
            //if overlays are not cleared upto 15 sec then timeout exception will be thrown

            System.out.println("overlays are invisible");
        }
        else{
            System.out.println("overlays are not found");
        }

    }


}
