package gluecode;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.HomePage;
import pagefactory.TimerPage;
import utilities.ReadProperties;
import utilities.Util;

public class BaseClass {
	WebDriver driver; 
	
	HomePage hp;
	TimerPage tp;
	Util util;
	
	String currentPath = System.getProperty("user.dir");
	
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver",currentPath+"/src/test/resources/drivers/chromedriver.exe");
		if(ReadProperties.getInstance().getValue("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	
	public void quitDriver() {
		driver.close();
	}
	
	public void init(WebDriver driver) {
		hp = new HomePage(driver);
		tp = new TimerPage(driver);
		util = new Util();
	}
}
