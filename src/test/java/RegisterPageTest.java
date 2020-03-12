import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterPageTest extends BaseTest{

    @Test
    protected void loginTest() {

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.init();
        registerPage.open();
        registerPage.clickOnRegisterButton();
        Assert.assertEquals(registerPage.getCurrentUrl(),"https://qa.smclk.net/register");

    }

}
