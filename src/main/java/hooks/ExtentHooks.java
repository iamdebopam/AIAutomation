package hooks;

import Utilities.DriverFactory;
import Utilities.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class ExtentHooks {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> scenarioThread = new ThreadLocal<>();
    private WebDriver driver;

    @Before
    public void beforeScenario(Scenario scenario){
        ExtentTest test = extent.createTest(scenario.getName());
        scenarioThread.set(test);
        driver= DriverFactory.getDriver();

        // Load feature file lines into a map
        FeatureParser.loadFeatureLines(scenario.getUri());
        /*scenarioThread.set(ExtentManager.createTest(scenario.getName()));*/
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        if(driver == null){
            driver=DriverFactory.getDriver();
        }

        String stepInfo = FeatureParser.getStepInfo(scenario.getLine());
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, stepInfo);


        String screenshotPath = ScreenshotUtil.captureScreenshot(driver,scenario.getName().replaceAll(" ","_"));
        if(scenario.isFailed()){
            scenarioThread.get().fail("Step failed " + stepInfo, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else{
            scenarioThread.get().pass("Step passed " + stepInfo, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @After
    public void afterScenario(){
        extent.flush();
    }
}
