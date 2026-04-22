package PageClasses;

import ObjectRepository.topUpPageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class topUpPage {
    CommonFunctions cf=new CommonFunctions();
    topUpPageLocators tpl=new topUpPageLocators();
    String expectedTopUpPageTitle="Top Up Account";
    String expectedPopUpPaymentGatewayTitle="SecurePay Gateway";
   // String amount="100";
    //String cardNumber="1234567812345678";
    //String cardHolderName="AB";
    //String CVV="123";
    //String expiryDate="07/28";
    //String successfulMessageForAddedMoney="Successfully added $100.00 to your account!";

    public void verifyTopUpPageTitle(){
        cf.assertion(cf.getText(By.xpath(tpl.topUpPageTitle)),expectedTopUpPageTitle);
    }

    public void enterAmount(String amount){
        cf.typeText(By.xpath(tpl.enterAmount),amount);
    }

    public void clickProceedToPayment(){
        cf.click(By.xpath(tpl.proceedToPaymentButton));
    }
    public void verifyPopOnSecurePaymentGatewayPage(){
        cf.assertion(cf.getText(By.xpath(tpl.popSecurePayGatewayTitle)),expectedPopUpPaymentGatewayTitle);
    }
    public void verifyAmountToPayOnPopUpPage(String Amount){
        cf.assertion(cf.getText(By.xpath(tpl.amountPayOnPopUpPage)),Amount);
    }
    public void enterCardNumberOnPopUpPage(String UserCardNumber ){
        cf.typeText(By.xpath(tpl.cardNumberOnPopUp),UserCardNumber);
    }
    public void enterCardHolderNameOnPopUpPage(String UserCardHolderName){
        cf.typeText(By.xpath(tpl.cardHolderNameOnPopUp),UserCardHolderName);
    }
    public void enterCvvOnPopUpPage(String UserCVV){
        cf.typeText(By.xpath(tpl.cvvOnPopUp),UserCVV);
    }
    public void enterExpiryDateOnPopUpPage(String expiryDate){
        cf.typeText(By.xpath(tpl.expiryDateOnPopUp),expiryDate);
    }
    public void ClickPayButtonOnPopUpPage(){
        cf.click(By.xpath(tpl.payButtonOnPopUP));
    }
    public  void verifyUserGotSuccessfulMessageOnTopUpPage(String Amount){
       cf.assertion(cf.getText(By.xpath(tpl.SuccessfulMessageForAddedMoneyOnTopUpPage)),"Successfully added $"+Amount+".00 to your account!");
    }
}
