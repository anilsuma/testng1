package Pom.dataproviders;

import Pom.Objects.BillingAddress;
import Pom.Objects.Product;
import Pom.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myDataprovider {
    @DataProvider(name = "getfeaturedproducts")//addtocart featured products in homepage
    public Object[]  getfeaturedproducts() throws IOException {

     /*   Product[] products= JacksonUtils.deserializeJson("products.json", Product[].class);
        List<Object> productname=new ArrayList<>();
        for (Product product:products){
            if(product.getFeatured()){
                productname.add(product.getName());
            }

        }
        Object[] o=productname.toArray();
     return o;*/
        Product[] products= JacksonUtils.deserializeJson("products.json", Product[].class);
        List<Object> productname=new ArrayList<>();
        for (Product product:products) {
               if (product.getFeatured() == null) {
                continue;
            }

               else if (product.getFeatured() != null & product.getFeatured()) {
                    productname.add(product.getName());
                }



            System.out.println(productname);
        }

        Object[] o=productname.toArray();
        return o;
    }
    @DataProvider(name = "getbillingdetails")
    public Object[]  getbillingaddress() throws IOException {


      return JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress[].class);


}

}
