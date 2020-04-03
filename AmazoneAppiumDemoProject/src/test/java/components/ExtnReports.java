package components;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtnReports {

    ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;

    @BeforeTest
    public void reportSetup() {
        htmlReporter = new ExtentHtmlReporter("HTMLReport.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    @AfterTest
    public void reportTeardown() {

        extent.flush();
    }

}
