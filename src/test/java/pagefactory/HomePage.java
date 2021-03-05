package pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(id = "EggTimer-start-time-input-text")
	WebElement enterTime;
	
	@FindBy(xpath = "//button[text()=\"Start\"]")
	WebElement startBtn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setTime(String time) {
		enterTime.sendKeys(time);
	}

	public void clickStart() {
		startBtn.click();
	}
	
	public String getPageLoadStatus() {
		String pageLoadStatus = null;
		JavascriptExecutor js;
		do {
			js = (JavascriptExecutor) driver;
			pageLoadStatus = (String)js.executeScript("return document.readyState");
		}while(!pageLoadStatus.equalsIgnoreCase("complete"));
		return pageLoadStatus;
	} 
}
