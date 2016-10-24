package pages;
 
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class HomePage extends TestRunner {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	Utils utils = new Utils();
	HomePageUI hpui = new HomePageUI();
	
	public List<WebElement> getSubMenuItemsListByXpath(String xpath) {
		return utils.getElementsByXpath(xpath);
	}
	
	public void goToApp(String app) {
		WebElement appLink, navBoxDiv;
		
		if(app == "SLM") {
			appLink = hpui.ssmMainPageTitleA;
			navBoxDiv = hpui.slmNavBox;
		} else {
			appLink = hpui.slmMainPageTitleA; 
			navBoxDiv = hpui.ssmNavBox;
		}
			
		utils.click(appLink);
		utils.click(navBoxDiv);
	}
	
	public void clickMenuByText(String menuText, String subMenuText) {
		WebElement menu;
		WebDriverWait wait = new WebDriverWait(driver, 10);

		final String TEXT_TO_BE_REPLACED = "<text>";
				
		String menuXP = hpui.MENU_ITEM_BY_TEXT_XP.replace(TEXT_TO_BE_REPLACED, "'" + menuText + "'");
		String subMenuXP = hpui.SUBMENU_ITEM_BY_TEXT_XP.replace(TEXT_TO_BE_REPLACED, "'" + subMenuText + "'");
		
		utils.click(utils.getElementByXpath(menuXP));
		menu = utils.getElementByXpath(menuXP + subMenuXP);
		utils.click(menu);
		wait.until(ExpectedConditions.stalenessOf(menu));
		menu = utils.getElementByXpath(menuXP + subMenuXP);
	}
}
	