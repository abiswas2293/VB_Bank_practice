package TestClasses;

import PageClasses.homePage;
import org.testng.annotations.*;
import utility.Baseclass;

public class homePageTest {
    Baseclass bc=new Baseclass();
    registrationPageTest rpt=new registrationPageTest();
    homePage hp=new homePage();

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
    public void verifyAllElementsArePresentOnHomePageAndVerifyAccountNumber(){
        rpt.verifyAfterFillingOutRegistrationPageUserIsSuccessfullyRegisteredAndRedirectToHomePage();
        hp.verifyAllSidePanelsArePresent();
        hp.verifyAllLiveCurrency();
    }

    @Test
    public void verifyAfterClickingOnTopUpUserIsOnTopUpPage(){
        rpt.verifyAfterFillingOutRegistrationPageUserIsSuccessfullyRegisteredAndRedirectToHomePage();
        hp.clickTopUp();
        hp.verifyTopUpPageUrl();
    }

    @Test
    public void verifyAfterClickingOnBillPaymentUserIsOnBillPaymentPage(){
        rpt.verifyAfterFillingOutRegistrationPageUserIsSuccessfullyRegisteredAndRedirectToHomePage();
        hp.clickBillPayment();
        hp.verifyBillPaymentPageUrl();
    }



}
