package PageClasses;

import ObjectRepository.homePageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class homePage {
    CommonFunctions cf = new CommonFunctions();
    homePageLocators hpl = new homePageLocators();
    String[] headers = {"Bill payments", "Cards", "Loans", "Top Up", "Settings", "Log out"};
    String expectedAccountNumber = "";
    String expectedTopUpPageUrl = "https://vb-bank-demo.vercel.app/top-up";

    public void verifyAllHeadersArePresent() {
        for (int i = 0; i < headers.length; i++) {
            cf.isPresent(By.xpath(hpl.headersNames(headers[i])));
        }
    }

    public void verifyAccountNumber() {
        cf.assertion(cf.getText(By.xpath(hpl.accountNumber)), expectedAccountNumber);
    }

    public void verifyAllLiveCurrency() {
        cf.ListOfStrings(By.xpath(hpl.liveCurrency()));
    }

    public void clickTopUp() {
        cf.click(By.xpath(hpl.headersNames("Top Up")));
    }

    public void verifyTopUpPageUrl() {
        cf.assertion(cf.getUrl(), expectedTopUpPageUrl);
    }

}
