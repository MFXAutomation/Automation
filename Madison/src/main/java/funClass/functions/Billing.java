package funClass.functions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import funClass.objects.Billing_Pages;
import functions.DataManagement;
import functions.Global;
import functions.ObjectFunctions;
import functions.Reporting;
import parameters.pdParams;
import regressionTests.BaseTest;

public class Billing {

	public static int billProcess(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Billing.billProcess()";
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
		Billing_Pages.BillingProcessingPage bill = Billing_Pages.BillingProcessingPage
				.getBillingProcessingPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <= BaseTest.iterCount; iter++) {

//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
			try {
				Reporting.LogNodeMessage(Params, Status.INFO,
						"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
						false);

				Global.explicitWait(Params, bill.btnBilling, 30);

				Actions action = new Actions(Params.driver);
				action.moveToElement(bill.btnBilling).perform();

				// add your code here

				Global.explicitWait(Params, bill.btnBillProcess, 30);
				ObjectFunctions.Click(bill.btnBillProcess);

				Global.explicitWait(Params, bill.txtPolicy, 30);
				ObjectFunctions.SetText(Params, bill.txtPolicy,
						DataManagement.GetData(Params, testData, iter, "PolicyNumber"));

				Global.explicitWait(Params, bill.btnSearch, 30);
				ObjectFunctions.Click(bill.btnSearch);

				Global.explicitWait(Params, bill.linkPol, 30);
				ObjectFunctions.Click(bill.linkPol);

				retValue++;
			} catch (Exception e) {
				Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);

			}
		}

		return retValue;
	}

	public static int changePlan(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Billing.changePlan()";
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
		Billing_Pages.ChangePlanPage changePlan = Billing_Pages.ChangePlanPage.getChangePlanPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <= BaseTest.iterCount; iter++) {

//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
			try {
				Reporting.LogNodeMessage(Params, Status.INFO,
						"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
						false);

				Global.explicitWait(Params, changePlan.btnChangePlan, 30);
				ObjectFunctions.Click(changePlan.btnChangePlan);
				
				String payPlan=DataManagement.GetData(Params, testData, iter, "PayPlan");
				Params.driver.findElement(By.xpath("// th[text()='"+payPlan+"']//following::input[1]")).click();

				Global.explicitWait(Params, changePlan.btnProcess, 30);
				ObjectFunctions.Click(changePlan.btnProcess);
				
				retValue++;
			} catch (Exception e) {
				Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);

			}
		}

		return retValue;
	}
	
	public static int creditAdjust(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Billing.creditAdjust()";
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
		Billing_Pages.CrediChangePage credAdj = Billing_Pages.CrediChangePage.getCrediChangePage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <= BaseTest.iterCount; iter++) {

//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
			try {
				Reporting.LogNodeMessage(Params, Status.INFO,
						"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
						false);

				Global.explicitWait(Params, credAdj.btnCreditAdj, 30);
				ObjectFunctions.Click(credAdj.btnCreditAdj);
				
				Global.explicitWait(Params, credAdj.ddCredAdjType, 30);
				ObjectFunctions.SelectFromDropDown(Params, credAdj.ddCredAdjType,
						DataManagement.GetData(Params, testData, iter, "CreditAdjType"), true);
				
				Global.explicitWait(Params, credAdj.txtDesc, 30);
				ObjectFunctions.SetText(Params, credAdj.txtDesc,
						DataManagement.GetData(Params, testData, iter, "Description"));
				
				Global.explicitWait(Params, credAdj.txtAmt, 30);
				ObjectFunctions.SetText(Params, credAdj.txtAmt,
						DataManagement.GetData(Params, testData, iter, "Amount"));
				
				String checkNum=DataManagement.GetData(Params, testData, iter, "CheckNumber");
				if(checkNum.equals("")) {
					Random random=new Random();
					 int check=random.nextInt(100000);
					 ObjectFunctions.SetText(Params, credAdj.txtCheckNum,String.valueOf(check));
					
				}
				else
				{
					ObjectFunctions.SetText(Params, credAdj.txtCheckNum,
							DataManagement.GetData(Params, testData, iter, "CheckNumber"));
				}
				String date=DataManagement.GetData(Params, testData, iter, "CheckDate");
				if(date.equals("")) {
					Date today = new Date();
					date=new SimpleDateFormat("M/d/yyyy").format(today);
					System.out.println(date);
					ObjectFunctions.SetText(Params,credAdj.txtDate, date);
				}
				else {
					ObjectFunctions.SetText(Params, credAdj.txtDate,
							DataManagement.GetData(Params, testData, iter, "CheckDate"));
				}
				
				Global.explicitWait(Params, credAdj.btnSubmit, 30);
				ObjectFunctions.Click(credAdj.btnSubmit);

				retValue++;
			} catch (Exception e) {
				Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);

			}
		}

		return retValue;
	}
	
	public static int adjustment(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Billing.adjustment()";
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
		Billing_Pages.AdjustmentPage adj = Billing_Pages.AdjustmentPage.getAdjustmentPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <= BaseTest.iterCount; iter++) {

//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
			try {
				Reporting.LogNodeMessage(Params, Status.INFO,
						"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
						false);

				Global.explicitWait(Params, adj.btnAdjust, 30);
				ObjectFunctions.Click(adj.btnAdjust);
				
				Global.explicitWait(Params, adj.ddAdjCategory, 30);
				ObjectFunctions.SelectFromDropDown(Params, adj.ddAdjCategory,
						DataManagement.GetData(Params, testData, iter, "Category"), true);
				
				Global.explicitWait(Params, adj.ddType, 30);
				ObjectFunctions.SelectFromDropDown(Params, adj.ddType,
						DataManagement.GetData(Params, testData, iter, "Type"), true);
				
				Global.explicitWait(Params, adj.txtDesc, 30);
				ObjectFunctions.SetText(Params, adj.txtDesc,
						DataManagement.GetData(Params, testData, iter, "Description"));
				
				Global.explicitWait(Params, adj.txtAmt, 30);
				ObjectFunctions.SetText(Params, adj.txtAmt,
						DataManagement.GetData(Params, testData, iter, "Amount"));
				
				Global.explicitWait(Params, adj.btnAdj, 30);
				ObjectFunctions.Click(adj.btnAdj);
				
				
				retValue++;
			} catch (Exception e) {
				Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
						+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);

			}
		}

		return retValue;
	}
}
