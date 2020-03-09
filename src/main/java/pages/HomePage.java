package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;
import java.util.List;

public class HomePage extends Page {

    @FindBy(css = "[name=q]")
    WebElement searchInputField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitPageToBeLoaded() {
        waitUntilElementisClickable(logo,5);
    }

    public void googleSearch(String str){
        searchInputField.sendKeys(str);
        searchInputField.sendKeys(Keys.ENTER);
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
