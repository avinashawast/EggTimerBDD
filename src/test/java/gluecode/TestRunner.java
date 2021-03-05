package gluecode;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue={"gluecode"},
		monochrome=true,
		plugin= {
				"usage",
				"junit:reports/JunitReports/report.xml",
				"json:reports/JSONReport/report.json",
				"html:reports/HTMLReport/report.html"}
		)
public class TestRunner {

}