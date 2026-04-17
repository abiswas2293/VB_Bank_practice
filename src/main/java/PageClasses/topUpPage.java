package PageClasses;

import ObjectRepository.topUpPageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class topUpPage {
    CommonFunctions cf=new CommonFunctions();
    topUpPageLocators tpl=new topUpPageLocators();
    String expectedTopUpPageTitle="Top Up Account";
    String expectedPopUpPaymentGatewayTitle="SecurePay Gateway";
    String amount="100";
    String cardNumber="1234567812345678";
    String cardHolderName="AB";
    String CVV="123";
    String expiryDate="07/28";
    String successfulMessageForAddedMoney="Successfully added $100.00 to your account!";

    public void verifyTopUpPageTitle(){
        cf.assertion(cf.getText(By.xpath(tpl.topUpPageTitle)),expectedTopUpPageTitle);
    }

    public void enterAmount(){
        cf.typeText(By.xpath(tpl.enterAmount),this.amount);
    }

    public void clickProceedToPayment(){
        cf.click(By.xpath(tpl.proceedToPaymentButton));
    }
    public void verifyPopOnSecurePaymentGatewayPage(){
        cf.assertion(cf.getText(By.xpath(tpl.popSecurePayGatewayTitle)),expectedPopUpPaymentGatewayTitle);
    }
    public void verifyAmountToPayOnPopUpPage(){
        cf.assertion(cf.getText(By.xpath(tpl.amountPayOnPopUpPage)),this.amount);
    }
    public void enterCardNumberOnPopUpPage(){
        cf.typeText(By.xpath(tpl.cardNumberOnPopUp),this.cardNumber);
    }
    public void enterCardHolderNameOnPopUpPage(){
        cf.typeText(By.xpath(tpl.cardHolderNameOnPopUp),this.cardHolderName);
    }
    public void enterCvvOnPopUpPage(){
        cf.typeText(By.xpath(tpl.cvvOnPopUp),this.CVV);
    }
    public void enterExpiryDateOnPopUpPage(){
        cf.typeText(By.xpath(tpl.expiryDateOnPopUp),this.expiryDate);
    }
    public void ClickPayButtonOnPopUpPage(){
        cf.click(By.xpath(tpl.payButtonOnPopUP));
    }
    public  void verifyUserGotSuccessfulMessageOnTopUpPage(){
       cf.assertion(cf.getText(By.xpath(tpl.SuccessfulMessageForAddedMoneyOnTopUpPage)),this.successfulMessageForAddedMoney);
    }
}
