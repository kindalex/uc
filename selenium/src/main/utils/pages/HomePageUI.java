package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageUI extends TestRunner {
	public HomePageUI() {
		PageFactory.initElements(driver, this);
	}

//	Constants declaration
	public final String APP_SSM = "SSM";
	public final String APP_SLM = "SLM";
	
	public final String USER_NAME_FOR_XPATH = "<username>";

	
	public final String MENU_ITEM_ATTRIBUTE = "data-dojo-attach-point";
	public final String ASSESSMENT_VIEW_HEADER_TEXT = "Assessment";
	public final String DATA_IMPORTS_VIEW_HEADER_TEXT = "Import";
	public final String SUBMENU_ITEM_DATA_EXPORTS_TEXT = "Data Exports";
	public final String DATA_EXPORTS_VIEW_HEADER_TEXT = "Export";

	public final String MENU_ITEM_MASTER_DATA_TEXT = "Master Data";
	public final String SUBMENU_ITEM_SUPPLIERS_TEXT = "Suppliers";
	public final String SUBMENU_ITEM_CATEGORIES_TEXT = "Categories";
	public final String SUBMENU_ITEM_ORGANIZATIONS_TEXT = "Organizations";

	public final String MENU_ITEM_SUPPLIER_QUALIFICATION_TEXT = "Supplier Qualification";
	public final String SUBMENU_ITEM_ASSESSMENT_TEXT = "Assess.";
	public final String SUBMENU_ITEM_DATA_IMPORTS_TEXT = "Data Imports";

	public final String MENU_ITEM_USER_MANAGEMENT_TEXT = "User Management";
	public final String SUBMENU_ITEM_INTERNAL_USERS_TEXT = "Internal Users";

	public final String MENU_ITEM_DATA_EXCHANGE = "Data Exchange";
	public final String SUBMENU_ITEM_JMS_AUDIT_TEXT = "Jms Audit";
	
//	xpathes declaration
	public final String SLM_MAIN_PAGE_TITLE_XP = "//strong[contains(text(), 'Supplier Lifecycle Management')]";
	public final String SSM_MAIN_PAGE_TITLE_XP = "//div[contains(text(), 'Virtual Supply Master')]";
	public final String ACTIVE_VIEW_HEADER_XP = "//h1[contains(text(), ";
	public final String MENU_ITEMS_LIST_XP = "//div[@role='menubar']//child::ul[@class='es-ui-menu']/li";
	public final String SUBMENU_ITEMS_LIST_XP = "//div[@role='menubar']//child::ul[@class='es-ui-menu']/li/ul/li";
	public final String ALL_MENU_ITEMS_XP = "//div[@role='menubar']//child::ul[@class='es-ui-menu']//following::li";
	public final String MENU_ITEM_BY_TEXT_XP = "//div[@role='menubar']//child::ul[@class='es-ui-menu']/li/span/a[contains(text(), <text>)]";
	public final String SUBMENU_ITEM_BY_TEXT_XP = "/parent::span/parent::li/ul/li/span/a[contains(text(), <text>)]";
	public final String SLM_NAVIGATION_BOX_XP = "//div[@aria-label='Supplier Lifecycle Management']"; 
	public final String SSM_NAVIGATION_BOX_XP = "//div[@aria-label='Virtual Supply Master']"; 
	
//	Element finders
	@FindBy(xpath = SLM_NAVIGATION_BOX_XP)
	public WebElement slmNavBox;

	@FindBy(xpath = SSM_NAVIGATION_BOX_XP)
	public WebElement ssmNavBox;

	@FindBy(xpath = SLM_MAIN_PAGE_TITLE_XP)
	public WebElement slmMainPageTitleA;

	@FindBy(xpath = SSM_MAIN_PAGE_TITLE_XP)
	public WebElement ssmMainPageTitleA;
	
	@FindBy(xpath = ACTIVE_VIEW_HEADER_XP)
	public WebElement activeViewHeaderH1;
	
	@FindBy(xpath = MENU_ITEMS_LIST_XP)
	public List<WebElement> menuItemsList;

	@FindBy(xpath = SUBMENU_ITEMS_LIST_XP)
	public List<WebElement> subMenuItemsList;

	@FindBy(xpath = ALL_MENU_ITEMS_XP)
	public List<WebElement> allMenuItemsList;
	
}
