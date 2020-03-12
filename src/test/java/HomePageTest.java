import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class HomePageTest extends BaseTest{

    @Test
    protected void loginTest() {

      RegisterPage homePage = new RegisterPage(driver);
      homePage.init();
      homePage.open();
      homePage.clickOnLoginButton();
      Assert.assertEquals(homePage.getCurrentUrl(),"https://qa.smclk.net/login");

    }

}
