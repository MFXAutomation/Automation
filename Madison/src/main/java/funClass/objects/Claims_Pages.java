package funClass.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Claims_Pages {
	
	public static class NewClaimPage {
		public static NewClaimPage getNewClaimPage(WebDriver driver) {
			return PageFactory.initElements(driver, NewClaimPage.class);
		}

		@FindBy(xpath = "//li[contains(text(),'Claims')]")
		public WebElement btnClaims;
		
		@FindBy(xpath = "//a[@id='Menu_Claims_LossNotice']")
		public WebElement btnLossNotice;
		
		@FindBy(xpath = "//input[@id='ClaimPolicyInfo.PolicyNumber']")
		public WebElement txtPolNum;
		
		@FindBy(xpath = "//a[@id='PolicyLookupIcon']")
		public WebElement btnSearch;
		
		@FindBy(xpath = "//a[@id='Continue']")
		public WebElement btnContinue;
		
		@FindBy(xpath = "//select[@id='ClaimLossTemplateIdRef']")
		public WebElement ddLossType2;
		
		@FindBy(xpath = "//input[@id='Claim.LossDt']")
		public WebElement txtLossDate;
		
		@FindBy(xpath = "//input[@id='Claim.LossTm']")
		public WebElement txtLossTime;
		
		@FindBy(xpath = "//a[@id='Save']")
		public WebElement btnSave;
		
		
		@FindBy(xpath = "//input[@id='Claim.ReportedBy']")
		public WebElement txtReportBy;
		
		@FindBy(xpath = "//a[@id='InsuredLocation']")
		public WebElement btnCopyInsLoc;
		
		@FindBy(xpath = "//select[@id='Claim.LossCauseCd']")
		public WebElement ddLossCause;
		
		@FindBy(xpath = "//input[@id='Claim.ShortDesc']")
		public WebElement txtShortDesc;
		
		@FindBy(xpath = "//select[@id='Claim.RiskIdRef']")
		public WebElement ddVehicle;
		
		@FindBy(xpath = "//select[@id='Claim.DriverIdRef']")
		public WebElement ddDriver;
		
		@FindBy(xpath = "//a[@id='Complete']")
		public WebElement btnComplete;
		
		@FindBy(xpath = "//a[@id='StartClaim']")
		public WebElement btnStartClaim;	
	}
	
	public static class ClaimInfoPage {
		public static ClaimInfoPage getClaimInfoPage(WebDriver driver) {
			return PageFactory.initElements(driver, ClaimInfoPage.class);
		}
		
		@FindBy(xpath = "//a[@title='Claim Information']")
		public WebElement btnClaimInfo;
		
		
		@FindBy(xpath = "//select[@id='Claim.BranchCd']")
		public WebElement ddBranch;
		
		@FindBy(xpath = "//input[@id='ExaminerProviderNumber']")
		public WebElement txtExaminer;
		
		@FindBy(xpath = "//select[@id='Claim.AtFaultCd']")
		public WebElement ddFault;
		
		@FindBy(xpath = "//*[text()='Finalize']")
		public WebElement btnFinalize;
		
		@FindBy(xpath = "//a[@id='Process']")
		public WebElement btnProcess;
		
		@FindBy(xpath = "//div[@id='ClaimSummary_ClaimNumber']")
		public WebElement claimNum;
	}
	
	
}
