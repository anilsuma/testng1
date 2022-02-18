package Pom.Pages;

import Pom.BASE.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private final By getQantity=By.xpath("//input[@type='number']");
 /*   private final By getproductname= By.cssSelector("td[class='product-name'] a");
    private final By clickcheckoutBtn=By.cssSelector(".checkout-button.button.alt.wc-forward");*////just we are implementing pagefactory elements
    private final By cartHeading=By.cssSelector(".has-text-align-center");
    @FindBy(css ="td[class='product-name'] a" ) @CacheLookup  private WebElement getproductname;
    @FindBy(css =".checkout-button.button.alt.wc-forward" ) private WebElement clickcheckoutBtn;
    public CartPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver,this);

    }
   public Boolean isLoaded(){
        return  wait.until(ExpectedConditions.textToBe(cartHeading,"Cart"));
    }
    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(getproductname)).getText();
    }
    public String getQantity(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getQantity)).getAttribute("value");
    }
    public CheckoutPage clickcheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(clickcheckoutBtn)).click();
        return new CheckoutPage(driver);
    }
}
