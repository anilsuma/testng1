package Pom.Pages.components;

import Pom.BASE.BasePage;
import Pom.Pages.CartPage;
import Pom.Pages.Homepage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Thumbnails extends BasePage {
private final By viewcartlink=By.cssSelector("a[title='View cart']");

    public Thumbnails(WebDriver driver) {
        super(driver);
    }



    private By getAddToCartBtnElement(String productName){//accessable to only this class not exposed to test class
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }
    @Step
    public Thumbnails clickaddTocartBtn(String productName){
        //  By addTocartBtn=By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");//may be it is required for other methods in this page so create method separately
        By addTocartBtn=getAddToCartBtnElement(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addTocartBtn)).click();
        return this;
    }
    @Step
    public CartPage clickViewCartLink(){
        wait.until(ExpectedConditions.elementToBeClickable(viewcartlink)).click();
        return new CartPage(driver);
    }

}
