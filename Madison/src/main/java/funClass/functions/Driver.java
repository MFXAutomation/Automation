package funClass.functions;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import funClass.objects.Driver_Pages;
import funClass.objects.Policy_Pages;
import funClass.objects.Vehicle_Pages;
import functions.DataManagement;
import functions.Global;
import functions.ObjectFunctions;
import functions.Reporting;
import parameters.pdParams;
import regressionTests.BaseTest;

public class Driver {
	
	public static int addDriver(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Driver.addDriver()";
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
		Driver_Pages.DriverPage driver = Driver_Pages.DriverPage.getDriverPage(Params.driver);

		for (int iter = BaseTest.iterCount; iter <=BaseTest.iterCount; iter++) {
			
//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
				try {
					Reporting.LogNodeMessage(Params, Status.INFO,
							"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
							false);
					
					Global.explicitWait(Params, driver.btnAddDriver, 30);
					ObjectFunctions.Click(driver.btnAddDriver);
					
					String driverType=DataManagement.GetData(Params, testData, iter, "ddDriverType");	
					Params.driver.findElement(By.xpath("//*[text()='Select Driver Type']//following::a[text()='"+driverType+"']")).click();
					
					Global.explicitWait(Params, driver.txtFirstName, 30);
					ObjectFunctions.SetText(Params, driver.txtFirstName, DataManagement.GetData(Params, testData, iter, "driverFname"));
					
					
					Global.explicitWait(Params, driver.txtLastName, 30);
					ObjectFunctions.SetText(Params, driver.txtLastName, DataManagement.GetData(Params, testData, iter, "driverLname"));
					
					Global.explicitWait(Params, driver.ddRelInsured, 30);
					ObjectFunctions.SelectFromDropDown(Params, driver.ddRelInsured, DataManagement.GetData(Params, testData, iter, "relIns"),true);
					
					Global.explicitWait(Params, driver.ddMaritalStatus, 30);
					ObjectFunctions.SelectFromDropDown(Params, driver.ddMaritalStatus, DataManagement.GetData(Params, testData, iter, "marriedstatus"),true);
					
//					Global.explicitWait(Params, driver.txtDob, 30);
//					ObjectFunctions.SetText(Params, driver.txtDob, DataManagement.GetData(Params, testData, iter, "driverLname"));
					
					
					Global.explicitWait(Params, driver.ddMaritalStatus, 30);
					ObjectFunctions.SelectFromDropDown(Params, driver.ddMaritalStatus, DataManagement.GetData(Params, testData, iter, "marriedstatus"),true);
					
					Global.explicitWait(Params, driver.ddGender, 30);
					ObjectFunctions.SelectFromDropDown(Params, driver.ddGender, DataManagement.GetData(Params, testData, iter, "ddGender"),true);
					
					Global.explicitWait(Params, driver.ddOpertStatus, 30);
					ObjectFunctions.SelectFromDropDown(Params, driver.ddOpertStatus, DataManagement.GetData(Params, testData, iter, "ddOptStatus"),true);
					
					
					Global.explicitWait(Params, driver.txtOccu, 30);
					ObjectFunctions.SetText(Params, driver.txtOccu, DataManagement.GetData(Params, testData, iter, "driverOccupation"));
					
					List<WebElement> driverinfo = Params.driver.findElements(By.xpath("//select[@id='DriverInfo.AccidentPreventionCourseInd']"));
					if(driverinfo.size()>0) {
						 String defenseDiver = DataManagement.GetData(Params, testData, iter, "defenseDiver");
						 Global.explicitWait(Params, driver.ddDefenceDriver, 30);
							ObjectFunctions.SelectFromDropDown(Params, driver.ddDefenceDriver,defenseDiver,true);
					}
					
					Global.explicitWait(Params, driver.txtLicenseNum, 30);
					ObjectFunctions.SetText(Params, driver.txtLicenseNum	, DataManagement.GetData(Params, testData, iter, "licenseNum"));
					
					Global.explicitWait(Params, driver.ddQuesEdorse, 30);
					ObjectFunctions.SelectFromDropDown(Params, driver.ddQuesEdorse, DataManagement.GetData(Params, testData, iter, "quesEdorse"),true);
					
					
					
					List<WebElement> list=Params.driver.findElements(By.xpath("//select[@id='DriverInfo.ScholasticDiscountInd']"));
					if(list.size()>0) {
						System.out.println("size "+list.size());
						Global.explicitWait(Params, driver.ddStudDis, 30);
						ObjectFunctions.SelectFromDropDown(Params, driver.ddStudDis, DataManagement.GetData(Params, testData, iter, "studentDiscount"),true);
						
					}
					
					Global.explicitWait(Params, createApp.btnSave, 30);
					ObjectFunctions.Click(createApp.btnSave);
					
					Reporting.LogNodeMessage(Params, Status.INFO, "Driver details added successfully", true);
					
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
