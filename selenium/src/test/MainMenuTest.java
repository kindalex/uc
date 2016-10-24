package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HomePageUI;
import pages.Utils;

public class MainMenuTest extends HomePage {
	
	@Test
	public void testMenuGetOpened() {
		WebElement menuItem;
		Integer i;
		String menuItemText, activeViewHeaderXP;
		
		HomePageUI homePageUI = new HomePageUI();
		Utils utils = new Utils();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		Integer menuItemsCount = homePageUI.allMenuItemsList.size();

		for(i = 0; i < menuItemsCount - 1; i++) {
			menuItem = homePageUI.allMenuItemsList.get(i);
			if(utils.getAttribute(menuItem, homePageUI.MENU_ITEM_ATTRIBUTE) != null) {
				utils.click(menuItem);
				continue;
			}
			utils.click(menuItem);
			wait.until(ExpectedConditions.stalenessOf(menuItem));
			menuItem = homePageUI.allMenuItemsList.get(i);
			menuItemText = utils.getText(menuItem);

			activeViewHeaderXP = (homePageUI.ACTIVE_VIEW_HEADER_XP + "'" + menuItemText + "')]").
					replace(homePageUI.SUBMENU_ITEM_ASSESSMENT_TEXT, homePageUI.ASSESSMENT_VIEW_HEADER_TEXT).
					replace(homePageUI.SUBMENU_ITEM_DATA_IMPORTS_TEXT, homePageUI.DATA_IMPORTS_VIEW_HEADER_TEXT).
					replace(homePageUI.SUBMENU_ITEM_DATA_EXPORTS_TEXT, homePageUI.DATA_EXPORTS_VIEW_HEADER_TEXT);
			
			if(!utils.isElementDisplayed(utils.getElementByXpath(activeViewHeaderXP), 20)) {
				Assert.fail();
			}
		}
	}
}