package pages;

import org.openqa.selenium.support.PageFactory;

public class ViewPageUI extends TestRunner {
	public ViewPageUI() {
		PageFactory.initElements(driver, this);
	}
	
	Utils utils = new Utils();
	
	//	Constants declaration
	// Boxes
	public final String VIEW_BOX_CLASS_EXPANDED = "box-collapse collapse in"; 
	public final String VIEW_BOX_CLASS_COLLAPSED = "box-collapse collapse"; 
	public final String VIEW_BOX_HEADER_XP_EXTENSION =  "/following-sibling::div";
	public final String VIEW_BOX_CONTAINER_A_XP_EXTENSION = "/ancestor::div[@class='es-ui-box']/div/a";
	public final String VIEW_BOX_HEADER_MASTER_DATA = "Master Data";
	public final String VIEW_BOX_HEADER_USER_PREFERENCES = "User Preferences";
	public final String VIEW_BOX_HEADER_LANGUAGE_SETTINGS = "Language Settings";

	// Box fields
	public final String VIEW_BOX_FIELD_LANGUAGE_FOR_USER_INTERFACE = "Language for user interface";
	public final String VIEW_BOX_FIELD_TIME_ZONE = "Timezone";
	public final String VIEW_BOX_FIELD_DATE_FORMAT = "Date format";
	public final String VIEW_BOX_FIELD_NUMBER_FORMAT = "Number format";
	
	//	Xpathes declaration
	public String viewTitleH1XP = "//h1[contains(text(), '"+ utils.TEST_USER_NAME + "')]";
	public String viewBoxHeaderXP = "//a[text()='<HeaderName> '][@data-dojo-attach-point='captionNode']//parent::div[@data-dojo-attach-point='header']";	

	public String viewBoxItemXP = viewBoxHeaderXP + "/following-sibling::div//label[text()='<FieldName>']/following-sibling::div/div";
}
