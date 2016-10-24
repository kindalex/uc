package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPageUI extends TestRunner{
	public FormPageUI() {
		PageFactory.initElements(driver, this);
	}
	
	Utils utils = new Utils();
	
	//	Constants declaration
	public final String FORM_SEARCH_BUTTON_TEXT = "Search";
	public final String FORM_OPEN_BUTTON_TEXT = "Open";
	public final String FORM_USER_NAME_INPUT_TEXT = "User name";

	public final String FORM_EVENT_TYPE_VSM_ACCOUNT_EXTERNALLY_UPDATED = "VSM_ACCOUNT_EXTERNALLY_UPDATED";

	//	Xpathes declaration
	public final String FORM_RESET_BUTTON_XP = "//button[text()='Reset']";
	public final String FORM_SEARCH_BUTTON_XP = "//button[text()='Search']";
	public final String FORM_OPEN_BUTTON_XP = "//button[text()='Open']";
	public final String FORM_TABLE_XP = "//table[@class='slm-grid body_content']";
	public final String FORM_TABLE_ALL_ROWS_XP = "//tr[@class='oddRow' or @class='evenRow']";
	public final String FORM_TABLE_ALL_COLUMNS_XP = "//th";
	public String FORM_TABLE_CELL_SUFFIX_XP = "[<row>]/td[<column>]/div";
	public String formFilterInputXP = "//label[text()='<FilterName>']/following-sibling::table/descendant::input[contains(@data-dojo-attach-point, 'textbox')]";
	public String formGridUserNameSpanXP = "//span[text()='" + utils.TEST_USER_NAME + "']";
	
	//	Element finders
	@FindBy(xpath = FORM_RESET_BUTTON_XP)
	public WebElement formResetButton;

	@FindBy(xpath = FORM_OPEN_BUTTON_XP)
	public WebElement formOpenButton;

	@FindBy(xpath = FORM_SEARCH_BUTTON_XP)
	public WebElement formSearchButton;

	@FindBy(xpath = FORM_TABLE_XP)
	public WebElement formTable;

	@FindBy(xpath = FORM_TABLE_ALL_ROWS_XP)
	public List<WebElement> formTableAllRows;

	@FindBy(xpath = FORM_TABLE_ALL_COLUMNS_XP)
	public List<WebElement> formTableAllColumns;
}
