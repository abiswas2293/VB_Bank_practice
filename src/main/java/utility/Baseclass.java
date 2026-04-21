package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import java.net.MalformedURLException;
import java.net.URL;

public class Baseclass {
    public static WebDriver driver;

    public void openBrowser(@Optional("chrome") String browser,
                            @Optional("local") String execution) throws MalformedURLException {
        String executionType = execution.toLowerCase().trim();
        switch (executionType) {

            case "grid":
                // ================== SELENIUM GRID MODE ==================
                String gridUrl = "http://localhost:4444";

                switch (browser.toLowerCase()) {
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                        break;

                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                        break;

                    case "chrome":
                    default:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                        break;
                }
                System.out.println("✅ Running on SELENIUM GRID");
                break;
            case "local":
            default:
                // ================== LOCAL MODE ==================
                switch (browser.toLowerCase()) {
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;

                    case "edge":
                        driver = new EdgeDriver();
                        break;

                    case "chrome":
                    default:
                        driver = new ChromeDriver();
                        break;
                }
                System.out.println("✅ Running LOCALLY");
                break;
        }

        driver.manage().window().maximize();
        driver.get("https://vb-bank-demo.vercel.app/login");
    }

    public void closeBrowser(){
        driver.quit();
    }
}
