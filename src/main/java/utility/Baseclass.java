package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
    public static WebDriver driver;

    public void openBrowser(){
        driver=new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.quit();
    }
}
