package listeners;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.Baseclass;   // ← Change this if your Baseclass package is different

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Create timestamp for unique report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Extent-Report-" + timeStamp + ".html";

        // Define report path
        String reportPath = "test-output/" + reportName;

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("VB Bank Automation Report");
        spark.config().setReportName("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Firefox");
        extent.setSystemInfo("Environment", "QA");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());

        // Take Screenshot on Failure
        if (Baseclass.driver != null) {
            try {
                String screenshotName = result.getName() + "_"
                        + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";

                // Take screenshot as file
                File src = ((TakesScreenshot) Baseclass.driver).getScreenshotAs(OutputType.FILE);

                // ====================== AUTOMATIC FOLDER CREATION ======================
                File screenshotDir = new File("test-output/screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();   // Creates both test-output and screenshots folders
                }

                File destination = new File(screenshotDir, screenshotName);

                // Copy screenshot
                org.openqa.selenium.io.FileHandler.copy(src, destination);

                // Attach screenshot to Extent Report
                test.addScreenCaptureFromPath("screenshots/" + screenshotName, "Failure Screenshot");

            } catch (IOException e) {
                test.log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();   // Generate the final report
        }
    }
}
