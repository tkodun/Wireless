package StepDef;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", 
		glue={"StepDef", "hooks"},
		plugin = {"pretty", "json:target/reports/cucumber.json"}
	)

public class TestRunner {

}
