package TestClasses;

import PageClasses.loginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Baseclass;

public class loginPageTest {
    Baseclass bc = new Baseclass();
    loginPage lp = new loginPage();

    @BeforeTest
    public void before() {
        bc.openBrowser();
    }

    @AfterTest
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
