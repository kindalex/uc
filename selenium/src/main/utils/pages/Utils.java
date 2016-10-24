package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends TestRunner {
//	Constants declaration
	public final String TEST_USER_NAME = "slm_test_user";

	public Utils() {
		PageFactory.initElements(driver, this);
	}

	public void pause(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
	public Boolean isElementDisplayed(WebElement element, Integer seconds) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		for (int i=0;i<=seconds;i++) {
			try {
				if (element.isDisplayed()) {
					System.out.print("Element '" + element.getText() + "' is dispalyed!\r\n");
					return true;
				} else {
				   i++;
				   pause(1);
				}
			}
			catch (Exception e){
				String exceptionText;
				exceptionText = e.toString().substring(0, e.toString().indexOf(":", 0)).toLowerCase(); 
				switch (exceptionText) {
					case "org.openqa.selenium.nosuchelementexception": 
						System.out.print(exceptionText);
					break;
					case "org.openqa.selenium.staleelementreferenceexception": 
						System.out.print(exceptionText);
						wait.until(ExpectedConditions.stalenessOf(element));
					break;
				}
			}
		}
		System.out.print("Element '" + element.getText() + "' is NOT dispalyed!\r\n");
		return false;
	}

	public boolean isElementVisibleByXpath(String xpath) {
		try {
			if (getElementByXpath(xpath).isDisplayed()) {
				System.out.print("Element '" + xpath + "' is visible!\r\n");
				return true;
			} 
		}
		catch (NullPointerException e) {
			System.out.print("Element '" + xpath + "' is NOT visible!\r\n");
			return false;
		}
		return false;
	}
	
	public boolean findElementByXpath(String xpath) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		pause(1);
		try {
			driver.findElement(By.xpath(xpath));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.print("Element '" + xpath + "' is found!\r\n");
			return true;
		}
		catch (org.openqa.selenium.NoSuchElementException ex) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.print("Element '" + xpath + "' is NOT found!\r\n");
			return false;
		}
	}
	
	public WebElement getElementByXpath(String xpath) {
		WebElement element;
		try {
			element = driver.findElement(By.xpath(xpath));
			System.out.print("Element '" + xpath + "' is got!\r\n");
			return element;
		}
		catch (org.openqa.selenium.NoSuchElementException ex) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.print("Element '" + xpath + "' is NOT got!\r\n");
			return null;
		}
	}
	public List<WebElement> getElementsByXpath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}
	public WebElement get(List<WebElement> elementList, Integer rowNumber) {
		return elementList.get(rowNumber);
	}
	public Integer getSize(List<WebElement> elementList) {
		return elementList.size();
	}
	
	public void click(WebElement element) {
		pause(1);
		if(isElementDisplayed(element, 10)) {
			element.click();
		}
	}

	public void sendKeys(WebElement element, String keys) {
		if(isElementDisplayed(element, 10)) {
			element.clear();
			element.sendKeys(keys);
		}
	}
	
	public String getText(WebElement element) {
		if(isElementDisplayed(element, 10)) {
			return element.getText();
		}
		return null;
	}
	
	public String getAttribute(WebElement element, String attribute) {
		if(isElementDisplayed(element, 10)) {
			return element.getAttribute(attribute);
		}
		return null;
	}

	public String selectItemByXpath(String selectXpath, String item) {
		WebElement element = getElementByXpath(selectXpath); 
		Select select = new Select(element);
		
		String id = getElementByXpath(selectXpath + "//option[text()='" + item + "']").getAttribute("id");
		Integer selectOptionId = Integer.valueOf(id.substring(id.lastIndexOf("_") + 1));
		
		try {
			select.selectByIndex(Integer.valueOf(selectOptionId));
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		
		String selectedItem = select.getAllSelectedOptions().get(0).getText();
		
		return selectedItem;
	}
}
