import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;


public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void initDriver() {
        driver = DriverFactory.createDriver();
    }

    @AfterTest()
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }



    @Test
    protected void checkIfGoogleIsOpened() {

        driver.manage().window().maximize();
        driver.get("https://google.com");
        String currentUrl = driver.getCurrentUrl().toString();
        Assert.assertEquals(currentUrl,
                "https://google.com");
    }

}
