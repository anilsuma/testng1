package Pom.Pages;

import Pom.BASE.BasePage;
import Pom.Pages.components.Thumbnails;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Storepage extends BasePage {
private final By searchFld =By.id("woocommerce-product-search-field-0");
private final By searchBtn =By.cssSelector("button[value=Search]");
//private final By addTocartBtn=By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");//product is hardcoded,so define separately a method to support multiple products dynamically

private final By gettitleofsearch=By.xpath("//h1[@class='woocommerce-products-header__title page-title']");



    private Thumbnails thumbnails;




    public Storepage(WebDriver driver) {
        super(driver);
      this.thumbnails=  new Thumbnails(driver);

    }
    @Step
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }
  @Step
  public Storepage load(){
        load("/store");
        return this;
  }
    public Boolean isUrlLoaded(){
        return  wait.until(ExpectedConditions.urlToBe("https://askomdch.com/?s=BLUE&post_type=product"));

    }

    public Boolean isLoaded(){
     return  wait.until(ExpectedConditions.urlMatches("https://askomdch.com/store/"));
     /*   wait.until(ExpectedConditions.urlToBe("https://askomdch.com/store/"));
        wait.until(ExpectedConditions.urlContains("/store/"));
        *///any one of above can be used
    }
   public Storepage entertxtInsearchFld(String txt){
       WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld));
       e.sendKeys(txt);
        return this;
    }
    public Storepage clickonsearchBtn(){
        WebElement e= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        e.click();
        return this;
    }
    public Storepage search(String txt){
        /*driver.findElement(searchFld).sendKeys(txt);
        driver.findElement(searchBtn).click();
        return this;*/ //// we directly call above methods as well and place above methods as private for now and whenever required we can make them public
      return   entertxtInsearchFld(txt).clickonsearchBtn();
    }
    public String getTitleOfSearch(){
       return  wait.until(ExpectedConditions.elementToBeClickable((gettitleofsearch))).getText();
    }


}
