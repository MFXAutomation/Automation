package funClass.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Billing_Pages {

	public static class BillingProcessingPage {
		public static BillingProcessingPage getBillingProcessingPage(WebDriver driver) {
			return PageFactory.initElements(driver, BillingProcessingPage.class);
		}

		@FindBy(xpath = "//li[contains(text(),'Billing')]")
		public WebElement btnBilling;

		@FindBy(xpath = "//a[@id='Menu_Billing_ARSearch']")
		public WebElement btnBillProcess;

		@FindBy(xpath = "//input[@id='SearchInfo.Query']")
		public WebElement txtPolicy;

		@FindBy(xpath = "//a[@id='Search']")
		public WebElement btnSearch;

		@FindBy(xpath = "//*[@id='PolicyNumber_0']//a")
		public WebElement linkPol;

	}

	public static class ChangePlanPage {
		public static ChangePlanPage getChangePlanPage(WebDriver driver) {
			return PageFactory.initElements(driver, ChangePlanPage.class);
		}

		@FindBy(xpath = "//a[@id='ChangePayplan']")
		public WebElement btnChangePlan;

		// th[text()='Direct Bill 6 Payments']//following::input[1]

		@FindBy(xpath = "//a[@id='Process']")
		public WebElement btnProcess;

		@FindBy(xpath = "//a[@id='Return']")
		public WebElement btnReturn;
	}

	public static class CrediChangePage {
		public static CrediChangePage getCrediChangePage(WebDriver driver) {
			return PageFactory.initElements(driver, CrediChangePage.class);
		}

		@FindBy(xpath = "//a[@id='CreditAdjust']")
		public WebElement btnCreditAdj;

		@FindBy(xpath = "//select[@id='ARTrans.TypeCd']")
		public WebElement ddCredAdjType;
		
		@FindBy(xpath = "//input[@id='ARTrans.Desc']")
		public WebElement txtDesc;
		
		@FindBy(xpath = "//input[@id='ARTrans.RequestedAmt']")
		public WebElement txtAmt;
		
		@FindBy(xpath = "//input[@id='ARTrans.ARReceiptReference']")
		public WebElement txtCheckNum;
		
		@FindBy(xpath = "//input[@id='ARTrans.ARReceiptDt']")
		public WebElement txtDate;
		
		@FindBy(xpath = "//a[@id='Button']")
		public WebElement btnSubmit;

		@FindBy(xpath = "//a[@id='Return']")
		public WebElement btnReturn;
		
		
	}
	
	public static class AdjustmentPage {
		public static AdjustmentPage getAdjustmentPage(WebDriver driver) {
			return PageFactory.initElements(driver, AdjustmentPage.class);
		}

		@FindBy(xpath = "//a[@id='Adjustment']")
		public WebElement btnAdjust;

		// th[text()='Direct Bill 6 Payments']//following::input[1]

		@FindBy(xpath = "//select[@id='AdjustCategory']")
		public WebElement ddAdjCategory;

		@FindBy(xpath = "//select[@id='AdjustType']")
		public WebElement ddType;
		
		@FindBy(xpath = "//input[@id='Desc']")
		public WebElement txtDesc;
		
		@FindBy(xpath = "//input[@id='Amount']")
		public WebElement txtAmt;
		
		@FindBy(xpath = "//a[@id='Submit']")
		public WebElement btnAdj;
	}
}
