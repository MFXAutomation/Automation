package funClass.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Policy_Pages {
	
	public static class CreateApplicationPage {
		public static CreateApplicationPage getCreateApplicationPage(WebDriver driver) {
			return PageFactory.initElements(driver, CreateApplicationPage.class);
		}
		
		@FindBy(xpath = "//li[contains(text(),'Quote')]")
		public WebElement quote;
		
		@FindBy(xpath = "//a[@id='Menu_Policy_NewCustomerAndQuote']")
		public WebElement btnNewCust;

		@FindBy(xpath = "//span[text()='New Quote']")
		public WebElement clickNewQuote;
		
		@FindBy(xpath = "//input[@id='BasicPolicy.EffectiveDt']")
		public WebElement txtEffDate;
		
		@FindBy(xpath = "//select[@id='BasicPolicy.ControllingStateCd']")
		public WebElement ddState;
		
		@FindBy(xpath = "//a[@id='Continue']")
		public WebElement btnContinue;
		
		@FindBy(xpath = "//a[text()='Personal Auto']")
		public WebElement btnAuto;
		
		@FindBy(xpath = "//select[@id='BasicPolicy.RenewalTermCd']")
		public WebElement ddTerm;
		
		@FindBy(xpath = "//input[@id='ProviderNumber']")
		public WebElement txtProdCode;
		
		@FindBy(xpath = "//select[@id='BasicPolicy.BusinessSourceCd']")
		public WebElement ddBusSrc;
		
		@FindBy(xpath = "//select[@id='Insured.EntityTypeCd']")
		public WebElement ddEntityType;
		
		@FindBy(xpath = "//select[@id='Insured.EmpRetBrd']")
		public WebElement ddMmicDisc;
		
		@FindBy(xpath = "//input[@id='InsuredName.GivenName']")
		public WebElement txtFirstName;
		
		@FindBy(xpath = "//input[@id='InsuredName.Surname']")
		public WebElement txtLastName;
		
		@FindBy(xpath = "//input[@id='InsuredPersonal.BirthDt']")
		public WebElement txtDob;
		
		@FindBy(xpath = "//input[@id='InsuredPersonal.PositionTitle']")
		public WebElement txtOcc;
		
		@FindBy(xpath = "//input[@id='InsuredMailingAddr.Addr1']")
		public WebElement txtAddress1;
		
		@FindBy(xpath = "//input[@id='InsuredMailingAddr.Addr2']")
		public WebElement txtAddress2;
		
		@FindBy(xpath = "//input[@id='InsuredMailingAddr.City']")
		public WebElement txtCity;
		
		@FindBy(xpath = "//select[@id='InsuredMailingAddr.StateProvCd']")
		public WebElement txtIndState;
		
		@FindBy(xpath = "//input[@id='InsuredMailingAddr.PostalCode']")
		public WebElement txtZipCode;
		
		@FindBy(xpath = "//i[@id='InsuredMailingAddr.addrVerifyImg']")
		public WebElement btnVerifyAdd;
		
		@FindBy(xpath = "//select[@id='InsuredPhonePrimary.PhoneName']")
		public WebElement ddPhoneType;
		
		@FindBy(xpath = "//input[@id='InsuredPhonePrimary.PhoneNumber']")
		public WebElement txtPhoneNum;
		
		@FindBy(xpath = "//input[contains(@title,'Email')]")
		public WebElement txtEmail;
		
		@FindBy(xpath = "//select[@id='InsuredInsuranceScore.OverriddenPersonalFinanceLevel']")
		public WebElement ddovrPFL;
		
		@FindBy(xpath = "//span[text()='Save']")
		public WebElement btnSave;
		
		@FindBy(xpath = "//*[text()='Create Application']")
		public WebElement btnCreateApp;
		
		@FindBy(xpath = "//select[@id='BasicPolicy.PreviousCarrierCd']")
		public WebElement ddPrevCarr;
		
		@FindBy(xpath = "//span[text()='Next Page']")
		public WebElement btnNextPage;
	}
	
	public static class UnderWriterPage {
		public static UnderWriterPage getUnderWriterPage(WebDriver driver) {
			return PageFactory.initElements(driver, UnderWriterPage.class);
		}
		
		@FindBy(xpath = "//select[@name='Question_DriverInsured']")
		public WebElement questDriverInsured;
		
		@FindBy(xpath = "//input[@name='Question_Over14InHousehold']")
		public WebElement txtquestHousehold;
		
		@FindBy(xpath = "//input[@name='Question_NumberofAutos']")
		public WebElement txtquestNoofAutos;
		
		@FindBy(xpath = "//select[@name='Question_LicenseSuspended']")
		public WebElement questLicenseSuspend;
		
		@FindBy(xpath = "//select[@name='Question_DriverConvictedForViolation']")
		public WebElement questConvictedViolation;
		
		@FindBy(xpath = "//select[@name='Question_DriverConvictedofFelony']")
		public WebElement questConvictedofFelony;
		
		@FindBy(xpath = "//select[@name='Question_DriverViolationHistory']")
		public WebElement questViolationHistory;
		
		@FindBy(xpath = "//select[@name='Question_DriverClaimsHistory']")
		public WebElement questClaimsHistory;

		@FindBy(xpath = "//select[@name='Question_OtherFamilyAutoInsurance']")
		public WebElement questfamilyAutoIns;
		
		@FindBy(xpath = "//select[@name='Question_RideShareDeliveryUse']")
		public WebElement questRideShareDel;
		
	}


	public static class AutoGeneralPage {
		public static AutoGeneralPage getAutoGeneralPage(WebDriver driver) {
			return PageFactory.initElements(driver, AutoGeneralPage.class);
		}
		
		@FindBy(xpath = "//select[@id='Line.StorageOnlyInd']")
		public WebElement ddStorage;
		
		@FindBy(xpath = "//select[@id='Line.BILimit']")
		public WebElement ddBILim;
		
		@FindBy(xpath = "//select[@id='Line.PDLimit']")
		public WebElement ddPDLim;

		@FindBy(xpath = "//select[@id='Line.MedPayLimit']")
		public WebElement ddMedPay;
		
		@FindBy(xpath = "//select[@id='Line.MultiPolicyDiscountInd']")
		public WebElement ddHomeDis;
		
		@FindBy(xpath = "//input[@id='Line.RelatedPolicyNumber']")
		public WebElement txtRelPolNum;
	}
		
}
