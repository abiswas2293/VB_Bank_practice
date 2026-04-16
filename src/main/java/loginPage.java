import ObjectRepository.loginPageLocators;
import org.openqa.selenium.By;
import utility.CommonFunctions;

public class loginPage {
    CommonFunctions cf = new CommonFunctions();
    loginPageLocators lpl = new loginPageLocators();
    String expectedLoginPageTitle="VB Bank";
    String expectedTextForLoginAsUserButton="Login as User";
    String expectedTextForLoginAsAdminButton="Login as Admin";
    String usernameText="username";

    public void verifyLoginPageTitle() {
        String actualPageTitle = cf.getText(By.xpath(lpl.pageTitle));
        cf.assertion(actualPageTitle,expectedLoginPageTitle );
        System.out.println("Login page title is verified and correct");
    }
    public void verifyLoginAsUserButton(){
        String actualText=cf.getText(By.xpath(lpl.loginPageUserButton));
        cf.assertion(actualText,expectedTextForLoginAsUserButton);
        System.out.println("Login as user button is verified and present there on login page ");
    }

    public void verifyLoginAsAdmin(){
        String actualText=cf.getText(By.xpath(lpl.loginAsAdminButton));
        cf.assertion(actualText,expectedTextForLoginAsAdminButton);
        System.out.println("Login as admin button is verified and present there on login page");
    }
    public void verifyUserNameText(){
        String actualText=cf.getText(By.xpath(lpl.usernameText));
        cf.assertion(actualText,usernameText);
        System.out.println("username is verified and present there on login page");
    }
}
