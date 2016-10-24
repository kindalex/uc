package test;
 
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePageUI;
import pages.LoginPage;
import pages.Utils;
 
public class LoginPageTest extends LoginPage {
	
	@Test
	public void testLogIn() {
		Utils utils = new Utils();
		LoginPage loginPage = new LoginPage();
		HomePageUI homePageUI = new HomePageUI();
		
		loginPage.openPage();
		loginPage.setUserName("admin");
		loginPage.setPassword("Test01--");
		loginPage.clickLogin();
		
		if(!utils.isElementDisplayed(homePageUI.slmMainPageTitleA, 10)) {
			Assert.fail();
		}
	}
}				