package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import test.LoginPageTest;

public class TestRunner {

	public static WebDriver driver;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://slmwqa04.boeblingen.de.ibm.com/srm-app/web/");
		driver.get("https://slmlqa12.boeblingen.de.ibm.com/srm-app/web/");
		driver.manage().window().maximize();
		
		LoginPageTest login = new LoginPageTest();
		login.testLogIn();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
