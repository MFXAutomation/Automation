package funClass.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Vehicle_Pages {
	
	public static class VehiclePage {
		public static VehiclePage getVehiclePage(WebDriver driver) {
			return PageFactory.initElements(driver, VehiclePage.class);
		}

		@FindBy(xpath = "//a[@title='Add Vehicle']")
		public WebElement btnAddVeh;
		
		@FindBy(xpath = "//a[text()='Private Passenger Auto']")
		public WebElement btnPassAuto;
		
		@FindBy(xpath = "//input[@id='Vehicle.VehIdentificationNumber']")
		public WebElement txtVIN;
		
		@FindBy(xpath = "//select[@id='Vehicle.VehUseCd']")
		public WebElement ddVehUse;
		
		@FindBy(xpath = "//input[@id='Vehicle.OwnedBy']")
		public WebElement txtOwnedby;
		
		@FindBy(xpath = "//select[@id='Vehicle.StatedAmtInd']")
		public WebElement ddStatedAmt;
		
		@FindBy(xpath = "//select[@id='Vehicle.ComprehensiveDed']")
		public WebElement ddCompDed;
		
		@FindBy(xpath = "//select[@id='Vehicle.UMPDILLimit']")
		public WebElement ddUIM;
		
		@FindBy(xpath = "//select[@id='Vehicle.UMPDILDeductible']")
		public WebElement ddUMPD;
		
		@FindBy(xpath = "//select[@id='Vehicle.TowingAndLaborInd']")
		public WebElement ddTowLab;
		
		@FindBy(xpath = "//select[@id='Vehicle.CollisionDed']")
		public WebElement ddColDed;
		
		@FindBy(xpath = "//select[@id='Vehicle.RentalReimbursementInd']")
		public WebElement ddRentReim;
		
		@FindBy(xpath = "//input[@id='VehicleGarageAddr.Addr1']")
		public WebElement txtGarAdd1;
		
		@FindBy(xpath = "//input[@id='VehicleGarageAddr.City']")
		public WebElement txtGarCity;
		
		@FindBy(xpath = "//select[@id='VehicleGarageAddr.StateProvCd']")
		public WebElement ddGarState;
		
		@FindBy(xpath = "//input[@id='VehicleGarageAddr.PostalCode']")
		public WebElement txtGarZip;
		
		@FindBy(xpath = "//img[@id='VehicleGarageAddr.addrVerifyImg']")
		public WebElement btnVerifyAdd;
		
		@FindBy(xpath = "//select[@id='Question_VehicleExistingDamage']")
		public WebElement ddVehExtDmg;
		
		@FindBy(xpath = "//select[@id='Question_SoundReceivingTransmittingEquipment']")
		public WebElement ddTransEquip;
		
		@FindBy(xpath = "//select[@id='Question_CustomizedEquipment']")
		public WebElement ddCustEquip;
		
		@FindBy(xpath = "//select[@id='Question_OwnedByTwoInd']")
		public WebElement ddQuesOwnBy;
		
		@FindBy(xpath = "//select[@id='Question_SalvageTitle']")
		public WebElement ddQuesSalTitle;
		
		@FindBy(xpath = "//select[@id='Question_OwnedByBusiness']")
		public WebElement ddQuesOwnBus;
	}
	
	public static class IssuePolicyPage {
		public static IssuePolicyPage getIssuePolicyPage(WebDriver driver) {
			return PageFactory.initElements(driver, IssuePolicyPage.class);
		}

		@FindBy(xpath = "//span[text()='Finalize']")
		public WebElement btnFinalize;
		
		@FindBy(xpath = "//select[@id='TransactionInfo.PaymentTypeCd']")
		public WebElement ddPayType;
		
		@FindBy(xpath = "//input[@id='TransactionInfo.PaymentAmt']")
		public WebElement txtAmt;
		
		@FindBy(xpath = "//select[@id='PremiumSource.ACHStandardEntryClassCd']")
		public WebElement ddBankType1;
		
		@FindBy(xpath = "//select[@id='PremiumSource.ACHBankAccountTypeCd']")
		public WebElement ddBankType2;
		
		@FindBy(xpath = "//input[@id='PremiumSource.ACHBankName']")
		public WebElement txtBankName;
		
		@FindBy(xpath = "//input[@id='PremiumSource.ACHBankAccountNumber']")
		public WebElement txtAccNum;
		
		@FindBy(xpath = "//input[@id='PremiumSource.ACHRoutingNumber']")
		public WebElement txtRoutNum;
		
		@FindBy(xpath = "//span[normalize-space()='Issue New Business']")
		public WebElement btnIssue;
		
		//creditcard
		@FindBy(xpath = "//a[text()='Enter Credit Card Details']")
		public WebElement btnClickCredit;
		
		
		@FindBy(xpath = "//input[@id='cardNum']")
		public WebElement txtCCNum;
		
		@FindBy(xpath = "//input[@id='expiryDate']")
		public WebElement txtCCExpDate;
		
		@FindBy(xpath = "//input[@id='cvv']")
		public WebElement txtCCCode;
		
		@FindBy(xpath = "//input[@title='zip']")
		public WebElement txtZip;
		
		@FindBy(xpath = "//input[@title='address']")
		public WebElement txtAdd;
		
		@FindBy(xpath = "//input[@title='state']")
		public WebElement txtState;
		
		@FindBy(xpath = "//button[@id='saveButton']")
		public WebElement btnSave;
		
		@FindBy(xpath = "//div[@id='PolicySummary_PolicyNumber']")
		public WebElement policyNum;
		
		
	}
}
