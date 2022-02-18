package Pom.classTest;

import Pom.BASE.BaseTest;
import Pom.Objects.Product;
import Pom.Pages.CartPage;
import Pom.Pages.Homepage;
import Pom.Pages.Storepage;
import Pom.dataproviders.myDataprovider;
import Pom.utils.JacksonUtils;
import io.qameta.allure.*;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Epic("cart functionality")
@Feature("add to cart")
public class AddToCart extends BaseTest {
    @Step
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @TmsLink("test-1")
    @Severity(SeverityLevel.CRITICAL)
    @Description("this  test is to check addtocart funtionality")
    @Test(description = "I am adding a product to cart from storepage")
     public void AddToCartFromStorepage() throws IOException {


        Product product = new Product(1215);

        CartPage cartPage = new Storepage(getDriver()).load().getThumbnails().
                clickaddTocartBtn(product.getName()).
                clickViewCartLink();
        Assert.assertEquals (cartPage.getProductName(), product.getName());
    }
    @Step
    @Story("add to cart playlist")
    @Test(dataProvider ="getfeaturedproducts",dataProviderClass = myDataprovider.class)
    public void AddToCartFeaturedProduct(String product) throws IOException {

        CartPage cartPage= new Homepage(getDriver()).load().getThumbnails().clickaddTocartBtn(product).clickViewCartLink();
        Assert.assertEquals (cartPage.getProductName(), product);

    }



}
