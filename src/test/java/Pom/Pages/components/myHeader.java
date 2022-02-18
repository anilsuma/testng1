package Pom.Pages.components;

import Pom.BASE.BasePage;
import Pom.Pages.Storepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class myHeader extends BasePage {
    private final By Storemenulink=  By.cssSelector("li[id='menu-item-1227'] a");

    public myHeader(WebDriver driver) {
        super(driver);
    }

    public Storepage NavigateToStoreusingMenu(){
        driver.findElement(Storemenulink).click();
        return new Storepage(driver);
    }
}
