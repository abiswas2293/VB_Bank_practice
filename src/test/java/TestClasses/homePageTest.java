package TestClasses;

import PageClasses.homePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Baseclass;

public class homePageTest {
    Baseclass bc=new Baseclass();
    registrationPageTest rpt=new registrationPageTest();
    homePage hp=new homePage();

    @BeforeTest
    public void before() {
        bc.openBrowser();
    }

    @AfterTest
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
