package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/LoginCRM.feature",
		glue = "stepdef",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		dryRun=false
		)


public class LoginRunnerClass extends AbstractTestNGCucumberTests {
}
