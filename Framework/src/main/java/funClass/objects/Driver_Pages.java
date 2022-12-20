package funClass.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Driver_Pages {
	
	public static class DriverPage {
		public static DriverPage getDriverPage(WebDriver driver) {
			return PageFactory.initElements(driver, DriverPage.class);
		}

		@FindBy(xpath = "//a[@title='Add Driver']")
		public WebElement btnAddDriver;
		
		@FindBy(xpath = "//input[@id='NameInfo.GivenName']")
		public WebElement txtFirstName;
		
		@FindBy(xpath = "//input[@id='NameInfo.Surname']")
		public WebElement txtLastName;
		
		@FindBy(xpath = "//select[@id='DriverInfo.RelationshipToInsuredCd']")
		public WebElement ddRelInsured;
		
		@FindBy(xpath = "//select[@id='PersonInfo.MaritalStatusCd']")
		public WebElement ddMaritalStatus;
		
		@FindBy(xpath = "//input[@id='PersonInfo.BirthDt']")
		public WebElement txtDob;
		
		@FindBy(xpath = "//select[@id='PersonInfo.GenderCd']")
		public WebElement ddGender;
		
		@FindBy(xpath = "//select[@id='DriverInfo.DriverStatusCd']")
		public WebElement ddOpertStatus;
		
		@FindBy(xpath = "//input[@id='PersonInfo.OccupationClassCd']")
		public WebElement txtOccu;
		
		@FindBy(xpath = "//input[@id='DriverInfo.LicenseNumber']")
		public WebElement txtLicenseNum;
		
		@FindBy(xpath = "//select[@id='DriverInfo.AccidentPreventionCourseInd']")
		public WebElement ddDefenceDriver;
		
		@FindBy(xpath = "//select[@id='Question_DriveOtherCar']")
		public WebElement ddQuesEdorse;
		
		@FindBy(xpath = "//select[@id='DriverInfo.ScholasticDiscountInd']")
		public WebElement ddStudDis;	
	}
}
