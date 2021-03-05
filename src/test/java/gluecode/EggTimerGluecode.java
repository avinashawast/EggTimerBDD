package gluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.hamcrest.number.IsCloseTo;
import org.junit.Assert;

import utilities.ReadProperties;

@SuppressWarnings("deprecation")
public class EggTimerGluecode extends BaseClass {
	
	@Before
	public void initialize() {
		initDriver();
		init(driver);
	}

	@Given("^Eggtimer website is available$")
	public void eggtimer_website_is_avaialble() throws Throwable {
		driver.get(ReadProperties.getInstance().getValue("webURL"));
	}

	@And("^Homepage is loaded properly$")
	public void home_page_is_loaded_properly() {
		String expectedPageLoadStatus = "complete";
		String pageLoadStatus = hp.getPageLoadStatus();
		Assert.assertEquals(expectedPageLoadStatus, pageLoadStatus);
	}

	@When("User enters {string} and clicks Start button")
	public void user_enter_time_and_click_start(String time) {
		hp.setTime(time);
		hp.clickStart();
	}

	@Then("^Countdown timer should start$")
	public void countdown_timer_should_start() {
		Assert.assertEquals(true, tp.isTimerPage());
	}
		
	@And("Counter should decrement by 1 second till {int} seconds")
	public void counter_should_decrement_by_1_till_time_expires(int expectedTimeTaken) {
		long start = System.currentTimeMillis();
		while(! tp.isTimeExpired()) {}	
		long end = System.currentTimeMillis();
		double actualTimeTaken = new Double(util.elapsedTimeinSec(start, end));
		double error = 1.0;
		assertThat(new  Double(actualTimeTaken), new IsCloseTo(expectedTimeTaken, error));
	}
	
	@After()
	public void tearDown() {
		quitDriver();
	}
}