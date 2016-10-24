package pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;


public class SSMFormPage extends TestRunner {
	public SSMFormPage() {
		PageFactory.initElements(driver, this);
	}
	
	Utils utils = new Utils();
	SSMHomePageUI ssmHpui = new SSMHomePageUI();
	SSMFormPageUI ssmFormPageUI = new SSMFormPageUI();
	
	public void closeForm(String title) {
//		boolean isElement;
		
		String closeButtonXP = ssmFormPageUI.ssmFormCloseImgXP.replace("User - <username>", title);
		WebElement element = utils.getElementByXpath(closeButtonXP);
		utils.click(element);
		utils.findElementByXpath(closeButtonXP);
/*		do {
			isElement = utils.findElementByXpath(closeButtonXP);
		} while (isElement);
*/	}
	
	public String selectRandomItemByXpath(String selectXpath) {
		Random rand = new Random();
		
		Integer newItemNumber;
		
		WebElement element = utils.getElementByXpath(selectXpath); 
		Select select = new Select(element);
		
		String selectedItem = select.getAllSelectedOptions().get(0).getText();
		String selectedId = utils.getElementByXpath(selectXpath + "//option[text()='" + selectedItem + "']").getAttribute("id");
		Integer selectedItemNumber = Integer.valueOf(selectedId.substring(selectedId.lastIndexOf("_") + 1));
		Integer itemNumbers = utils.getElementsByXpath(selectXpath + "/option").size(); 
		
		do {
			newItemNumber = rand.nextInt(itemNumbers);
		} while(selectedItemNumber == newItemNumber || newItemNumber == 0);
		
		try {
			select.selectByIndex(newItemNumber);
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		
		return select.getAllSelectedOptions().get(0).getText();
	}
}
