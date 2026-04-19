package TestClasses;

import PageClasses.registrationPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utility.Baseclass;

public class registrationPageTest {
    Baseclass bc = new Baseclass();
    registrationPage rp = new registrationPage();
    loginPageTest lpt = new loginPageTest();

    @BeforeTest
    public void before() {
        bc.openBrowser();
    }

    @AfterTest
    public void after() {
        bc.closeBrowser();
    }

    public void verifyAfterFillingOutRegistrationPageUserIsSuccessfullyRegisteredAndRedirectToHomePage(){
        lpt.verifyAllElementsOnLoginPageIsPresentAndEnabledAndUserInitiateToRegister();
        rp.verifyRegisterPageTitle();
        rp.verifyFullNameText();
        rp.verifyFullNameTextBoxIsPresentAndFillOut("ABC");
        rp.verifyUsernameText();
        rp.verifyUsernameTextBoxIsPresentAndFillOut("AB");
        rp.verifyEmailText();
        rp.enterEmailAddress("eyre@yopmail.com");
        rp.verifyPasswordText();
    }


}
