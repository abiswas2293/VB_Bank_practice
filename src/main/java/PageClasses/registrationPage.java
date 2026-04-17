package PageClasses;

import ObjectRepository.registrationPageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class registrationPage {
    CommonFunctions cf = new CommonFunctions();
    registrationPageLocators rpl = new registrationPageLocators();
    String expectedRegistrationPageTitle = "";
    String expectedFullNameText = "";
    String expectedUsernameText = "";
    String expectedEmailText = "";
    String expectedPasswordText="";
    String expectedHomepageUrl="https://vb-bank-demo.vercel.app/dashboard";



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

    public void enterEmailAddress(String emailAddress) {
        if (cf.isPresent(By.xpath(rpl.emailTextBox))) {
            cf.typeText(By.xpath(rpl.emailTextBox), emailAddress);
        }
    }
    public void verifyPasswordText() {
        cf.assertion(cf.getText(By.xpath(rpl.passwordText)), expectedPasswordText);
    }

    String password;

    public void enterPassword(String password) {
        this.password= password;
        if (cf.isPresent(By.xpath(rpl.passwordTextBox))) {
            cf.typeText(By.xpath(rpl.passwordTextBox), password);
        }
    }



    public void fillSameConfirmedPass(){
        cf.typeText(By.xpath(rpl.confirmPasswordTextBox),this.password);
    }

    public void enterConfirmedPassword(String confirmedPassword){
        cf.typeText(By.xpath(rpl.confirmPasswordTextBox),confirmedPassword);
    }
    public void clickCreateAccount(){
        cf.click(By.xpath(rpl.createAccountButton));
    }
    public void verifyUserIsOnHomePage(){
        cf.assertion(cf.getUrl(),expectedHomepageUrl);

    }



}
