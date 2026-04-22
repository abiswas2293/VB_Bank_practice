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

    public void openBrowser(String browser) {
        try {
            String executionType = System.getProperty("env");

            if (executionType == null)
                executionType = "";
            if (executionType.equalsIgnoreCase("grid")) {
                // ================== SELENIUM GRID MODE ==================
                String gridUrl = "http://localhost:4444";

                switch (browser.toLowerCase()) {
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                        break;


                    case "chrome":
                    default:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                        break;
                }
                System.out.println("✅ Running on SELENIUM GRID");
            } else {
                // ================== LOCAL MODE ==================

                switch (browser.toLowerCase()) {
                    case "firefox":
                        driver = new FirefoxDriver();
                        WebDriverManager.firefoxdriver().setup();
                        break;

                    case "edge":
                        driver = new EdgeDriver();
                        WebDriverManager.edgedriver().setup();
                        break;

                    case "chrome":
                    default:
                        driver = new ChromeDriver();
                        WebDriverManager.chromedriver().setup();
                        break;
                }
                System.out.println("✅ Running LOCALLY");
            }

            driver.manage().window().maximize();
            driver.get("https://vb-bank-demo.vercel.app/login");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void closeBrowser() {
        driver.quit();
    }
}
