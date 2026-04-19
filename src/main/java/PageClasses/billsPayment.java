package PageClasses;

import ObjectRepository.billPaymentLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class billsPayment {
    CommonFunctions cf=new CommonFunctions();
    billPaymentLocators bpl=new billPaymentLocators();
    String expectedBillPaymentTitle="";

    public void verifyBillPaymentPageTitle(){
        cf.assertion(cf.getText(By.xpath(bpl.billPaymentTitle)),expectedBillPaymentTitle );
    }

    public void selectProvider(String providerName){
        cf.dropDown(By.xpath(bpl.selectProviderDropdownButton),providerName);
    }

    public void addAmountInAmountBox(String amountNumber){
        cf.typeText(By.xpath(bpl.amountBox),amountNumber);
    }

    public void addDescription(String description){
        cf.typeText(By.xpath(bpl.descriptionBox),description);
    }
    public void selectPayFromAccount(){
        cf.click(By.xpath(bpl.selectPaymentMethodWithPayFromAccount));
    }

    public void clickPayBillButton(){
        cf.click(By.xpath(bpl.selectPayBillButton));
    }

}
