package funClass.functions;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import funClass.objects.Login_Pages;
import functions.DataManagement;
import functions.Global;
import functions.ObjectFunctions;
import functions.Reporting;
import parameters.pdParams;
import regressionTests.BaseTest;


public class Login {
	
	public static int login(pdParams pParams, String sSheetName) {
		pdParams Params = new pdParams(pParams);
		Params.sCurrClass = pParams.sCurrClass + ".Login.login()";
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
		Login_Pages.LoginPage login = Login_Pages.LoginPage.getLoginPage(Params.driver);
		
//		int iteration= Integer.parseInt(Params.runActionControl);
		for (int iter = BaseTest.iterCount; iter <=BaseTest.iterCount; iter++) {
			
//			if (DataManagement.DetermineIterationControl(Params.runActionControl,
//					DataManagement.GetData(Params, testData, iter, "IterationControl"))) {
				try {
					Reporting.LogNodeMessage(Params, Status.INFO,
							"Running Iteration - " + DataManagement.GetData(Params, testData, iter, "IterationControl"),
							false);


					// add your code here
					
					
					Global.explicitWait(pParams, login.txtUserName, 30);
					ObjectFunctions.SetText(login.txtUserName,
							DataManagement.GetData(Params, testData, iter, "Username"));
					Global.explicitWait(pParams, login.txtPass, 30);
					ObjectFunctions.SetText(login.txtPass,
							DataManagement.GetData(Params, testData, iter, "Password"));
					Global.explicitWait(pParams, login.btnSignIn, 30);
					
					ObjectFunctions.Click(login.btnSignIn);
					
					System.out.println(DataManagement.GetData(Params, testData, iter, "Data"));
					
					
					retValue++;
				} catch (Exception e) {
					Reporting.LogNodeMessage(Params, Status.FAIL, "There was some type of exception - " + e
							+ "\r\nStackTrace = " + ExceptionUtils.getStackTrace(e), true);
					
				}
			}
//		}

		return retValue;
	}
	
}
