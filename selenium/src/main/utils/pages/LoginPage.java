package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class LoginPage extends TestRunner {
	
//	protected String url = "https://slmwqa04.boeblingen.de.ibm.com/srm-app/web/";
	protected String url = "https://slmlqa12.boeblingen.de.ibm.com/emptoris/";
	
	@FindBy(xpath="//input[@id='username']")
	protected WebElement userNameInput;

	@FindBy(xpath="//input[@id='password']")
	protected WebElement passwordInput;
	
	@FindBy(xpath="//button[@id='loginButton']")
	protected WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		driver.get(url);
	}
	
	public void setUserName(String strUserName){
		userNameInput.clear();
		userNameInput.sendKeys(strUserName);
	}	
	public void setPassword(String strPassword){
		passwordInput.clear();
		passwordInput.sendKeys(strPassword);
	}
	public void clickLogin(){
		loginButton.click();
	}
}
