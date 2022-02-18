package Pom.classTest;

import Pom.BASE.BaseTest;
import Pom.Objects.BillingAddress;
import Pom.Pages.CartPage;
import Pom.Pages.CheckoutPage;
import Pom.Pages.Storepage;
import Pom.dataproviders.myDataprovider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test(dataProvider = "getbillingdetails",dataProviderClass = myDataprovider.class)
    public void checkoutusingstorepageproduct(BillingAddress billingAddress) {



        CartPage cartPage = new Storepage(getDriver()).load().getThumbnails().clickaddTocartBtn("Blue Shoes").clickViewCartLink();

        CheckoutPage checkoutPage = cartPage.clickcheckoutBtn();
        checkoutPage.setBillingDetails(billingAddress).selectDirectBankTransfer().ClickPlaceOrderBtn();


        Assert.assertEquals(checkoutPage.getSuccessTitle(), "Thank you. Your order has been received.");
    }

}
