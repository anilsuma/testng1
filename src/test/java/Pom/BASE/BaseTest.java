package Pom.BASE;

import Pom.factory.DriverFactory;
//import org.junit.After;
//import org.junit.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.screentaker.ShootingStrategy;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;

public class BaseTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver) {//encapsulation means only  this class has access to set the driver
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {//encapsulation only child of this class can only use this method
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void StartDriver(@Optional String browser) {
       //   browser=System.getProperty("browser");

        setDriver(new DriverFactory().initializedriver(browser));
        System.out.println("thread is:" + Thread.currentThread().getId() + "," + "current driver" + getDriver());

    }
    @Attachment("my attachment")
    @Parameters("browser")
    @Description("attachments")
    @AfterMethod
    public void QuitDriver(@Optional String browser, ITestResult result) throws InterruptedException, IOException {
        Thread.sleep(200);
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("scr" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_"
                    + result.getMethod().getMethodName() + ".png");
           // takeScreenshot(destFile);
            takescreenshotUsingAshot(destFile);

            Allure.addAttachment("My attachment", "My attachment content");

            Path content = Paths.get(String.valueOf(destFile));
            try (InputStream is = Files.newInputStream(content)) {
                Allure.addAttachment("My attachment", is);
            }

        }
        System.out.println("thread is:" + Thread.currentThread().getId() + "," + "current driver" + getDriver());
        getDriver().quit();

    }
    private void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();
        File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,destFile);
    }

    private void takescreenshotUsingAshot(File destFile){
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.
                                          viewportPasting(1000)).
                                         takeScreenshot(getDriver());
      try{
          ImageIO.write(screenshot.getImage(),"PNG",destFile);
      }
     catch (IOException e) {
          e.printStackTrace();
      }


    }
}