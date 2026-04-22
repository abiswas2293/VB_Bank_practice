package TestClasses;

import PageClasses.billsPaymentPage;
import org.testng.annotations.*;
import utility.Baseclass;

public class billsPaymentPageTest {
    Baseclass bc=new Baseclass();
    homePageTest hpt=new homePageTest();
    billsPaymentPage bpp=new billsPaymentPage();
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
    @Parameters({"ProviderName","PaymentAmount","BillDescription"})
    public void userProceedToPayBillForVBPowerAndGetSuccessfulPaymentMessage(String ProviderName,String PaymentAmount,String BillDescription){
        hpt.verifyAfterClickingOnBillPaymentUserIsOnBillPaymentPage();
        bpp.verifyBillPaymentPageTitle();
        bpp.selectProvider(ProviderName);
        bpp.addAmountInAmountBox(PaymentAmount);
        bpp.addDescription(BillDescription);
        bpp.selectPayFromAccount();
        bpp.clickPayBillButton();
        bpp.verifySuccessFulPaymentMessage();

    }
}
