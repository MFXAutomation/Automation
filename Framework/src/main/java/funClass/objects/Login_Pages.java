package funClass.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login_Pages {
	
	public static class LoginPage {
		public static LoginPage getLoginPage(WebDriver driver) {
			return PageFactory.initElements(driver, LoginPage.class);
		}

		@FindBy(xpath = "//input[@name='j_username']")
		public WebElement txtUserName;
		
		@FindBy(xpath = "//input[@name='j_password']")
		public WebElement txtPass;
		
		@FindBy(xpath = "//a[@name='SignIn']")
		public WebElement btnSignIn;
		
	}
	
}
