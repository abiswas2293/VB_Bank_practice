package TestClasses;

import PageClasses.topUpPage;
import org.testng.annotations.*;
import utility.Baseclass;

public class topUpPageTest {
    Baseclass bc=new Baseclass();
    homePageTest hpt=new homePageTest();
    topUpPage tup=new topUpPage();

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
    @Parameters({"AddAmount","AddAmountOnPopUpPage","UserCardNumber","UserCardHolderName","UserCardCvv","UserCardExpiryDate","AmountNumberInSuccessfulMessage"})
    public void verifyUserProceedToPayAndPaymentIsSuccessful(String AddAmount,String AddAmountOnPopUpPage,String UserCardNumber,String UserCardHolderName,String UserCardCvv,String UserCardExpiryDate,String AmountNumberInSuccessfulMessage ){
        hpt.verifyAfterClickingOnTopUpUserIsOnTopUpPage();
        tup.verifyTopUpPageTitle();
        tup.enterAmount(AddAmount);
        tup.clickProceedToPayment();
        tup.verifyPopOnSecurePaymentGatewayPage();
        tup.verifyAmountToPayOnPopUpPage(AddAmountOnPopUpPage);
        tup.enterCardNumberOnPopUpPage(UserCardNumber);
        tup.enterCardHolderNameOnPopUpPage(UserCardHolderName);
        tup.enterCvvOnPopUpPage(UserCardCvv);
        tup.enterExpiryDateOnPopUpPage(UserCardExpiryDate);
        tup.ClickPayButtonOnPopUpPage();
        tup.verifyUserGotSuccessfulMessageOnTopUpPage(AmountNumberInSuccessfulMessage);
    }

}
