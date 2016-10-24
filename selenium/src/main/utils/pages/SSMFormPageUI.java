package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSMFormPageUI extends TestRunner {
	public SSMFormPageUI() {
		PageFactory.initElements(driver, this);
	}
	
	Utils utils = new Utils();
	
	//	Constants declaration
	public final String SSM_FORM_TITLE = "User - " + utils.TEST_USER_NAME;

	//	Xpathes declaration
	public final String SSM_FORM_TAB_PREFERENCES_XP = "//div[@role='tab'][text()='Preferences']";
	public final String SSM_FORM_SAVE_BUTTON_DIV_XP = "//div[@title='Save'][@role='button']/table/tbody/tr";
	public String ssmUserFormTitleXP = "//div[text()='User - <username>'][@role='heading']";
	public String ssmFormCloseImgXP = ssmUserFormTitleXP + "/following-sibling::div[3]/img";
	public String  ssmFormSelect = "//span[text()='<label>:']/parent::div/parent::td/following-sibling::td/div/div/select";
	
	//	Element finders
	@FindBy(xpath = SSM_FORM_TAB_PREFERENCES_XP)
	public WebElement ssmFormTabPreferencesDiv;
	
	@FindBy(xpath = SSM_FORM_SAVE_BUTTON_DIV_XP)
	public WebElement ssmFormSaveButtonDiv;
}
