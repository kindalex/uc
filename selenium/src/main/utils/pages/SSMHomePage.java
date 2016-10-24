package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSMHomePage extends TestRunner {
	public SSMHomePage() {
		PageFactory.initElements(driver, this);
	}

	Utils utils = new Utils();
	SSMHomePageUI ssmHpui = new SSMHomePageUI();

	public void clickMenuByText(String menuText) {
		WebElement menu;
		String menuXP = "";

		WebDriverWait wait = new WebDriverWait(driver, 10);

		switch (menuText) {
			case "Users": menuXP = ssmHpui.SSM_USERS_MENU_ITEM_XP;
			break;
		}
		
		menu = utils.getElementByXpath(menuXP);
		utils.click(menu);
		wait.until(ExpectedConditions.stalenessOf(menu));
		menu = utils.getElementByXpath(menuXP);
	}
	
	public void clickLinkByXpath(String linkXP) {
		WebElement link;
		
		link = utils.getElementByXpath(linkXP);
		utils.click(link);
/*		wait.until(ExpectedConditions.stalenessOf(link));
		link = utils.getElementByXpath(linkXP);
*/	}
	
	public void searchItemByXpath(String whereToSearchXP, String whatToSearch) {
		WebElement whereToSearchInput; 
		
		utils.click(ssmHpui.ssmSearchLink);
		
		whereToSearchInput = utils.getElementByXpath(whereToSearchXP);
		utils.sendKeys(whereToSearchInput, whatToSearch);
		whereToSearchInput.sendKeys(Keys.ENTER);
		
	}
}
