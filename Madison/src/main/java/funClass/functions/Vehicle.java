package funClass.functions;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.Status;

import funClass.objects.Login_Pages;
import funClass.objects.Policy_Pages;
import funClass.objects.Vehicle_Pages;
import functions.DataManagement;
import functions.Global;
import functions.ObjectFunctions;
import functions.Reporting;
import parameters.pdParams;
import regressionTests.BaseTest;


public class Vehicle {
	
	public static int addVehicle(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Vehicle.addVehicle()";
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
		Policy_Pages.CreateApplicationPage createApp = Policy_Pages.CreateApplicationPage.getCreateApplicationPage(Params.driver);
		Vehicle_Pages.VehiclePage veh = Vehicle_Pages.VehiclePage.getVehiclePage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <=BaseTest.iterCount; iter++) {
			
//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
				try {
					Reporting.LogNodeMessage(Params, Status.INFO,
							"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
							false);
					
					Global.explicitWait(Params, veh.btnAddVeh, 30);
					ObjectFunctions.Click(veh.btnAddVeh);
					
					String vehType=DataManagement.GetData(Params, testData, iter, "vechileType");
					Params.driver.findElement(By.xpath("//a[text()='"+vehType+"']")).click();
					
					Global.explicitWait(Params, veh.txtVIN, 30);
					ObjectFunctions.SetText(Params, veh.txtVIN, DataManagement.GetData(Params, testData, iter, "vinNum"));
					
					
					Global.explicitWait(Params, veh.ddVehUse, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddVehUse, DataManagement.GetData(Params, testData, iter, "vehUseCd"),true);
					
					Global.explicitWait(Params, veh.txtOwnedby, 30);
					ObjectFunctions.SetText(Params, veh.txtOwnedby, DataManagement.GetData(Params, testData, iter, "ownedby"));
					
					Global.explicitWait(Params, veh.ddStatedAmt, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddStatedAmt, DataManagement.GetData(Params, testData, iter, "statedAmtInd"),true);
					
					Global.explicitWait(Params, veh.ddCompDed, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddCompDed, DataManagement.GetData(Params, testData, iter, "comprehensiveDed"),true);
					
					Global.explicitWait(Params, veh.ddUIM, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddUIM,DataManagement.GetData(Params, testData, iter, "UIM"),true);
					
					Global.explicitWait(Params, veh.ddUMPD, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddUMPD, DataManagement.GetData(Params, testData, iter, "UMPD"),true);
					
					Global.explicitWait(Params, veh.ddTowLab, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddTowLab, DataManagement.GetData(Params, testData, iter, "towingAndLaborInd"),true);
					
					Global.explicitWait(Params, veh.ddColDed, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddColDed, DataManagement.GetData(Params, testData, iter, "collisionDed"),true);
					
					Global.explicitWait(Params, veh.ddRentReim, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddRentReim, DataManagement.GetData(Params, testData, iter, "rentalReimbursementInd"),true);
					
					//Address
					Global.explicitWait(Params, veh.txtGarAdd1, 30);
					ObjectFunctions.SetText(Params, veh.txtGarAdd1, DataManagement.GetData(Params, testData, iter, "gargAddress1"));
					
					Global.explicitWait(Params, veh.txtGarCity, 30);
					ObjectFunctions.SetText(Params, veh.txtGarCity	, DataManagement.GetData(Params, testData, iter, "gargCity"));
					
					Global.explicitWait(Params, veh.ddGarState, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddGarState, DataManagement.GetData(Params, testData, iter, "gargState"),true);
					
					Global.explicitWait(Params, veh.txtGarZip, 30);
					ObjectFunctions.SetText(Params, veh.txtGarZip	, DataManagement.GetData(Params, testData, iter, "gargZipcode"));
					
//					Global.explicitWait(Params, veh.btnVerifyAdd, 30);
//					ObjectFunctions.Click(veh.btnVerifyAdd);
					
					//Questions
					Global.explicitWait(Params, veh.ddVehExtDmg, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddVehExtDmg, DataManagement.GetData(Params, testData, iter, "vehExistingDamage"),true);
					
					Global.explicitWait(Params, veh.ddTransEquip, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddTransEquip, DataManagement.GetData(Params, testData, iter, "transEquipment"),true);
					
					Global.explicitWait(Params, veh.ddCustEquip, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddCustEquip, DataManagement.GetData(Params, testData, iter, "customizedEqu"),true);
					
					Global.explicitWait(Params, veh.ddQuesOwnBy, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddQuesOwnBy, DataManagement.GetData(Params, testData, iter, "ownedByTwoInd"),true);
					
					Global.explicitWait(Params, veh.ddQuesSalTitle, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddQuesSalTitle, DataManagement.GetData(Params, testData, iter, "salvageTitle"),true);
					
					Global.explicitWait(Params, veh.ddQuesOwnBus, 30);
					ObjectFunctions.SelectFromDropDown(Params, veh.ddQuesOwnBus, DataManagement.GetData(Params, testData, iter, "ownedByBusines"),true);
					
					Global.explicitWait(Params, createApp.btnSave, 30);
					ObjectFunctions.Click(createApp.btnSave);
					
					Reporting.LogNodeMessage(Params, Status.INFO, "Vehicle details added successfully", true);
					
					Global.explicitWait(Params, createApp.btnNextPage, 30);
					ObjectFunctions.Click(createApp.btnNextPage);
					
					retValue++;
				} catch (Exception e) {
					Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
							+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);
					
				}
			}
		

		return retValue;
	}
	
	
	public static int issuingInfo(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Vehicle.issuingInfo()";
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
		Policy_Pages.CreateApplicationPage createApp = Policy_Pages.CreateApplicationPage.getCreateApplicationPage(Params.driver);
		Vehicle_Pages.IssuePolicyPage issue = Vehicle_Pages.IssuePolicyPage.getIssuePolicyPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <=BaseTest.iterCount; iter++) {
			
//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
				try {
					Reporting.LogNodeMessage(Params, Status.INFO,
							"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
							false);


					// add your code here
				
					Global.explicitWait(pParams, createApp.btnNextPage, 30);
					ObjectFunctions.Click(createApp.btnNextPage);
					
					Global.explicitWait(pParams, createApp.btnNextPage, 30);
					ObjectFunctions.Click(createApp.btnNextPage);
					
					Thread.sleep(2000);
					String payPlan=DataManagement.GetData(Params, testData, iter, "payPlan");
					Params.driver.findElement(By.xpath("//*[text()='"+payPlan+"']//following-sibling::td//input")).click();
					
					Global.explicitWait(pParams, createApp.btnNextPage, 30);
					ObjectFunctions.Click(createApp.btnNextPage);
					
					Global.explicitWait(pParams, issue.btnFinalize, 30);
					ObjectFunctions.Click(issue.btnFinalize);
					
					String payType=DataManagement.GetData(Params, testData, iter, "payType");
					
					if(payType.equalsIgnoreCase("ACH")) {
						Global.explicitWait(pParams, issue.ddPayType, 30);
						ObjectFunctions.SelectFromDropDown(Params, issue.ddPayType, DataManagement.GetData(Params, testData, iter, "payType"), false);
				
						Global.explicitWait(Params, issue.txtAmt, 30);
						ObjectFunctions.SetText(Params,issue.txtAmt, DataManagement.GetData(Params, testData, iter, "amount"));
						
						Global.explicitWait(pParams, issue.ddBankType1, 30);
						ObjectFunctions.SelectFromDropDown(Params, issue.ddBankType1, DataManagement.GetData(Params, testData, iter, "ddBankType1"), false);
						
						Global.explicitWait(pParams, issue.ddBankType2, 30);
						ObjectFunctions.SelectFromDropDown(Params, issue.ddBankType2, DataManagement.GetData(Params, testData, iter, "ddBankType2"), false);
						
						Global.explicitWait(Params, issue.txtBankName, 30);
						ObjectFunctions.SetText(Params,issue.txtBankName, DataManagement.GetData(Params, testData, iter, "bankName"));
						
						Global.explicitWait(Params, issue.txtAccNum, 30);
						ObjectFunctions.SetText(Params,issue.txtAccNum, DataManagement.GetData(Params, testData, iter, "accountNum"));
						
						Global.explicitWait(Params, issue.txtRoutNum, 30);
						ObjectFunctions.SetText(Params,issue.txtRoutNum, DataManagement.GetData(Params, testData, iter, "routeNum"));
						
					}
					else if(payType.equalsIgnoreCase("Credit Card")) {
						
						Global.explicitWait(pParams, issue.ddPayType, 30);
						ObjectFunctions.SelectFromDropDown(Params, issue.ddPayType, DataManagement.GetData(Params, testData, iter, "payType"), false);
						
						Global.explicitWait(pParams, issue.btnClickCredit, 30);
						ObjectFunctions.Click(issue.btnClickCredit);
						
						Params.driver.switchTo().frame("iframeAuthorizeNet");
						Thread.sleep(2000);
						
						JavascriptExecutor js=(JavascriptExecutor)Params.driver;
						js.executeScript("arguments[0].click();", issue.txtCCNum);
						ObjectFunctions.SetText(Params,issue.txtCCNum, DataManagement.GetData(Params, testData, iter, "cardNo"));
						
						js.executeScript("arguments[0].click();", issue.txtCCExpDate);
//						ObjectFunctions.SetText(Params,issue.txtCCExpDate, DataManagement.GetData(Params, testData, iter, "expDate"));
//						ObjectFunctions.SetText(Params,issue.txtCCExpDate, DataManagement.GetData(Params, testData, iter, "month"));
						issue.txtCCExpDate.sendKeys(DataManagement.GetData(Params, testData, iter, "expDate"));
						issue.txtCCExpDate.sendKeys(DataManagement.GetData(Params, testData, iter, "month"));
						
						
						js.executeScript("arguments[0].click();", issue.txtCCCode);
						ObjectFunctions.SetText(Params,issue.txtCCCode, DataManagement.GetData(Params, testData, iter, "cardCode"));
						
						js.executeScript("arguments[0].click();", issue.txtZip);
						ObjectFunctions.SetText(Params,issue.txtZip, DataManagement.GetData(Params, testData, iter, "cardZipcode"));
						
						js.executeScript("arguments[0].click();", issue.txtAdd);
						ObjectFunctions.SetText(Params,issue.txtAdd, DataManagement.GetData(Params, testData, iter, "cardAddress"));
						
						js.executeScript("arguments[0].click();", issue.txtState);
						ObjectFunctions.SetText(Params,issue.txtState, DataManagement.GetData(Params, testData, iter, "cardState"));
						
						js.executeScript("arguments[0].click();", issue.btnSave);
//						ObjectFunctions.Click(issue.btnSave);
						
						Thread.sleep(2000);
						Params.driver.switchTo().defaultContent();
					}
					else {
						
					}
					
					Global.explicitWait(pParams, issue.btnIssue, 30);	
					ObjectFunctions.Click(issue.btnIssue);
					
					
					Global.explicitWait(pParams, issue.policyNum, 30);	
					String policy=issue.policyNum.getText();
					BaseTest.pol=policy;
					
					retValue++;
				} catch (Exception e) {
					Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
							+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);
					BaseTest.pol="";
					
				}
			}
		

		return retValue;
	}
}
