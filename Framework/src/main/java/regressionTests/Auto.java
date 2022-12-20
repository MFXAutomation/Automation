package regressionTests;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import freemarker.core.ParseException;
import funClass.functions.Driver;
import funClass.functions.Login;
import funClass.functions.Policy;
import funClass.functions.Vehicle;
import functions.DataManagement;
import functions.Global;
import functions.Reporting;
import parameters.pdParams;

public class Auto extends BaseTest {

	private static String iterationCount;

	pdParams testParams = new pdParams();
	pdParams testParams2 = new pdParams();
	
	@Parameters({ "executionLocation", "url", "EnvironmentCode" })
	@Test(groups = { "Regression", "Auto", "AL" })
	public void createPolicy(@Optional("local") String executionLocation,
			@Optional("") String sURL,
			@Optional("QA") String sEnvironmentCode) throws InterruptedException, ParseException {

		pdParams testParams = new pdParams();

		testParams.sTestName = testcase;
//		transType=testParams.sTestName;
		testParams.sCurrClass = "AL";
		
				testParams.dataFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\TestData.xlsx";
		String className = "Auto";

		int iTestStatus = 0;

//		Reporting.PrintLn(testParams, "Execution should be = " + executionLocation);

		testParams.extTest = extent.createTest(testParams.sTestName);

		List<HashMap<String, String>> testData = null;
		List<HashMap<String, String>> testData2 = null;
		
	

		try {
			// Load Global Data Into testData HasMap
			testData = DataManagement.LoadExcelData(testParams.dataFilePath, "Global");
		} catch (Exception e) {
			Reporting.PrintLn(testParams, "An exception was thrown while loading the data sheet = "
					+ testParams.dataFilePath + "\r\nException: " + e + "\r\nStacktrace: " + e.getStackTrace());
			return;
		}

		Reporting.LogTestMessage(testParams, Status.INFO, "Number of iterations = " + testData.size(), false);
		String sIterDescription = "";
		String sBrowserType = "";
		String sURLLocation = "";

//		iterationCount=String.valueOf(iterCount);
		
		for (int gIter = 0; gIter < 1; gIter++) {
			Global.RunActionControl = String.valueOf(gIter + 1);
			testParams.runActionControl = String.valueOf(gIter + 1);
			sIterDescription = DataManagement.GetData(testParams, testData, gIter, "IterationDescription");

			sIterDescription = (sIterDescription.equals("")) ? className : sIterDescription;

			sBrowserType = DataManagement.GetData(testParams, testData, gIter, "BrowserType");
			sBrowserType = (sBrowserType.equals("")) ? "Chrome" : sBrowserType;

			Reporting.PrintLn(testParams, "Global iteration = " + (gIter + 1) + " - " + sIterDescription);

			testParams.driver = Global.CreateWebDriver(testParams, sBrowserType, executionLocation, false);
			
			long startTime = System.currentTimeMillis();
			
			
			try {
				InetAddress myHost = InetAddress.getLocalHost();
				Reporting.PrintLn(testParams, "The current hostname = " + myHost.getHostName()
						+ "; executionLocation = " + executionLocation);

				sURLLocation = DataManagement.GetData(testParams, testData, gIter, "URL");
				sURLLocation = (sURLLocation.equals("")) ? sURL : sURLLocation;
				
				Thread.sleep(1000);
				Global.LaunchBrowser(testParams, sURLLocation);
				Reporting.PrintLn(testParams, "Browser is launched");
				
int varPerformance = ExcelData.performanceCheckStatus(testParams.driver, "Madison", "Quote (seconds)", "//input[@id='j_username']",startTime);
				System.out.println(varPerformance);
			/*	iTestStatus += Login.login(testParams, "Login");
				Reporting.PrintLn(testParams, "Ending - Login.login() - status = " + iTestStatus);
				
				
				iTestStatus += Policy.createApplication(testParams, "createApplication");
				Reporting.PrintLn(testParams, "Ending - Policy.createApplication() - status = " + iTestStatus);
				
				iTestStatus += Policy.underWriter(testParams, "underwriter");
				Reporting.PrintLn(testParams, "Ending - Policy.underWriter() - status = " + iTestStatus);
				
				iTestStatus += Policy.autoGeneral(testParams, "underwriter");
				Reporting.PrintLn(testParams, "Ending - Policy.autoGeneral() - status = " + iTestStatus);
				
				iTestStatus += Vehicle.addVehicle(testParams, "vehicle");
				Reporting.PrintLn(testParams, "Ending - Vehicle.addVehicle() - status = " + iTestStatus);
				
				iTestStatus += Driver.addDriver(testParams, "addDriver");
				Reporting.PrintLn(testParams, "Ending - Driver.addDriver() - status = " + iTestStatus);
				
				iTestStatus += Vehicle.issuingInfo(testParams, "issue");
				Reporting.PrintLn(testParams, "Ending - Vehicle.issuingInfo() - status = " + iTestStatus);
				*/

			} catch (Exception e) {
				System.out.println(className + "::" + "There was some type of exception - " + e + "\r\nStackTrace = "
						+ ExceptionUtils.getStackTrace(e));
				Reporting.LogTestMessage(testParams, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), false);
				Global.CloseBrowser(testParams);
			} 
			
			finally {
				Reporting.PrintLn(testParams, "Closing the browser");
				Global.CloseBrowser(testParams);
				iterCount++;
			}
		}
		Thread.sleep(6000);
		Reporting.PrintLn(testParams, "Closing Reporting Log");
		Reporting.EndReportingLog(testParams);
		Reporting.PrintLn(testParams, "Quiting web driver");
		testParams.driver.quit();

	}
	
}
