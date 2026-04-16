package PageClasses;

import ObjectRepository.registrationPageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class registerPage {
    CommonFunctions cf = new CommonFunctions();
    registrationPageLocators rpl = new registrationPageLocators();
    String expectedRegistrationPageTitle = "";
    String expectedFullNameText = "";
    String expectedUsernameText = "";
    String expectedEmailText = "";


    public void verifyRegisterPageTitle() {
        cf.assertion(cf.getText(By.xpath(rpl.registerPageTitle)), expectedRegistrationPageTitle);
    }

    public void verifyFullNameText() {
        cf.assertion(cf.getText(By.xpath(rpl.fullNameText)), expectedFullNameText);
    }

    public void verifyFullNameTextBoxIsPresentAndFillOut(String fullName) {
        if (cf.isPresent(By.xpath(rpl.fullNameTextBox))) {
            cf.typeText(By.xpath(rpl.fullNameTextBox), fullName);
        }
    }

    public void verifyUsernameText() {
        cf.assertion(cf.getText(By.xpath(rpl.usernameText)), expectedUsernameText);
    }

    public void verifyUsernameTextBoxIsPresentAndFillOut(String username) {
        if (cf.isPresent(By.xpath(rpl.usernameTextBox))) {
            cf.typeText(By.xpath(rpl.usernameTextBox), username);
        }
    }

    public void verifyEmailText() {
        cf.assertion(cf.getText(By.xpath(rpl.emailText)), expectedEmailText);
    }

    public void verifyEmailTextBoxIsPresentAndFillOut(String emailAddress) {
        if (cf.isPresent(By.xpath(rpl.emailTextBox))) {
            cf.typeText(By.xpath(rpl.emailTextBox), emailAddress);
        }
    }



}
