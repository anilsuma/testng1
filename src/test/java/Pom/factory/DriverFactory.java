package Pom.factory;

import Pom.constants.DriverType;
import Pom.utils.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class DriverFactory {

    public WebDriver initializedriver(String browser) {
        WebDriver driver;

        switch (DriverType.valueOf(browser)){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("illegal browser selection");

        }

      /*
*/
        driver.manage().window().maximize();


        return driver;
    }
}
