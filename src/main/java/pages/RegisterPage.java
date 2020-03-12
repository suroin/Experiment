package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void waitPageToBeLoaded() {
        waitUntilElementisClickable(logo,5);
    }


    public void googleSearch(String str){
        registerButton.sendKeys(str);
        registerButton.sendKeys(Keys.ENTER);
    }

    private   List<WebElement>  getSearchResults(){
        List<WebElement> searchResults = driver.findElements(By.cssSelector("[class=r]"));
        return searchResults;
    }

    // Google first search result is images, we will check starting 2nd result
    public String getSearcResultsText(int index){

        try {
            return getSearchResults().get(index ).getText();
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        return "";
    }
}
