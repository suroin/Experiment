import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest{

    @Test
    protected void checkIfGoogleIsOpened() {

      HomePage homePage = new HomePage(driver);
      homePage.open();
        String currentUrl = driver.getCurrentUrl().toString();
        Assert.assertEquals(currentUrl,
                "https://www.google.com/");
    }

    @Test
    public void searchInGoogle(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.googleSearch("banana");
        String seacrhResult = homePage.getSearcResultsText(1);
        Assert.assertTrue(seacrhResult.contains("banana"),"Google search worked incoorectly, search result is: " + seacrhResult);

    }

}
