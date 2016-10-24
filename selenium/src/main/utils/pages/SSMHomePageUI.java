package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSMHomePageUI extends TestRunner {
	public SSMHomePageUI() {
		PageFactory.initElements(driver, this);
	}

	Utils utils = new Utils();

// 	XPATHES declaration
	public final String SSM_USERS_MENU_ITEM_XP = "//table[@role='treeitem']/tbody/tr/td[text()='Users']";
	public String SSM_FOUND_TEST_USER_LINK_XP = "//div[@role='link'][text()='" + utils.TEST_USER_NAME + "']";
	
	public final String SSM_ALLUSERS_LINK_XP = "//div[contains(text(), 'All Users (')]";
	public final String SSM_INTERNALUSERS_LINK_XP = "//div[contains(text(), 'Internal Users (')]";
	public final String SSM_SEARCH_LINK_XP = "//div[text()='Search']";
	public final String SSM_USERNAME_INPUT_XP = "//input[@title='Username']";
	
	@FindBy(xpath = SSM_USERS_MENU_ITEM_XP)
	public WebElement ssmUsersMenuItem;
	
	@FindBy(xpath = SSM_ALLUSERS_LINK_XP)
	public WebElement ssmAllUsersLink;

	@FindBy(xpath = SSM_SEARCH_LINK_XP)
	public WebElement ssmSearchLink;

	@FindBy(xpath = SSM_USERNAME_INPUT_XP)
	public WebElement ssmUserNameInput;
}
