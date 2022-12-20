package regressionTests;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import funClass.functions.Claims;
import funClass.functions.Driver;
import funClass.functions.Login;
import funClass.functions.Policy;
import funClass.functions.Vehicle;
import functions.DataManagement;
import functions.Global;
import functions.Reporting;
import parameters.pdParams;

public class Claim extends BaseTest {

	private static String iterationCount;

	pdParams testParams = new pdParams();
	pdParams testParams2 = new pdParams();
	
	@Parameters({ "executionLocation", "url", "EnvironmentCode" })
	@Test(groups = { "Regression", "Claim", "AL" })
	public void createClaim(@Optional("local") String executionLocation,
			@Optional("") String sURL,
			@Optional("QA") String sEnvironmentCode) throws InterruptedException {

		pdParams testParams = new pdParams();

		testParams.sTestName = testcase;
//		transType=testParams.sTestName;
		testParams.sCurrClass = "AL";
		
				testParams.dataFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\TestDataClaims.xlsx";
		String className = "Claim";

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

			try {
				InetAddress myHost = InetAddress.getLocalHost();
				Reporting.PrintLn(testParams, "The current hostname = " + myHost.getHostName()
						+ "; executionLocation = " + executionLocation);

				sURLLocation = DataManagement.GetData(testParams, testData, gIter, "URL");
				sURLLocation = (sURLLocation.equals("")) ? sURL : sURLLocation;
				
				Thread.sleep(1000);
				Global.LaunchBrowser(testParams, sURLLocation);
				Reporting.PrintLn(testParams, "Browser is launched");
				

				iTestStatus += Login.login(testParams, "Login");
				Reporting.PrintLn(testParams, "Ending - Login.login() - status = " + iTestStatus);
				
				
				iTestStatus += Claims.newClaim(testParams, "NewClaim");
				Reporting.PrintLn(testParams, "Ending - Claims.newClaim() - status = " + iTestStatus);
				
				iTestStatus += Claims.claimInfo(testParams, "ClaimInfo");
				Reporting.PrintLn(testParams, "Ending - Claims.claimInfo() - status = " + iTestStatus);
				
				

			} catch (Exception e) {
				System.out.println(className + "::" + "There was some type of exception - " + e + "\r\nStackTrace = "
						+ ExceptionUtils.getStackTrace(e));
				Reporting.LogTestMessage(testParams, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), false);
				Global.CloseBrowser(testParams);
			} finally {
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