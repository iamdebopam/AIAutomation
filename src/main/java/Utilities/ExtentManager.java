package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null){
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter spark= new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Automation using AI");
            spark.config().setDocumentTitle("Extent Spark Dashboard");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
