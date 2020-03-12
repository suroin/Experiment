package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public abstract class Page {

    @FindBy(className = "navbar-brand")
    WebElement logo;

    @FindBy(css = "a[href*=login]")
    WebElement loginButton;

    @FindBy(css = "a[href*=register]")
    WebElement registerButton;

    protected WebDriver driver;
    protected final String siteUrl = "https://qa.smclk.net";


    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void init() {
        PageFactory.initElements(this.driver, this);
    }


    public void open() {
        driver.manage().window().maximize();
        driver.get(siteUrl);
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //Wait element to be visible
    public void elementToBeVisible(WebElement element) {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new WebDriverException("Element is not visible");
        }
    }

    public void click(WebElement element) {
        elementToBeVisible(element);
        element.click();
    }

    public void clickOnLoginButton(){
        click(loginButton);
    }

    public void clickOnRegisterButton(){
        click(registerButton);
    }

    protected void waitElement(double seconds) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitUntilElementisClickable(WebElement element, int timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            Assert.fail("Page isn't loaded properly");
        }
    }

    protected boolean isElementTextEqual(WebElement element, String text, boolean ignoreCase) {
        try {
            if (ignoreCase) {
                return StringUtils.equalsIgnoreCase(element.getText(), text);
            } else {
                return StringUtils.equals(element.getText(), text);
            }
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitElementToBeDisplayed(WebElement element, int timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            Assert.fail("Page isn't loaded properly");
        }
    }


}



