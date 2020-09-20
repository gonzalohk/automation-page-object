package base;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ReportManager;
import utils.OSValidator;
import pages.BasePage;
import org.openqa.selenium.TakesScreenshot;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import java.util.Date;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;

public class BaseTest {
    protected WebDriver webDriver;
    protected BasePage basePage;
    protected final String URL = "https://the-internet.herokuapp.com/";
    private final String DEFAULT_BROWSER = "chrome";
    private ExtentTest extentTest;
    /*//para capturas de pantalla/*
    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots"
        // under src folder
        String destination = System.getProperty("user.dir") + "C:\\Reports" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
*/
    public void openReport(String pathReport){

    }
    @BeforeSuite
    public static void setUpSuite() throws Exception {
        ReportManager.init("C:\\Reports", "Report");
    }
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional(DEFAULT_BROWSER) String browser,ITestResult iTestResult) throws Exception {
        String operatingSystem = OSValidator.isMac() ? "-mac" : OSValidator.isUnix() ? "-linux" : ".exe";
        //Report
        ReportManager.getInstance().startTest(iTestResult.getMethod().getMethodName());
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resources/chromedriver" + operatingSystem);
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","resources/geckodriver" + operatingSystem);
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new Exception(browser + " Does not supported");
        }
    }

    @AfterMethod//Modificado para reportes
    public void tearDown(ITestResult iTestResult){
        try {
            switch (iTestResult.getStatus()){
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if(iTestResult.getStatus() != ITestResult.FAILURE && iTestResult.getThrowable() != null){
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Failure Image");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(webDriver != null)
                webDriver.quit();
        }

    }
    //Para generar los reportes
    @AfterSuite
    public static void tearDownSuite(){
        ReportManager.getInstance().flush();

    }

}
