package Pom.Pages;

import Pom.BASE.BasePage;
import Pom.Pages.components.Thumbnails;
import Pom.Pages.components.myHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BasePage {
    private Thumbnails thumbnails;
    private myHeader myHeader;
    public Homepage(WebDriver driver) {
        super(driver);
       this.thumbnails= new Thumbnails(driver);
       this.myHeader= new myHeader(driver);
    }


    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public myHeader getMyHeader() {
        return myHeader;
    }

    public void setMyHeader(myHeader myHeader) {
        this.myHeader = myHeader;
    }




    public Homepage load(){//overloaded the basepage method
        load("/");
       wait.until(ExpectedConditions.titleIs("AskOmDch – Become a Selenium automation expert!"));
        return this;
    }


}
