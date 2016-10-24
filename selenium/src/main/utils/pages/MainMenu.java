package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainMenu extends TestRunner {
	public String xpath = "//div[@role='menubar']//child::ul[@class='es-ui-menu']/li";
	
	public MainMenu() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getMenuItems() {
//		WebElement menuItem = driver.findElement(By.xpath("//div[@role='menubar']//child::ul[@class='es-ui-menu']/li"));

		List<WebElement> menuItems = driver.findElements(By.xpath(xpath));
		
		return menuItems;
	}
}
