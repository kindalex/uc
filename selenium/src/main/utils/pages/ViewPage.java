package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ViewPage extends TestRunner {
	public ViewPage() {
		PageFactory.initElements(driver, this);
	}
	
	Utils utils = new Utils();
	ViewPageUI viewPageUI = new ViewPageUI(); 
	FormPageUI formPageUI = new FormPageUI();
	
	public void boxClick(String boxName) {
		utils.click(utils.getElementByXpath(viewPageUI.viewBoxHeaderXP.replace("<HeaderName>", boxName)));
	}
	
	public boolean isBoxExpanded (String boxName) {
		String className = utils.getElementByXpath(viewPageUI.viewBoxHeaderXP.replace("<HeaderName>", boxName) + viewPageUI.VIEW_BOX_HEADER_XP_EXTENSION).
			getAttribute("class");

		if (className.contains("in")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getBoxFieldValue(String boxName, String fieldName) {
		utils.pause(1);
		
		String text;
		
		if (!this.isBoxExpanded(boxName)) {
			this.boxClick(boxName);
		}
		
		String xpath = viewPageUI.viewBoxItemXP.replace("<HeaderName>", boxName).
				replace("<FieldName>", fieldName);
		
		text = utils.getElementByXpath(xpath).getText();
		
		return text;
	}
	
	public String getContainerName(String elementXP) {
		return utils.getText(utils.getElementByXpath(elementXP + viewPageUI.VIEW_BOX_CONTAINER_A_XP_EXTENSION));
	}
}