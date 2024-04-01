package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"stepDefinitions", "hooks"},
        features = "src/test/resources/features/testExchangeBaseUSD",
        plugin = {"pretty","html:target/cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
