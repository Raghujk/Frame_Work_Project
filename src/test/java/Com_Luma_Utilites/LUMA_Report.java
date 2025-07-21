package Com_Luma_Utilites;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com_Luma_Test_Cases.LUMA_BaseClass;

public class LUMA_Report implements ITestListener {
	
	public ExtentSparkReporter report;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext tr) {
		String TimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String ReportName = "LUMA_TestReports" + TimeStamp + ".html";
		report =new ExtentSparkReporter("C:\\Users\\admin\\eclipse-workspace\\Frame_Work_Project\\LUMA_Reports\\"+ReportName);
		report.config().setDocumentTitle("LUMA Report");
		report.config().setReportName("LUMA_Registration_Validation");
		report.config().setTheme(Theme.STANDARD);
		
		extent =new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("User Name", "Raghu Prasad D");
		extent.setSystemInfo("HostName", "Local Host");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
		
	}
	public void onTestSuccess(ITestResult tr) {
		test =extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		
	}
	public void onTestFailure(ITestResult tr) {
		test =extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		try {
			String implocation = new LUMA_BaseClass().CaptureScreenShots(tr.getName());
			test.addScreenCaptureFromPath(implocation);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	public void onTestSkip(ITestResult tr) {
		test =extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREY));
		}
	public void onFinish(ITestContext tr) {
		extent.flush();
	}
}
