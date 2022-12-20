package funClass.functions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import funClass.objects.Claims_Pages;
import functions.DataManagement;
import functions.Global;
import functions.ObjectFunctions;
import functions.Reporting;
import parameters.pdParams;
import regressionTests.BaseTest;

public class Claims {

	public static int newClaim(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Claims.NewClaim()";
		Params.extNode = Reporting.CreateNode(Params, Params.sCurrClass);
		Reporting.PrintLn(Params, "Starting - " + Params.sCurrClass);
		int retValue = 0;

		List<HashMap<String, String>> testData;
		try {
			testData = DataManagement.LoadExcelData(Params.dataFilePath, sSheetName);
		} catch (Exception e) {
			Reporting.LogNodeMessage(Params, Status.FAIL, "There was an exception loading excel data - " + e
					+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), false);
			return 1;
		}

		// Insert calls to initialize object maps
		Claims_Pages.NewClaimPage claim = Claims_Pages.NewClaimPage.getNewClaimPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <= BaseTest.iterCount; iter++) {

//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
			try {
				Reporting.LogNodeMessage(Params, Status.INFO,
						"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
						false);

				Global.explicitWait(Params, claim.btnClaims, 30);

				Actions action = new Actions(Params.driver);
				action.moveToElement(claim.btnClaims).perform();

				// add your code here

				Global.explicitWait(Params, claim.btnLossNotice, 30);
				ObjectFunctions.Click(claim.btnLossNotice);

				Global.explicitWait(Params, claim.txtPolNum, 30);
				ObjectFunctions.SetText(Params, claim.txtPolNum,
						DataManagement.GetData(Params, testData, iter, "PolicyNumber"));

				Global.explicitWait(Params, claim.btnContinue, 30);
				ObjectFunctions.Click(claim.btnContinue);

				
				
				Global.explicitWait(Params, claim.ddLossType2, 30);
				ObjectFunctions.SelectFromDropDown(Params, claim.ddLossType2,
						DataManagement.GetData(Params, testData, iter, "LossType2"), true);
				
				String lossDate=DataManagement.GetData(Params, testData, iter, "LossDate");
				if(lossDate.equals("")) {
					LocalDate date = LocalDate.now().minusDays(1);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
					lossDate=formatter.format(date);
					System.out.println("date "+lossDate);
					ObjectFunctions.SetText(Params,claim.txtLossDate, lossDate);
				}
				else {
				Global.explicitWait(Params, claim.txtLossDate, 30);
				ObjectFunctions.SetText(Params,claim.txtLossDate, DataManagement.GetData(Params, testData, iter, "LossDate"));
				}
				
				ObjectFunctions.Click(claim.btnSave);
				ObjectFunctions.Click(claim.btnSave);
				
				Global.explicitWait(Params, claim.txtLossTime, 30);
				ObjectFunctions.SetText(Params,claim.txtLossTime, DataManagement.GetData(Params, testData, iter, "LossTime"));
				


				Global.explicitWait(Params, claim.txtReportBy, 30);
				ObjectFunctions.SetText(Params, claim.txtReportBy,
						DataManagement.GetData(Params, testData, iter, "ReportedBy"));

				Global.explicitWait(Params, claim.btnCopyInsLoc, 30);
				ObjectFunctions.Click(claim.btnCopyInsLoc);
				
				Global.explicitWait(Params, claim.txtShortDesc, 30);
				ObjectFunctions.SetText(Params, claim.txtShortDesc,
						DataManagement.GetData(Params, testData, iter, "ShortDescription"));

				
				
				Global.explicitWait(Params, claim.ddLossCause, 30);
				ObjectFunctions.SelectFromDropDown(Params, claim.ddLossCause,
						DataManagement.GetData(Params, testData, iter, "LossCause"), false);

				
				Global.explicitWait(Params, claim.ddVehicle, 30);
				ObjectFunctions.SelectFromDropDown(Params, claim.ddVehicle,
						DataManagement.GetData(Params, testData, iter, "Vehicle"), false);
				
				Global.explicitWait(Params, claim.ddDriver, 30);
				ObjectFunctions.SelectFromDropDown(Params, claim.ddDriver,
						DataManagement.GetData(Params, testData, iter, "Driver"), false);

				
				Global.explicitWait(Params, claim.btnSave, 30);
				ObjectFunctions.Click(claim.btnSave);

				Global.explicitWait(Params, claim.btnComplete, 50);
				ObjectFunctions.Click(claim.btnComplete);
				
				Global.explicitWait(Params, claim.btnStartClaim, 50);
				ObjectFunctions.Click(claim.btnStartClaim);

				
				retValue++;
			} catch (Exception e) {
				Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);

			}
		}

		return retValue;
	}
	
	public static int claimInfo(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Claims.claimInfo()";
		Params.extNode = Reporting.CreateNode(Params, Params.sCurrClass);
		Reporting.PrintLn(Params, "Starting - " + Params.sCurrClass);
		int retValue = 0;

		List<HashMap<String, String>> testData;
		try {
			testData = DataManagement.LoadExcelData(Params.dataFilePath, sSheetName);
		} catch (Exception e) {
			Reporting.LogNodeMessage(Params, Status.FAIL, "There was an exception loading excel data - " + e
					+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), false);
			return 1;
		}

		// Insert calls to initialize object maps
		Claims_Pages.ClaimInfoPage claimInfo = Claims_Pages.ClaimInfoPage.getClaimInfoPage(Params.driver);
		Claims_Pages.NewClaimPage claim = Claims_Pages.NewClaimPage.getNewClaimPage(Params.driver);
		for (int iter = BaseTest.iterCount; iter <= BaseTest.iterCount; iter++) {

//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
			try {
				Reporting.LogNodeMessage(Params, Status.INFO,
						"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
						false);

				Global.explicitWait(Params, claimInfo.btnClaimInfo, 30);
				ObjectFunctions.Click(claimInfo.btnClaimInfo);
				

				
				Global.explicitWait(Params, claimInfo.ddBranch, 30);
				ObjectFunctions.SelectFromDropDown(Params, claimInfo.ddBranch,
						DataManagement.GetData(Params, testData, iter, "Branch"), true);
				
//				String lossDate=DataManagement.GetData(Params, testData, iter, "LossDate");
				
				Global.explicitWait(Params, claimInfo.txtExaminer, 30);
				ObjectFunctions.SetText(Params,claimInfo.txtExaminer, DataManagement.GetData(Params, testData, iter, "Examiner"));
				
				
				
				Global.explicitWait(Params, claimInfo.ddFault, 30);
				ObjectFunctions.SelectFromDropDown(Params, claimInfo.ddFault,
						DataManagement.GetData(Params, testData, iter, "Fault"), false);

				
				
				Global.explicitWait(Params, claim.btnSave, 30);
				ObjectFunctions.Click(claim.btnSave);
				
				Global.explicitWait(Params, claimInfo.btnFinalize, 30);
				ObjectFunctions.Click(claimInfo.btnFinalize);
				
				Global.explicitWait(Params, claimInfo.btnProcess, 30);
				ObjectFunctions.Click(claimInfo.btnProcess);

				Global.explicitWait(Params, claimInfo.claimNum, 30);
				String claimNum=claimInfo.claimNum.getText();
				BaseTest.claim=claimNum;

				
				retValue++;
			} catch (Exception e) {
				Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);

			}
		}

		return retValue;
	}
}
