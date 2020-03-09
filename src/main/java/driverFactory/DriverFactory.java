package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {


    public static WebDriver createDriver() {

        final WebDriver driver;
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        }
        driver = new ChromeDriver();
        return driver;
    }
}
