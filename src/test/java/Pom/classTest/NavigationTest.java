package Pom.classTest;

import Pom.BASE.BaseTest;
import Pom.Pages.Homepage;
import Pom.Pages.Storepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    @Test
    public void NavigateFromStoreUsingMainmenu(){
        Homepage homepage = new Homepage(getDriver()).load();
        //  homepage.clickStoremenulink();
        Storepage storepage = homepage.getMyHeader().NavigateToStoreusingMenu();
        storepage.isLoaded();
        Assert.assertEquals(storepage.getTitleOfSearch(), "Store");
    }
}
