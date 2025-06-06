package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;

public class ExtentReportHooks {
    private static ExtentReports extent;
    private static ExtentTest scenarioTest;

    @BeforeAll
    public static void setup() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioTest = extent.createTest(scenario.getName());
    }

    @AfterStep
    public void logStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTest.fail("Step failed");
        } else {
            scenarioTest.pass("Step passed");
        }
    }

    @AfterAll
    public static void tearDown() {
        extent.flush();
    }
}