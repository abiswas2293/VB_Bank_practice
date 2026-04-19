package TestClasses;

import PageClasses.billsPaymentPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Baseclass;

public class billsPaymentPageTest {
    Baseclass bc=new Baseclass();
    homePageTest hpt=new homePageTest();
    billsPaymentPage bpp=new billsPaymentPage();
    @BeforeTest
    public void before() {
        bc.openBrowser();
    }

    @AfterTest
    public void after() {
        bc.closeBrowser();
    }

    @Test
    public void userProceedToPayBillForVBPowerAndGetSuccessfulPaymentMessage(){
        hpt.verifyAfterClickingOnBillPaymentUserIsOnBillPaymentPage();
        bpp.verifyBillPaymentPageTitle();
        bpp.selectProvider("VB Power");
        bpp.addAmountInAmountBox("10");
        bpp.addDescription("Electric Bill");
        bpp.selectPayFromAccount();
        bpp.clickPayBillButton();
        bpp.verifySuccessFulPaymentMessage();

    }
}
