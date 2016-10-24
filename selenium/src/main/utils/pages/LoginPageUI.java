package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUI extends TestRunner {
	public LoginPageUI() {
		PageFactory.initElements(driver, this);
	}

	protected String url = "https://slmlqa12.boeblingen.de.ibm.com/emptoris/";
	
	@FindBy(xpath="//input[@id='username']")
	protected WebElement userNameInput;

	@FindBy(xpath="//input[@id='password']")
	protected WebElement passwordInput;
	
	@FindBy(xpath="//button[@id='loginButton']")
	protected WebElement loginButton;
}