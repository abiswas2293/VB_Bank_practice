package TestClasses;

import PageClasses.registrationPage;
import org.testng.annotations.*;
import utility.Baseclass;

public class registrationPageTest {
    Baseclass bc = new Baseclass();
    registrationPage rp = new registrationPage();
    loginPageTest lpt = new loginPageTest();

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
    @Parameters({"UserFullName","UserName","UserEmailAddress","UserPassword"})
    public void verifyAfterFillingOutRegistrationPageUserIsSuccessfullyRegisteredAndRedirectToHomePage(String UserFullName,String UserName,String UserEmailAddress,String UserPassword){
        lpt.verifyAllElementsOnLoginPageIsPresentAndEnabledAndUserInitiateToRegister();
        rp.verifyRegisterPageTitle();
        rp.verifyFullNameText();
        rp.verifyFullNameTextBoxIsPresentAndFillOut(UserFullName);
        rp.verifyUsernameText();
        rp.verifyUsernameTextBoxIsPresentAndFillOut(UserName);
        rp.verifyEmailText();
        rp.enterEmailAddress(UserEmailAddress);
        rp.verifyPasswordText();
        rp.enterPassword(UserPassword);
        rp.fillSameConfirmedPass();
        rp.clickCreateAccount();
        rp.verifyUserIsOnHomePage();
    }


}
