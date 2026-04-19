package PageClasses;

import ObjectRepository.homePageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class homePage {
    CommonFunctions cf = new CommonFunctions();
    homePageLocators hpl = new homePageLocators();
    String[] allSidePanelNames = {"Bill payments", "Cards", "Loans", "Top Up", "Settings", "Log out"};
    String expectedAccountNumber = "";
    String expectedTopUpPageUrl = "https://vb-bank-demo.vercel.app/top-up";
    String expectedBillPaymentUrl="https://vb-bank-demo.vercel.app/bill-pay";

    public void verifyAllSidePanelsArePresent() {
        for (String panel : this.allSidePanelNames) {
            if (cf.isPresent(By.xpath(hpl.sidePanel(panel)))) {
                cf.assertion(cf.getText(By.xpath(hpl.sidePanel(panel))), panel);
            } else
                System.out.println("Side Panel" + panel + " is not present");

            ;
        }
    }

    public void verifyAccountNumber() {
        cf.assertion(cf.getText(By.xpath(hpl.accountNumber)), expectedAccountNumber);
    }

    public void verifyAllLiveCurrency() {
        cf.ListOfStrings(By.xpath(hpl.liveCurrency()));
    }

    public void clickTopUp() {
        cf.click(By.xpath(hpl.sidePanel("Top Up")));
    }

    public void verifyTopUpPageUrl() {
        cf.assertion(cf.getUrl(), expectedTopUpPageUrl);
    }

    public void clickBillPayment(){
        cf.click(By.xpath(hpl.sidePanel("Bills Payment")));
    }
    public void verifyBillPaymentPageUrl() {
        cf.assertion(cf.getUrl(), expectedBillPaymentUrl);
    }


}
