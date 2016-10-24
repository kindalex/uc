package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends TestRunner {
	public FormPage() {
		PageFactory.initElements(driver, this);
	}
	
	Utils utils = new Utils();
	FormPageUI formPageUI = new FormPageUI();

	public void setInput(String inputNameXP, String value) {
		inputNameXP = formPageUI.formFilterInputXP.replace("<FilterName>", inputNameXP);
		
		utils.sendKeys(utils.getElementByXpath(inputNameXP), value);
	}
	
	public void clickButton(String buttonName) {
		WebElement element = null;
		
		utils.pause(1);
		
		switch (buttonName) {
			case "Search":
				element = formPageUI.formSearchButton;
			break;
			case "Reset":
				element = formPageUI.formResetButton;
			break;
			case "Open":
				element = formPageUI.formOpenButton;
			break;
		};
		utils.click(element);
		utils.pause(1);
	}
	
	public Integer tableGetRowsCount() {
		utils.isElementDisplayed(formPageUI.formTable, 10);
		
		return utils.getSize(formPageUI.formTableAllRows);
	}

	public Integer tableGetColumnsCount() {
		utils.isElementDisplayed(formPageUI.formTable, 10);
		
		return utils.getSize(formPageUI.formTableAllColumns);
	}
	
	public Integer tableGetColumnNumberByName(String colName) {
		int i;
		int size = utils.getSize(formPageUI.formTableAllColumns);
		
		for (i = 1; i <= size; i++) {
			if (utils.getText(utils.getElementByXpath(formPageUI.FORM_TABLE_ALL_COLUMNS_XP + "[" + i + "]/div/div")).equals(colName))
				return i;
		}
		return -1;
	}

	public String tableGetColumnNameByNumber(int colNumber) {
		try {
			return utils.getText(utils.getElementByXpath(formPageUI.FORM_TABLE_ALL_COLUMNS_XP + "[" + colNumber + "]/div/div")); 
		}
		catch(Exception ex) {
			return "NOT_FOUND";
		}
	}
	
	public Integer tableSetActiveRow(Integer rowNumber) {
		utils.isElementDisplayed(formPageUI.formTable, 10);
		
		try {
			utils.click(utils.get(formPageUI.formTableAllRows, rowNumber));
		}
		catch(Exception ex) {
			return -1;
		}
			return rowNumber;
	}
	
	public String tableGetCellData(Integer rowNumber, String colName) {
		Integer colNumber = this.tableGetColumnNumberByName(colName) + 1;
		String cellXP = formPageUI.FORM_TABLE_ALL_ROWS_XP + formPageUI.FORM_TABLE_CELL_SUFFIX_XP;
		cellXP = cellXP.replace("<row>", rowNumber.toString());
		cellXP = cellXP.replace("<column>", colNumber.toString());

		return utils.getText(utils.getElementByXpath(cellXP));
	}
	
	public String tableGetCellData(Integer rowNumber, Integer colNumber) {
		String cellXP = formPageUI.FORM_TABLE_ALL_ROWS_XP + formPageUI.FORM_TABLE_CELL_SUFFIX_XP;
		cellXP = cellXP.replace("<row>", rowNumber.toString());
		cellXP = cellXP.replace("<column>", colNumber.toString());

		return utils.getText(utils.getElementByXpath(cellXP));
	}
}

