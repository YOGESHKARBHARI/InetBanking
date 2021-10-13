package Utilities;
//This is listener class use to generate extent reports.

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Reports extends TestListenerAdapter
{
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;

	public void onStart(ITestContext testcontext) {
		String datename = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname = "Test-Report-" + datename + ".html";
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + reportname);
		reporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		
		

		reports = new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("Host Name", "Local Host");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("User Name", "Yogesh Karbhari");
		reports.setSystemInfo("OS", "Windows");
		
		reporter.config().setDocumentTitle("Functional Testing");
		reporter.config().setReportName("Automation Testing");
		reporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

		String datename = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String screenshotname = System.getProperty("user.dir")+"//Screenshots//"+result.getName()+ datename+".png";
		File file = new File(screenshotname);
		if (file.exists()) {
			try {
				test.fail("Test is fail with details:" + test.addScreenCaptureFromPath(screenshotname));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.LIME));
	}

	public void onFinish(ITestContext testcontext) {
		reports.flush();
	}
}