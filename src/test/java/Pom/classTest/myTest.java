package Pom.classTest;

import Pom.BASE.BaseTest;
import Pom.Objects.BillingAddress;
import Pom.Objects.Product;
import Pom.Objects.User;
import Pom.Pages.CartPage;
import Pom.Pages.CheckoutPage;
import Pom.Pages.Homepage;
import Pom.Pages.Storepage;
import Pom.utils.ConfigLoader;
import Pom.utils.JacksonUtils;
//import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.Assert;

import java.io.IOException;

public class myTest extends BaseTest {

    // @Test

    @Test
    public void Guestcheckoutusingdirectbanktransfer() throws InterruptedException, IOException {
        String searchFor = "Blue";


        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);

        Product product = new Product(1215);


        Homepage homepage = new Homepage(getDriver()).load();
        //  homepage.clickStoremenulink();
        Storepage storepage = homepage.getMyHeader().NavigateToStoreusingMenu();
        storepage.isLoaded();

        storepage.search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storepage.getTitleOfSearch(), "Search results: “Blue”");
        Thread.sleep(2000);
        storepage.getThumbnails().clickaddTocartBtn(product.getName());

        CartPage cartPage = storepage.getThumbnails().clickViewCartLink();

        cartPage.isLoaded();

        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getQantity(), "1");


        CheckoutPage checkoutPage = cartPage.clickcheckoutBtn();
        //  driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();

        checkoutPage.setBillingDetails(billingAddress).selectDirectBankTransfer().ClickPlaceOrderBtn();


        Assert.assertEquals(checkoutPage.getSuccessTitle(), "Thank you. Your order has been received.");
    }

    @Test
    public void LoginAndcheckoutusingdirectbanktransfer() throws InterruptedException, IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        // FileInputStream is=new FileInputStream("src/test/resources/myBillingAddress.json"); //enter directly in deserialize method
        // billingAddress= JacksonUtils.deserializeJson("myBillingAddress.json",billingAddress.getClass());//directly placed in above before to above line
        //  is.close();
        Product product = new Product(1215);
        User user = new User(ConfigLoader.getinstance().getusername(), ConfigLoader.getinstance().getpassword());//later we will use config file to fetch user data from there,if more no of users are then using json is better


        Homepage homepage = new Homepage(getDriver()).load();
        //  homepage.clickStoremenulink();
        Storepage storepage = homepage.getMyHeader().NavigateToStoreusingMenu();
        storepage.isLoaded();

        // storepage.entertxtInsearchFld("Blue");/////we are staying on same page(storepage) only so we use builder pattern
        //   storepage.clickonsearchBtn();/////we are staying on same page(storepage) only so we use builder pattern
        //builder pattern below for above two steps
        //  storepage.entertxtInsearchFld("Blue").clickonsearchBtn();//this builder pattern and better way is to use functional page object focusses on functionality below given
        storepage.search(searchFor);
        Thread.sleep(2000);
        Assert.assertEquals(storepage.getTitleOfSearch(), "Search results: “Blue”");
        Thread.sleep(2000);
        storepage.getThumbnails().clickaddTocartBtn(product.getName());

        CartPage cartPage = storepage.getThumbnails().clickViewCartLink();
        cartPage.isLoaded();

        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getQantity(), "1");


        CheckoutPage checkoutPage = cartPage.clickcheckoutBtn();
        //  driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();


        checkoutPage.clickHereToLoginLink();

        checkoutPage.Login(user);

        checkoutPage.setBillingDetails(billingAddress).selectDirectBankTransfer().ClickPlaceOrderBtn();


        Assert.assertEquals(checkoutPage.getSuccessTitle(), "Thank you. Your order has been received.");

    }
}