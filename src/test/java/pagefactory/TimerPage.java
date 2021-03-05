package pagefactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadProperties;

public class TimerPage {
	WebDriver driver;
	WebDriverWait expWait;

	@FindBy(xpath = "//span[text()='Time Expired!']")
	WebElement expiredTime;

	@FindBy(xpath = "//a[@class='EggTimer-timer-bar-back']")
	WebElement backBtn;

	@SuppressWarnings("deprecation")
	public TimerPage(WebDriver driver) {
		this.driver = driver;
		this.expWait = new WebDriverWait(this.driver, Long.parseLong(ReadProperties.getInstance().getValue("maxTimeOut")));
		PageFactory.initElements(driver, this);
	}
	
	public boolean isTimerPage() {
		try {
			expWait.until(ExpectedConditions.elementToBeClickable(backBtn));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public Boolean isTimeExpired() {
		expWait.until(ExpectedConditions.alertIsPresent());
		acceptAlert();
		return true;
	}

	private void acceptAlert() {
		if(isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println("Alert detected. " + alertMessage);	
			alert.accept();	
		}
	}

	private boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex){
			return false;
		}
	}
}