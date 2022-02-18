package Pom.Pages;

import Pom.BASE.BasePage;
import Pom.Objects.BillingAddress;
import Pom.Objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {
private final  By billingFirstName=  By.id("billing_first_name");
    private final  By billingLastName=  By.id("billing_last_name");
    private final  By billingAddress=  By.id("billing_address_1");
    private final By billingCity=  By.id("billing_city");
    private final By billingPostcode= By.id("billing_postcode");
    private final By billingEmail=By.id("billing_email");
    private final By billingPlaceOrder=By.id("place_order");
    private final By clickLoginBtn=By.cssSelector(".showlogin");
    private final By EnterUsername=By.cssSelector("#username");
    private final By EnterUserpassword=By.cssSelector("#password");
    private final By SubmitLogin=By.cssSelector("button[value='Login']");
    private final By overlay=By.cssSelector(".blockUI.blockOverlay");
    private final By successtxt=By.cssSelector(".woocommerce-notice");
    //private final By countryDropDown=By.id("billing_country");
   // private final By stateDropDown=By.id("billing_state");
    private final By directBnakTransferRadioBtn=By.id("payment_method_bacs");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public  CheckoutPage EnterbillingFisrtName(String Fname){
        WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(billingFirstName));
        e.clear();
        e.sendKeys(Fname);
        return this;
    }
    public CheckoutPage EnterbillingLastName(String Lname){
        WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(billingLastName));
        e.clear();
        e.sendKeys(Lname);
        return this;
    }
    public  CheckoutPage selectCountry(String countryName){
        By countryDropDown=By.id("select2-billing_country-container");
        wait.until(ExpectedConditions.elementToBeClickable(countryDropDown)).click();
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+countryName+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
       /* Select select=new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);*/

    }
    public  CheckoutPage EnterbillingAddress(String Address){
        WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress));
        e.clear();
        e.sendKeys(Address);
        return this;
    }
    public  CheckoutPage EnterbillingCity(String City){
        WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(billingCity));
        e.clear();
        e.sendKeys(City);
        return this;
    }
    public  CheckoutPage selectState(String StateName){
        By statedropDown=By.id("select2-billing_state-container");
        wait.until(ExpectedConditions.elementToBeClickable(statedropDown)).click();
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+StateName+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }
    public  CheckoutPage EnterbillingPostcode(String Postcode){
        WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostcode));
        e.clear();
        e.sendKeys(Postcode);
        return this;
    }
    public  CheckoutPage EnterbillingEmail(String Email){
        WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmail));
        e.clear();
        e.sendKeys(Email);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingAddress billingAddress){
      return  EnterbillingFisrtName(billingAddress.getFirstName()).
               EnterbillingLastName(billingAddress.getLastName()).selectCountry(billingAddress.getCountry()).
                EnterbillingAddress(billingAddress.getAddressLineone()).
                EnterbillingCity(billingAddress.getCity()).selectState(billingAddress.getState()).
                EnterbillingPostcode(billingAddress.getPostalcode()).
                EnterbillingEmail(billingAddress.getEmail());
    }
    public CheckoutPage ClickPlaceOrderBtn(){
     /* List<WebElement> overlays= driver.findElements(Overlays);
        System.out.println("overlay size"+overlays.size());
      if(overlays.size()>0){
          new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
          //if overlays are not cleared upto 15 sec then timeout exception will be thrown
      }
      System.out.println("overlays are invisible");*///we use a reusable method of this in basepage,so that anywhere overlay is there we can use that method

        waitOverlaysToDisappear(overlay);
      driver.findElement(billingPlaceOrder).click();
        return this;
    }


    public CheckoutPage clickHereToLoginLink(){
        wait.until(ExpectedConditions.elementToBeClickable(clickLoginBtn)).click();

        return this;
    }
    public CheckoutPage EnterUsername(String Username){//we may need these for negative test case for login check ,so declared public

        wait.until(ExpectedConditions.visibilityOfElementLocated(EnterUsername)).sendKeys(Username);
        return this;
    }
    public CheckoutPage EnterUserpassword(String password){//we may need these for negative test case for login check,so declared public
        wait.until(ExpectedConditions.visibilityOfElementLocated(EnterUserpassword)).sendKeys(password);

        return this;
    }
    public  CheckoutPage ClickLoginBtn(){//we may need these for negative test case for login check,so declared public
        wait.until(ExpectedConditions.elementToBeClickable(SubmitLogin)).click();
        return this;
    }


    public  CheckoutPage   Login(User user){
        EnterUsername(user.getUserName()).EnterUserpassword(user.getPassword()).ClickLoginBtn();

        return this;
    }

public String getSuccessTitle(){
  return wait.until(ExpectedConditions.elementToBeClickable(successtxt)).getText();
}
    public  CheckoutPage selectDirectBankTransfer(){
        WebElement e= wait.until(ExpectedConditions.elementToBeClickable(directBnakTransferRadioBtn));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }

}
