package funClass.functions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import funClass.objects.Policy_Pages;
import functions.DataManagement;
import functions.Global;
import functions.ObjectFunctions;
import functions.Reporting;
import parameters.pdParams;
import regressionTests.BaseTest;

public class Policy {
	
	public static int createApplication(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Policy.createApplication()";
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

		for (int iter = BaseTest.iterCount; iter <=BaseTest.iterCount; iter++) {
			
//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
				try {
					Reporting.LogNodeMessage(Params, Status.INFO,
							"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
							false);
					
					ObjectFunctions.Click(createApp.quote);
					
					Actions action=new Actions(Params.driver);
					action.moveToElement(createApp.quote).perform();

					// add your code here
					
					Global.explicitWait(Params, createApp.btnNewCust, 30);
					ObjectFunctions.Click(createApp.btnNewCust);
					
					Global.explicitWait(Params, createApp.clickNewQuote, 30);
					ObjectFunctions.Click(createApp.clickNewQuote);
					
					//****Enter effective date
					String effDate=DataManagement.GetData(Params, testData, iter, "EffectiveDate");
					if(effDate.equals("")) {
						Date today = new Date();
						effDate=new SimpleDateFormat("M/d/yyyy").format(today);
						System.out.println(effDate);
						ObjectFunctions.SetText(Params,createApp.txtEffDate, effDate);
					}
					else {
					Global.explicitWait(Params, createApp.txtEffDate, 30);
					ObjectFunctions.SetText(Params,createApp.txtEffDate, effDate);
					}
					
					Global.explicitWait(Params, createApp.ddState, 30);
					ObjectFunctions.SelectFromDropDown(Params, createApp.ddState, DataManagement.GetData(Params, testData, iter, "State"), false);
					
					Global.explicitWait(Params, createApp.btnContinue, 30);
					ObjectFunctions.Click(createApp.btnContinue);
					
					Global.explicitWait(Params, createApp.btnAuto, 30);
					ObjectFunctions.Click(createApp.btnAuto);
					
					Global.explicitWait(Params, createApp.ddTerm, 30);
//					ObjectFunctions.Click(createApp.ddTerm);
					ObjectFunctions.SelectFromDropDown(Params, createApp.ddTerm, DataManagement.GetData(Params, testData, iter, "Term"), true);
					
					Global.explicitWait(Params, createApp.txtProdCode, 30);
					ObjectFunctions.SetText(Params,createApp.txtProdCode, DataManagement.GetData(Params, testData, iter, "ProducerCode"));
					
					Select sel=new Select(createApp.ddBusSrc);
					sel.selectByVisibleText("Agency Transfer");
					
					Global.explicitWait(Params, createApp.ddBusSrc, 30);
//					ObjectFunctions.SelectFromDropDown(Params, createApp.ddBusSrc, DataManagement.GetData(Params, testData, iter, "BusinessSrc"), false);
					
					Global.explicitWait(Params, createApp.ddEntityType, 30);
					ObjectFunctions.SelectFromDropDown(Params, createApp.ddEntityType, DataManagement.GetData(Params, testData, iter, "EntityType"), false);
				
					Global.explicitWait(Params, createApp.ddMmicDisc, 30);
					ObjectFunctions.SelectFromDropDown(Params, createApp.ddMmicDisc, DataManagement.GetData(Params, testData, iter, "MmicDiscount"), false);
				
					Global.explicitWait(Params, createApp.txtFirstName, 30);
					ObjectFunctions.SetText(Params,createApp.txtFirstName, DataManagement.GetData(Params, testData, iter, "firstName"));
					
					Global.explicitWait(Params, createApp.txtLastName, 30);
					ObjectFunctions.SetText(Params,createApp.txtLastName, DataManagement.GetData(Params, testData, iter, "lastName"));
					
					Global.explicitWait(Params, createApp.txtDob, 30);
					ObjectFunctions.SetText(Params,createApp.txtDob, DataManagement.GetData(Params, testData, iter, "dob"));
					
					Global.explicitWait(Params, createApp.txtOcc, 30);
					ObjectFunctions.SetText(Params,createApp.txtOcc, DataManagement.GetData(Params, testData, iter, "occupation"));
					
					Global.explicitWait(Params, createApp.txtAddress1, 30);
					ObjectFunctions.SetText(Params,createApp.txtAddress1, DataManagement.GetData(Params, testData, iter, "address1"));
					
					Global.explicitWait(Params, createApp.txtAddress2, 30);
					ObjectFunctions.SetText(Params,createApp.txtAddress2, DataManagement.GetData(Params, testData, iter, "address2"));
					
					Global.explicitWait(Params, createApp.txtCity, 30);
					ObjectFunctions.SetText(Params,createApp.txtCity, DataManagement.GetData(Params, testData, iter, "city"));
					
					Global.explicitWait(Params, createApp.txtIndState, 30);
					ObjectFunctions.SelectFromDropDown(Params, createApp.txtIndState, DataManagement.GetData(Params, testData, iter, "ddInsState"), false);
				
					Global.explicitWait(Params, createApp.txtZipCode, 30);
					ObjectFunctions.SetText(Params, createApp.txtZipCode, DataManagement.GetData(Params, testData, iter, "zipcode"));
				
					Global.explicitWait(Params, createApp.btnVerifyAdd, 30);
					ObjectFunctions.Click(createApp.btnVerifyAdd);
					
					Global.explicitWait(Params, createApp.ddPhoneType, 30);
					ObjectFunctions.SelectFromDropDown(Params, createApp.ddPhoneType, DataManagement.GetData(Params, testData, iter, "ddPhoneType"), false);

					Global.explicitWait(Params, createApp.txtPhoneNum, 30);
					ObjectFunctions.SetText(Params,createApp.txtPhoneNum, DataManagement.GetData(Params, testData, iter, "phoneNumber"));

					Global.explicitWait(Params, createApp.txtEmail, 30);
					ObjectFunctions.SetText(Params,createApp.txtEmail, DataManagement.GetData(Params, testData, iter, "emailId"));

					Global.explicitWait(Params, createApp.ddovrPFL, 30);
					ObjectFunctions.SelectFromDropDown(Params, createApp.ddovrPFL, DataManagement.GetData(Params, testData, iter, "ovrPFL"), false);

					Global.explicitWait(Params, createApp.btnSave, 30);
					ObjectFunctions.Click(createApp.btnSave);
					
					Global.explicitWait(Params, createApp.btnCreateApp, 50);
					ObjectFunctions.Click(createApp.btnCreateApp);
					
					Global.explicitWait(Params, createApp.ddPrevCarr, 30);
					ObjectFunctions.SelectFromDropDown(Params, createApp.ddPrevCarr, DataManagement.GetData(Params, testData, iter, "ddPrevCarrier"), false);
					
					Global.explicitWait(Params, createApp.btnSave, 30);
					ObjectFunctions.Click(createApp.btnSave);
					
					Reporting.LogNodeMessage(Params, Status.INFO, "Application created successfully", true);
					
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
	
	
	public static int underWriter(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Policy.underWriter()";
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
		Policy_Pages.UnderWriterPage underWriter = Policy_Pages.UnderWriterPage.getUnderWriterPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <=BaseTest.iterCount; iter++) {
			
//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
				try {
					Reporting.LogNodeMessage(Params, Status.INFO,
							"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
							false);
					
					
					
					Global.explicitWait(Params, underWriter.questDriverInsured, 30);
					ObjectFunctions.SelectFromDropDown(Params, underWriter.questDriverInsured, DataManagement.GetData(Params, testData, iter, "questDriverInsured"), false);
					
					Global.explicitWait(Params, underWriter.txtquestHousehold, 30);
					ObjectFunctions.SetText(Params, underWriter.txtquestHousehold, DataManagement.GetData(Params, testData, iter, "questHousehold"));
					
					Global.explicitWait(Params, underWriter.txtquestNoofAutos, 30);
					ObjectFunctions.SetText(Params,underWriter.txtquestNoofAutos, DataManagement.GetData(Params, testData, iter, "questNoofAutos"));
					
					Global.explicitWait(Params, underWriter.questLicenseSuspend, 30);
					ObjectFunctions.SelectFromDropDown(Params,underWriter.questLicenseSuspend, DataManagement.GetData(Params, testData, iter, "questLicenseSuspend"),true);
					
					Global.explicitWait(Params, underWriter.questConvictedViolation, 30);
					ObjectFunctions.SelectFromDropDown(Params, underWriter.questConvictedViolation, DataManagement.GetData(Params, testData, iter, "questConvictedViolation"), false);
				
					Global.explicitWait(Params, underWriter.questConvictedofFelony, 30);
					ObjectFunctions.SelectFromDropDown(Params, underWriter.questConvictedofFelony, DataManagement.GetData(Params, testData, iter, "questConvictedofFelony"), false);
				
					Global.explicitWait(Params, underWriter.questViolationHistory, 30);
					ObjectFunctions.SelectFromDropDown(Params,underWriter.questViolationHistory, DataManagement.GetData(Params, testData, iter, "questViolationHistory"),false);
					
					Global.explicitWait(Params, underWriter.questClaimsHistory, 30);
					ObjectFunctions.SelectFromDropDown(Params,underWriter.questClaimsHistory, DataManagement.GetData(Params, testData, iter, "questClaimsHistory"),false);
					
					Global.explicitWait(Params, underWriter.questfamilyAutoIns, 30);
					ObjectFunctions.SelectFromDropDown(Params,underWriter.questfamilyAutoIns, DataManagement.GetData(Params, testData, iter, "questfamilyAutoIns"),false);
					
					
					Global.explicitWait(Params, underWriter.questRideShareDel, 30);
					ObjectFunctions.SelectFromDropDown(Params,underWriter.questRideShareDel, DataManagement.GetData(Params, testData, iter, "questRideShareDel"),false);
					
					Global.explicitWait(Params, createApp.btnSave, 30);
					ObjectFunctions.Click(createApp.btnSave);
					
					Reporting.LogNodeMessage(Params, Status.INFO, "underWriter details filled", true);
					
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
	
	public static int autoGeneral(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Policy.underWriter()";
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
		Policy_Pages.AutoGeneralPage autoGen = Policy_Pages.AutoGeneralPage.getAutoGeneralPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <=BaseTest.iterCount; iter++) {
			
//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
				try {
					Reporting.LogNodeMessage(Params, Status.INFO,
							"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
							false);
					
					
					
					Global.explicitWait(Params, autoGen.ddStorage, 30);
					ObjectFunctions.SelectFromDropDown(Params, autoGen.ddStorage, DataManagement.GetData(Params, testData, iter, "storageOnlyInd"), false);
					
					Global.explicitWait(Params, autoGen.ddBILim, 30);
					ObjectFunctions.SelectFromDropDown(Params, autoGen.ddBILim, DataManagement.GetData(Params, testData, iter, "bILimit"),false);
					
					Global.explicitWait(Params, autoGen.ddPDLim, 30);
					ObjectFunctions.SelectFromDropDown(Params,autoGen.ddPDLim, DataManagement.GetData(Params, testData, iter, "pDLimit"),false);
					
					Global.explicitWait(Params, autoGen.ddMedPay, 30);
					ObjectFunctions.SelectFromDropDown(Params,autoGen.ddMedPay, DataManagement.GetData(Params, testData, iter, "medPayLimit"),true);
					
					Global.explicitWait(Params, autoGen.ddHomeDis, 30);
					ObjectFunctions.SelectFromDropDown(Params, autoGen.ddHomeDis, DataManagement.GetData(Params, testData, iter, "multiPolicyDiscountInd"), false);
				
					
					Global.explicitWait(Params, autoGen.txtRelPolNum, 30);
					ObjectFunctions.SetText(Params,autoGen.txtRelPolNum, DataManagement.GetData(Params, testData, iter, "clickRelPolicyNum"));
					
					Global.explicitWait(Params, createApp.btnSave, 30);
					ObjectFunctions.Click(createApp.btnSave);
					
					Reporting.LogNodeMessage(Params, Status.INFO, "Autogeneral details filled", true);
					
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
}
