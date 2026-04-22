package TestClasses;

import PageClasses.loginPage;
import org.testng.annotations.*;
import utility.Baseclass;

public class loginPageTest {
    Baseclass bc = new Baseclass();
    loginPage lp = new loginPage();

    @BeforeClass
    @Parameters({"browser"})
    public void before(String browser) {
        bc.openBrowser(browser);
    }

    @AfterClass
    public void after() {
        bc.closeBrowser();
    }

    @Test
    public void verifyAllElementsOnLoginPageIsPresentAndEnabledAndUserInitiateToRegister(){
        lp.verifyLoginPageTitle();
        lp.verifyUserNameText();
        lp.verifyUserNameText();
        lp.verifyPasswordText();
        lp.verifyPasswordTextboxIsEnabled();
        lp.verifyLoginAsUserButton();
        lp.verifyLoginAsAdmin();
        lp.verifyLoginButton();
        lp.verifyRegisterHereButtonAndClickOnToRegister();
        lp.verifyAfterClickingOnRegisterHereButtonOnLoginPageUserIsOnRegistrationPage();
    }
}
