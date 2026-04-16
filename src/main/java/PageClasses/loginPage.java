package PageClasses;

import ObjectRepository.loginPageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class loginPage {
    CommonFunctions cf = new CommonFunctions();
    loginPageLocators lpl = new loginPageLocators();
    String expectedLoginPageTitle = "VB Bank";
    String expectedTextForLoginAsUserButton = "Login as User";
    String expectedTextForLoginAsAdminButton = "Login as Admin";
    String expectedUsernameText = "username";
    String expectedPasswordText = "password";
    String expectedLoginButton = "Login";
    String expectedRegisterHereButton = "Register here";
    String expectedRegistrationPageGetUrl = "https://vb-bank-demo.vercel.app/register";

    public void verifyLoginPageTitle() {
        String actualPageTitle = cf.getText(By.xpath(lpl.pageTitle));
        cf.assertion(actualPageTitle, expectedLoginPageTitle);
        System.out.println("Login page title is verified and correct");
    }

    public void verifyLoginAsUserButton() {
        String actualText = cf.getText(By.xpath(lpl.loginPageUserButton));
        cf.assertion(actualText, expectedTextForLoginAsUserButton);
        System.out.println("Login as user button is verified and present there on login page ");
    }

    public void verifyLoginAsAdmin() {
       // String actualText = cf.getText(By.xpath(lpl.loginAsAdminButton));
        cf.assertion(cf.getText(By.xpath(lpl.loginAsAdminButton)), expectedTextForLoginAsAdminButton);
        System.out.println("Login as admin button is verified and present there on login page");
    }

    public void verifyUserNameText() {
        String actualText = cf.getText(By.xpath(lpl.usernameText));
        cf.assertion(actualText, expectedUsernameText);
        System.out.println("username is verified and present there on login page");
    }

    public void verifyPasswordText() {
        String actualText = cf.getText(By.xpath(lpl.passwordText));
        cf.assertion(actualText, expectedPasswordText);
        System.out.println("password is verified and present there on login page");
    }

    public void verifyUsernameTextboxIsEnabled() {
        if (cf.isPresent(By.xpath(lpl.usernameTextBox))) {
            System.out.println("Username Textbox is enabled");
        } else {
            System.out.println("Username TextBox is disabled");
        }
    }

    public void verifyPasswordTextboxIsEnabled() {
        if (cf.isPresent(By.xpath(lpl.passwordTextBox))) {
            System.out.println("Password Textbox is enabled");
        } else {
            System.out.println("Password TextBox is disabled");
        }
    }

    public void verifyLoginButton() {
        String actualText = cf.getText(By.xpath(lpl.loginButton));
        cf.assertion(actualText, expectedLoginButton);
        System.out.println("Login button is verified and present on login page");
    }

    public void verifyRegisterHereButtonAndClickOnToRegister() {
        String actualText = cf.getText(By.xpath(lpl.registerHereButton));
        cf.assertion(actualText, expectedRegisterHereButton);
        System.out.println("Register here button is verified and present on login page");
        cf.click(By.xpath(lpl.registerHereButton));
    }

    public void verifyAfterClickingOnRegisterHereButtonOnLoginPageUserIsOnRegistrationPage() {
       String actualUrl=cf.getUrl();
       cf.assertion(actualUrl,expectedRegistrationPageGetUrl);
       System.out.println("User is on Registration page");
    }
}
