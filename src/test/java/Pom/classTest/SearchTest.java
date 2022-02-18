package Pom.classTest;

import Pom.BASE.BaseTest;
import Pom.Pages.Storepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
     public void searchwithPartialMatch() throws InterruptedException {
        String searchFor = "Blue";
        Storepage storepage = new Storepage(getDriver()).load();
       Thread.sleep(2000);
        storepage.search(searchFor);

        Assert.assertEquals(storepage.getTitleOfSearch(),"Search results: “"+searchFor+"”");
    }

}
