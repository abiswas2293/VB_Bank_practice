package TestClasses;

import PageClasses.topUpPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Baseclass;

public class topUpPageTest {
    Baseclass bc=new Baseclass();
    homePageTest hpt=new homePageTest();
    topUpPage tup=new topUpPage();

    @BeforeTest
    public void before() {
        bc.openBrowser();
    }

    @AfterTest
    public void after() {
        bc.closeBrowser();
    }

    @Test
    public void verifyUserProceedToPayAndPaymentIsSuccessful(){
        hpt.verifyAfterClickingOnTopUpUserIsOnTopUpPage();
        tup.verifyTopUpPageTitle();
        tup.enterAmount();
        tup.clickProceedToPayment();
        tup.verifyPopOnSecurePaymentGatewayPage();
        tup.verifyAmountToPayOnPopUpPage();
        tup.enterCardNumberOnPopUpPage();
        tup.enterCardHolderNameOnPopUpPage();
        tup.enterCvvOnPopUpPage();
        tup.enterExpiryDateOnPopUpPage();
        tup.ClickPayButtonOnPopUpPage();
        tup.verifyUserGotSuccessfulMessageOnTopUpPage();
    }

}
